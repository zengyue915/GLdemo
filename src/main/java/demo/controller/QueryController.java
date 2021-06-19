package demo.controller;

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

@Slf4j
@Controller
public class QueryController {
    @Autowired
    private ICoodinatesService coodinatesService;

    @GetMapping("/queryresult")
    public String queryResult(@RequestParam(required=false, defaultValue = "0.01") String ra,
                                    @RequestParam(required=false, defaultValue = "0.01") String dec,
                                    @RequestParam(required=false) Integer count,
                                    @RequestParam(required=false, defaultValue = "Distance") String order_by,
                              RedirectAttributes redirectAttributes,
                              Model model)
    {
        HashSet<String> possible_order = new HashSet<>(Arrays.asList("RA", "DE", "MagFilter"));
        List<CoordinateVo> result;
        if(order_by.equals("Distance")){
            if(count==null){
                System.out.println("NO ORDER, NO COUNT");
                result = coodinatesService.neighborsDetailsAll(ra, dec);
            }
            else{
                System.out.println("NO ORDER, COUNT");
                result = coodinatesService.neighborsDetailsLimit(ra,dec,count);
            }
        }
        else{
            if(count==null){
                System.out.println("ORDER, NO COUNT");
                result = coodinatesService.neighborsDetailsAllOrder(ra, dec, order_by);
            }
            else{
                System.out.println("ORDER, COUNT");
                result = coodinatesService.neighborsDetailsLimitOrder(ra, dec, count, order_by);
            }
        }


        model.addAttribute("result", result);

        return "queryResult";
    }

}
