package demo.service.impl;

import demo.DemoApplicationTest;
import demo.dao.CoordinatesMapper;
import demo.pojo.Coordinate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoordinatesMapperTest extends DemoApplicationTest {
    @Autowired
    CoordinatesMapper mapper;

    @Test
    public void load(){
        System.out.println();
    }

    public void listCoordinatesInfo3(){
        String dec = "12.56";
        String ra = "66.9";
        Integer count = 20;
        String point = "POINT( " + dec + " " + ra + ")";
        List<Coordinate> result = mapper.listCoordinatesInfoLimit(point, count);
    }
}