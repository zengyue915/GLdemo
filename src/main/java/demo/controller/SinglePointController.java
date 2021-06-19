package demo.controller;

import com.opencsv.CSVWriter;
import demo.service.ICoodinatesService;
import demo.vo.CoordinateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import demo.service.ICoodinatesService;
import demo.vo.CoordinateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
public class SinglePointController {
    @Autowired
    private ICoodinatesService coodinatesService;

    @GetMapping("/singlePoint")
    public String fileDownload(@RequestParam(required=true) String RA,
                               @RequestParam(required=true) String DEC,
                               @RequestParam(required=true) String ID,
                               @RequestParam(required=true) String TYPE,
                               Model model){

        model.addAttribute("RA", RA);
        model.addAttribute("DEC", DEC);
        model.addAttribute("ID", ID);
        model.addAttribute("TYPE", TYPE);

        return "singlePoint";
    }

}
