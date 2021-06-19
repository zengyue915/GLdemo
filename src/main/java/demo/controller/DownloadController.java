package demo.controller;

import com.opencsv.CSVWriter;
import demo.service.ICoodinatesService;
import demo.vo.CoordinateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;

import demo.consts.DemoConst;

import java.io.File;
import java.io.FileWriter;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class DownloadController {
    @Autowired
    private ICoodinatesService coodinatesService;

    @GetMapping("/downloadresult")
    public ResponseEntity<Resource> fileDownload(@RequestParam(required=true) String ra,
                                                 @RequestParam(required=true) String dec,
                                                 @RequestParam(required=true) Integer count) throws MalformedURLException {


        List<CoordinateVo> results= coodinatesService.neighborsDetailsLimit(ra, dec, count);
        String filename = fileNameGenerator(ra, dec, count);
        String filePath =  DemoConst.DOWNLOAD_FILE_LOCATION + "/" + filename;

        System.out.println("[FILEPATH....]"+ filePath);

        String filestatus = fileGenerator(results, filePath);

        Path path = Paths.get(filePath);
        UrlResource resource = new UrlResource(path.toUri());
        String contentType = "application/octet-stream";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);



    }

    private String fileGenerator(List<CoordinateVo> results, String filePath){


        try{
           File file  = new File(filePath);
           FileWriter outputfile = new FileWriter(file);
           CSVWriter writer = new CSVWriter(outputfile);
           String[] header = { "Name", "RA", "DEC", "MagFilter", "MagBrightest", "MagFaintest", "QSOorigin", "Method",
                   "PossibleType", "CandidateStatus", "Notes", "Comments"};
           writer.writeNext(header);

           for(CoordinateVo data: results){
               String[] line = new String[11];
               line[0] = data.getID();
               line[1] = String.valueOf(data.getRA());
               line[2] = String.valueOf(data.getDE());
               line[3] = data.getMagFilter();
               line[4] = String.valueOf(data.getMagBrightness());
               line[5] = String.valueOf((data.getMagFaintest()));
               line[6] = data.getQSOorigin();
               line[7] = data.getMethod();
               line[8] = data.getPossibleType();
               line[9] = data.getCandidateStatus();
               line[10] = data.getNotes();
               line[11] = data.getComment();
               writer.writeNext(line);
           }

           writer.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

        return "filePath";


    }

    private String fileNameGenerator(String ra, String dec, Integer count){
        StringBuilder sb = new StringBuilder();

        if(ra.indexOf(".")>-1){
            sb.append(ra.substring(0, ra.indexOf(".")));
            sb.append("_");
        }
        sb.append(ra.substring(ra.indexOf(".")+1));
        sb.append("+");

        if(dec.indexOf(".")>-1){
            sb.append(dec.substring(0, dec.indexOf(".")));
            sb.append("_");
        }
        sb.append(dec.substring(dec.indexOf(".")+1));
        sb.append("+");

        sb.append(count);
        sb.append(".csv");

        return sb.toString();


    }


}
