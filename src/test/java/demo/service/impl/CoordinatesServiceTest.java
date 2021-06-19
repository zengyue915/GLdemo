package demo.service.impl;

import demo.DemoApplicationTest;
import demo.service.ICoodinatesService;
import demo.vo.CoordinateVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoordinatesServiceTest extends DemoApplicationTest {
    @Autowired
    private ICoodinatesService coodinatesService;

    @Test
    public void neighborsDetails(){
        //List<CoordinateVo> listResponseVo = coodinatesService.neighborsDetails("10", "12.5", 3);

        List<CoordinateVo> listResponseVo2 = coodinatesService.neighborsDetailsLimit("75", "32", 3);
        //ResponseVo<List<CoordinateVo>> listResponseVo = coodinatesService.neighborsDetails("111", "12.5", 3);
    }
}
