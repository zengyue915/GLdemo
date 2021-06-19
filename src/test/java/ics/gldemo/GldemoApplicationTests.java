package ics.gldemo;

import demo.dao.CoordinatesMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GldemoApplicationTests {

    @Autowired
    private CoordinatesMapper coordinatesMapper;

    @Test
    public void contextLoads() {
        //List<String> result = coordinatesMapper.listCoordinates(-73.97, 40.78, 3);
        List<String> result = coordinatesMapper.listCoordinates("st_distance(st_geomfromtext('POINT(76.2 40.78)' , 4326), Coordinates.cords) ", 4);
//        System.out.println("1111111");
        List<String> result2 = coordinatesMapper.getNotesById("GRALJ015703.5+430305.89");
        for(String s:result){
            System.out.println(s);
        }


    }

}
