package demo.controller;

import demo.DemoApplicationTest;
import demo.consts.ColumnConst;
import demo.controller.UploadController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@Transactional
public class UploadControllerTest extends DemoApplicationTest {
    @Autowired
    private UploadController controller;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Test
    public void cscToDB_test() throws Exception {
        String[] Notes = new String[]{"notes"};
        HashSet<String> set = new HashSet<>(Arrays.asList(Notes));

        Assert.assertTrue(set.contains("notes"));




        Path path = Paths.get("C:\\Users\\calvi\\Desktop\\yue_project\\GLdemo\\src\\test\\java\\demo\\controller\\test1.csv");
        String name = "test1.csv";
        String originalFileName = "test1.csv";
        String contentType = "text/plain";
        byte[] content = null;
        try {
            content = Files.readAllBytes(path);
        } catch (IOException e) {
        }
        MockMultipartFile result = new MockMultipartFile(name,
                originalFileName, contentType, content);

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.multipart("/upload")
                        .file("file", result.getBytes())
                .characterEncoding("UTF-8"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/uploadStatus"));



        // controller.cscToDB("C:\\Users\\calvi\\Desktop\\yue_project\\GLdemo\\src\\test\\java\\demo\\controller\\test1.csv");


    }


}