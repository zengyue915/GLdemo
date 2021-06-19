package demo.service;

import demo.vo.CoordinateVo;
import demo.vo.ResponseVo;

import java.util.List;

public interface ICoodinatesService {
    String listCoordinates(String ra, String dec, Integer count);

    //ResponseVo<List<CoordinateVo>>  neighborsDetails(String ra, String dec, Integer count);
    List<CoordinateVo> neighborsDetailsLimit(String ra, String dec, Integer count);

    List<CoordinateVo> neighborsDetailsAll (String ra, String dec);

    List<CoordinateVo> neighborsDetailsLimitOrder(String ra, String dec, Integer count, String order_by);

    List<CoordinateVo> neighborsDetailsAllOrder(String ra, String dec, String order_by);

    void updateComments(String comments, String id);

}
