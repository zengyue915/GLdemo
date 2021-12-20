package demo.controller;


import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import demo.consts.ColumnConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.sql.*;

import java.io.IOException;

import java.util.*;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class DBToSheetController {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static String CREDENTIALS_FILE_PATH = "C:\\Users\\calvi\\Desktop\\yue_project\\GLdemo\\upload\\client_secret_186090729246-l4irkfjndo030endbh59glh2lv0a5ead.apps.googleusercontent.com.json";
    private static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static String TOKENS_DIRECTORY_PATH = "tokens";

    private static HashSet<String> Name = new HashSet<>(Arrays.asList(ColumnConst.Name));
    private static HashSet<String> RA = new HashSet<>(Arrays.asList(ColumnConst.RA));
    private static HashSet<String> DEC = new HashSet<>(Arrays.asList(ColumnConst.DEC));
    private static HashSet<String> MagFilter = new HashSet<>(Arrays.asList(ColumnConst.MagFilter));
    private static HashSet<String> MagBrightest = new HashSet<>(Arrays.asList(ColumnConst.MagBrightest));
    private static HashSet<String> MagFaintest = new HashSet<>(Arrays.asList(ColumnConst.MagFaintest));
    private static HashSet<String> QSOorigin = new HashSet<>(Arrays.asList(ColumnConst.QSOorigin));
    private static HashSet<String> Method = new HashSet<>(Arrays.asList(ColumnConst.Method));
    private static HashSet<String> PossibleType = new HashSet<>(Arrays.asList(ColumnConst.PossibleType));
    private static HashSet<String> CandidatesStatus = new HashSet<>(Arrays.asList(ColumnConst.CandidatesStatus));
    private static HashSet<String> Notes = new HashSet<>(Arrays.asList(ColumnConst.Notes));

    @GetMapping("/db-to-spreadsheet")
    public String queryResult(@RequestParam(required = false, defaultValue = "1AuTAPmVCxBxgtAYInN4u0H9jwwEp3pUHrI2uYPp_tdI") String spreadsheetId,
                              @RequestParam(required = false, defaultValue = "Sheet2") String sheet,
                              @RequestParam(required = false, defaultValue = "coordinates") String table) throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        System.out.println("HERE: " + service.toString());

        System.out.println("SERVICE SHEET>>>>>" + service.spreadsheets().values().get(spreadsheetId, sheet));

        String connURL = demo.consts.DemoConst.DB_URL;
        String username = demo.consts.DemoConst.DB_USERNAME;
        String password = demo.consts.DemoConst.DB_PASSWORD;

        int batchSize = 5;

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connURL, username, password);
            conn.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println(e);
        }

        List<List<Object>> values;
        if (validTable(table, conn)) {
            values = dbToArray(table, conn);
        } else {
            return "error";
        }


        ValueRange body = new ValueRange()
                .setValues(values);

        UpdateValuesResponse result =
                service.spreadsheets().values().update(spreadsheetId, sheet+"!A2", body)
                        .setValueInputOption("RAW")
                        .execute();
        // 2-D Array representing cells of spreadsheet

        return "home";
    }

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        // InputStream in = SyncController.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        InputStream in = new FileInputStream(CREDENTIALS_FILE_PATH);

        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

//        System.out.println("Http: " + HTTP_TRANSPORT);
//        System.out.println("JSON: " + JSON_FACTORY);
//        System.out.println("Secrets: " + clientSecrets.toPrettyString());
//        System.out.println("Scopes: " + SCOPES);

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        // need to find to way to resolve the bind error
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8895).build();

        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public boolean validTable(String table, Connection conn) {
        String query = "SHOW tables;";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            HashSet<String> table_set = new HashSet<>();

            while (rs.next()) {
                String curr_table = rs.getString(1);
                table_set.add(curr_table);
            }

            if (!table_set.contains(table)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<List<Object>> dbToArray(String table, Connection conn) {
        String query = "SELECT * FROM " + table + ";";

        List<List<Object>> values = new ArrayList();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);




            while (rs.next()) {
                String id = rs.getString(1);
                String ra = rs.getString(2);
                String de = rs.getString(3);
                String magFilter = rs.getString(4);
                String magBrightness = rs.getString(5);
                String magFaintest = rs.getString(6);
                String qsOrigin = rs.getString(7);
                String method = rs.getString(8);
                String possibleType = rs.getString(9);
                String candidateStatus = rs.getString(10);
                String note = rs.getString(11);

                List<Object> row = Arrays.asList(
                        id, ra, de, magFilter, magBrightness, magFaintest, qsOrigin,
                        method, possibleType, candidateStatus, note
                );

                values.add(row);
            }

        } catch (Exception e) {

        }

        return values;
    }
}