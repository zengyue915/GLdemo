package demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/getfile")
    public String upLoadFile() {
        return "upload";
    }

    @GetMapping("/query")
    public String toQueryPage(){return "query";}

//    @GetMapping("/error")
//    public String errorPage(){return "error";}

}
