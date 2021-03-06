package demo.controller;


import com.opencsv.CSVReader;
import demo.consts.ColumnConst;
import demo.helper.RAConverter;
import demo.tools.PrintData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import demo.consts.DemoConst;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
public class UploadController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = DemoConst.UPLOAD_FILE_LOCATION;

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


    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }


        cscToDB(file);

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadstatus";
    }

    public void cscToDB(MultipartFile file){

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
                byte[] bytes = file.getBytes();
                String completeData = new String(bytes);
                String[] rows = completeData.split("\n");

                String[] header;
                header = rows[0].split(",");

                //Assign Column Number based on the header
                HashMap<String, Integer> map = new HashMap<>();

                columnMap(map, header);

                PrintData.printMap(map);

                // TODO: future implementation, do not hard code the columns from table -> describe table
                String sql = "INSERT INTO Coordinates (ID , RA, DE, MagFilter, MagBrightness, " +
                        "MagFaintest, QSOorigin, Method, PossibleType, CandidateStatus, Notes, Internal_RA) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


                PreparedStatement statement = conn.prepareStatement(sql);



                int count = 0;

                String row;
                for(int i=1; i<rows[i].length(); i++) {

                    String[] data = rows[i].split(",");

                    //1.Name
                    System.out.println("Name col:" + map.get("Name"));
                    System.out.println(data[map.get("Name")]);
                    statement.setString(1, data[map.get("Name")]);

                    //2.RA
                    int ra_index = map.get("RA");
//              System.out.println(ra_index + " value: " + data[ra_index]);
                    double ra = Double.parseDouble(data[ra_index]);
//                System.out.println(ra);
                    statement.setDouble(2, ra);

                    //3.DEC
                    statement.setString(3, data[map.get("DEC")]);

                    //4.MagFilter
                    statement.setString(4, data[map.get("MagFilter")]);

                    //5.MagBrightness
                    double mb = data[map.get("MagBrightest")].length() == 0 ? 0 : Double.parseDouble(data[map.get("MagBrightest")]);

                    statement.setDouble(5, mb);

                    //6.MagFaintest
                    statement.setDouble(6, Double.parseDouble(data[map.get("MagFaintest")]));

                    //7.QSOorigins
                    statement.setString(7, data[map.get("QSOorigin")]);

                    //8.Method
                    statement.setString(8, data[map.get("Method")]);

                    //9.PossibleType
                    statement.setString(9, data[map.get("PossibleType")]);

                    //10.CandidatesStatus
                    statement.setString(10, data[map.get("CandidatesStatus")]);

                    //11.Notes
                    statement.setString(11, data[map.get("Notes")]);

                    //12.Internal_RA
                    double internal_ra = RAConverter.RAto180(ra);
                    statement.setDouble(12, internal_ra);

                    statement.execute();

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