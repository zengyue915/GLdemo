package demo.controller;


import com.opencsv.CSVReader;
import demo.consts.ColumnConst;
import demo.helper.RAConverter;
import demo.service.ICoodinatesService;
import demo.tools.PrintData;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
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


@Slf4j
@Controller
public class CommentController {
    @Autowired
    private ICoodinatesService coodinatesService;

    @PostMapping("/addComments")
    public String queryResult(@RequestParam(required=false) String comments,
                              @RequestParam(required=false) String id,
                              HttpServletRequest request,
                              @RequestBody String requestString)
    {
        System.out.println(requestString);
        System.out.println(comments);
        try {
            JSONObject jsonObject = new JSONObject(requestString);
            coodinatesService.updateComments(jsonObject.getString("comments"), jsonObject.getString("id"));
        }catch (JSONException err){
            err.printStackTrace();;
        }
//        String ID = id.replaceAll("^[ \t]+|[ \t]+$", "").replace(' ','+' );
//        System.out.println(id.replaceAll("^[ \t]+|[ \t]+$", "").replace(' ','+' ));
        //coodinatesService.updateComments(comments, id);

        return "query";

    }
}
