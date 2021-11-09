package demo.controller;


import com.opencsv.CSVReader;
import demo.consts.ColumnConst;
import demo.helper.RAConverter;
import demo.service.ICoodinatesService;
import demo.tools.PrintData;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import demo.consts.DemoConst;

import javax.servlet.http.HttpServletRequest;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class SyncController {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static String CREDENTIALS_FILE_PATH = "C:\\Users\\calvi\\Desktop\\yue_project\\GLdemo\\upload\\client_secret_186090729246-l4irkfjndo030endbh59glh2lv0a5ead.apps.googleusercontent.com.json";
    private static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static String TOKENS_DIRECTORY_PATH = "tokens";

    private static HashSet<String> Name = new HashSet<>(Arrays.asList(ColumnConst.Name));
    private static HashSet<String> RA= new HashSet<>(Arrays.asList(ColumnConst.RA));
    private static HashSet<String> DEC = new HashSet<>(Arrays.asList(ColumnConst.DEC));
    private static HashSet<String> MagFilter = new HashSet<>(Arrays.asList(ColumnConst.MagFilter));
    private static HashSet<String> MagBrightest = new HashSet<>(Arrays.asList(ColumnConst.MagBrightest));
    private static HashSet<String> MagFaintest= new HashSet<>(Arrays.asList(ColumnConst.MagFaintest));
    private static HashSet<String> QSOorigin= new HashSet<>(Arrays.asList(ColumnConst.QSOorigin));
    private static HashSet<String> Method= new HashSet<>(Arrays.asList(ColumnConst.Method));
    private static HashSet<String> PossibleType= new HashSet<>(Arrays.asList(ColumnConst.PossibleType));
    private static HashSet<String> CandidatesStatus= new HashSet<>(Arrays.asList(ColumnConst.CandidatesStatus));
    private static HashSet<String> Notes= new HashSet<>(Arrays.asList(ColumnConst.Notes));

    @GetMapping("/spreadsheet")
    public String queryResult(@RequestParam(required=false, defaultValue = "1AuTAPmVCxBxgtAYInN4u0H9jwwEp3pUHrI2uYPp_tdI") String spreadsheetId,
                              @RequestParam(required=false, defaultValue = "Sheet1") String sheet,
                              @RequestParam(required=false, defaultValue = "coordinates") String table) throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        System.out.println("HERE: " + service.toString());

        System.out.println("SERVICE SHEET>>>>>" +service.spreadsheets().values().get(spreadsheetId, sheet));

        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, sheet)
                .execute();

        // 2-D Array representing cells of spreadsheet
        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            listToDB(values, table);
        }

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

    public void listToDB(List<List<Object>> completeData, String table){

        String connURL = demo.consts.DemoConst.DB_URL;
        String username = demo.consts.DemoConst.DB_USERNAME;
        String password = demo.consts.DemoConst.DB_PASSWORD;

        int batchSize = 5;

        Connection conn = null;


        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connURL, username, password);
            conn.setAutoCommit(false);

            // FileReader filereader = new FileReader(csvFilePath);
            // CSVReader csvReader = new CSVReader(filereader);


            // List<String[]> allData = csvReader.readAll();
            try {

                String[] header = new String[11];

                int headerNumber = 0;
                for (Object element : completeData.get(0)) {
                    header[headerNumber] = element.toString();
                    headerNumber++;
                }


//                int rowNumber = 0;
//                int columnNumber = 0;
//                for (List<Object> row : completeData.get(0)) {
//                    columnNumber = 0;
//
//                    for (Object element : row) {
//                        if (rowNumber == 0) {
//                            header[columnNumber] = element.toString();
//
//
//                            columnNumber++;
//                        }
//                        else {
//
//                        }
//                    }
//                    rowNumber++;
//                }

                //Assign Column Number based on the header
                HashMap<String, Integer> map = new HashMap<>();

                columnMap(map, header);

                PrintData.printMap(map);

                // TODO: change the table to question mark later
                //       ask professor!
                String sql = "INSERT INTO " + table + " (ID , RA, DE, MagFilter, MagBrightness, " +
                        "MagFaintest, QSOorigin, Method, PossibleType, CandidateStatus, Notes, Internal_RA) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


                PreparedStatement statement = conn.prepareStatement(sql);



                int count = 0;


                String row;
                for(int i=1; i<completeData.size(); i++) {
                    List<Object> data = completeData.get(i);

                    //1.Name
                    System.out.println("Name col:" + map.get("Name"));
                    System.out.println(data.get(map.get("Name")));
                    statement.setString(1, data.get(map.get("Name")).toString());

                    //2.RA
                    int ra_index = map.get("RA");
//              System.out.println(ra_index + " value: " + data[ra_index]);
                    double ra = Double.parseDouble(data.get(ra_index).toString());
//                System.out.println(ra);
                    statement.setDouble(2, ra);

                    //3.DEC
                    statement.setString(3, data.get(map.get("DEC")).toString());

                    //4.MagFilter
                    statement.setString(4, data.get(map.get("MagFilter")).toString());

                    //5.MagBrightness
                    double mb = data.get(map.get("MagBrightest")).toString().length() == 0 ? 0 : Double.parseDouble(data.get(map.get("MagBrightest")).toString());

                    statement.setDouble(5, mb);

                    //6.MagFaintest
                    statement.setDouble(6, Double.parseDouble(data.get(map.get("MagFaintest")).toString()));

                    //7.QSOorigins
                    statement.setString(7, data.get(map.get("QSOorigin")).toString());

                    //8.Method
                    statement.setString(8, data.get(map.get("Method")).toString());

                    //9.PossibleType
                    statement.setString(9, data.get(map.get("PossibleType")).toString());

                    //10.CandidatesStatus
                    statement.setString(10, data.get(map.get("CandidatesStatus")).toString());

                    //11.Notes
                    statement.setString(11, data.get(map.get("Notes")).toString());

                    //12.Internal_RA
                    double internal_ra = RAConverter.RAto180(ra);
                    statement.setDouble(12, internal_ra);

                    statement.addBatch();
                    count++;

                    if (count % batchSize == 0) {
                        statement.executeBatch();
                    }
                }

                // execute the remaining queries
                statement.executeBatch();

                String update = "UPDATE geo_db.Coordinates set cords = ST_GeomFromText(ST_AsText(Point(DE, Internal_RA)),4326);";
                PreparedStatement update_statement = conn.prepareStatement(update);
                update_statement.execute();

            } catch (Exception e) {
            };

            conn.commit();
            conn.close();


        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void columnMap(HashMap<String, Integer> map, String[] headers) throws Exception {
        try {

            System.out.println("length:" + headers.length);
            PrintData.printList(headers);

            for (int i = 0; i < headers.length; i++) {
                String lower_case = headers[i].toLowerCase().trim();
                System.out.println(lower_case);
                if (Name.contains(lower_case) && !map.containsKey("Name")) {
                    System.out.println("LOL >>> Name");
                    map.put("Name", i);
                } else if (RA.contains(lower_case) && !map.containsKey("RA")) {
                    System.out.println("LOL >>> RA");
                    map.put("RA", i);
                } else if (DEC.contains(lower_case) && !map.containsKey("DEC")) {
                    System.out.println("LOL >>> DEC");
                    map.put("DEC", i);
                } else if (MagFilter.contains(lower_case) && !map.containsKey("MagFilter")) {
                    System.out.println("LOL >>> MagFilter");
                    map.put("MagFilter", i);
                } else if (MagBrightest.contains(lower_case) && !map.containsKey("MagBrightest")) {
                    System.out.println("LOL >>> MagBrightest");
                    map.put("MagBrightest", i);
                } else if (MagFaintest.contains(lower_case) && !map.containsKey("MagFaintest")) {
                    System.out.println("LOL >>> MagFaintest");
                    map.put("MagFaintest", i);
                } else if (QSOorigin.contains(lower_case) && !map.containsKey("QSOorigin")) {
                    System.out.println("LOL >>> QSorigin");
                    map.put("QSOorigin", i);
                } else if (Method.contains(lower_case) && !map.containsKey("Method")) {
                    System.out.println("LOL >>> Method");
                    map.put("Method", i);
                } else if (PossibleType.contains(lower_case) && !map.containsKey("PossibleType")) {
                    System.out.println("LOL >>> PossibleType");
                    map.put("PossibleType", i);
                } else if (CandidatesStatus.contains(lower_case) && !map.containsKey("CandidatesStatus")) {
                    System.out.println("LOL >>> CandidatesStatus BEFORE");
                    map.put("CandidatesStatus", i);
                } else if (Notes.contains(lower_case)) { // && !map.containsKey("Notes")) {
                    System.out.println("LOL >>> Notes");
                    map.put("Notes", i);
                } else {
                    System.out.println("not matched: ");
                    System.out.println(headers[i].length());
                    System.out.println(headers[i]);
                    throw new Exception("Column Cannot Match");
                }



            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}

