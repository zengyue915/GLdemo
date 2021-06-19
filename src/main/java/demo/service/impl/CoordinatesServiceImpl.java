package demo.service.impl;


//import com.google.gson.Gson;
import com.google.gson.Gson;
import demo.dao.CoordinatesMapper;
import demo.helper.RAConverter;
import demo.pojo.Coordinate;
import demo.service.ICoodinatesService;
import demo.vo.CoordinateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@Transactional
public class CoordinatesServiceImpl implements ICoodinatesService{
    @Autowired
    private CoordinatesMapper coordinatesMapper;

    @Override
    public String listCoordinates(String ra, String dec, Integer count) {
        //String query = "st_distance(st_geomfromtext('POINT(76.2 40.78)' , 4326), Coordinates.cords) ";
        Double ra_double = RAConverter.RAto180(ra);
        ra = String.valueOf(ra_double);

        String query = "st_distance(st_geomfromtext('POINT(" +
                dec +" " +ra+")' , 4326), Coordinates.cords) ";

        List<String> result = coordinatesMapper.listCoordinates(query, count);
        String json = new Gson().toJson(result);
        return json;
    }

    @Override
    public List<CoordinateVo> neighborsDetailsLimit(String ra, String dec, Integer count) {

        Double ra_double = RAConverter.RAto180(ra);
        ra = String.valueOf(ra_double);

        String query = "st_distance(st_geomfromtext('POINT(" +
                dec + " " +ra+")' , 4326), Coordinates.cords) ";


        String point = "POINT( " + dec + " " + ra + ")";
        List<Coordinate> result = coordinatesMapper.listCoordinatesInfoLimit(point, count);

        List<CoordinateVo> coordinateVos = new ArrayList();
        for(Coordinate c: result){

            coordinateVos.add(coordinate2CoodinateVo(c));
        }

        return coordinateVos;
    }

    @Override
    public List<CoordinateVo> neighborsDetailsAll(String ra, String dec) {

        Double ra_double = RAConverter.RAto180(ra);
        ra = String.valueOf(ra_double);

        String query = "st_distance(st_geomfromtext('POINT(" +
                dec + " " +ra+")' , 4326), Coordinates.cords) ";

        String point = "POINT( " + dec + " " + ra + ")";
        List<Coordinate> result = coordinatesMapper.listCoordinatesInfoAll(point);

        List<CoordinateVo> coordinateVos = new ArrayList();
        for(Coordinate c: result){

            coordinateVos.add(coordinate2CoodinateVo(c));
        }

        return coordinateVos;
    }



    @Override
    public List<CoordinateVo> neighborsDetailsLimitOrder(String ra, String dec, Integer count, String order) {

        Double ra_double = RAConverter.RAto180(ra);
        ra = String.valueOf(ra_double);

        String query = "st_distance(st_geomfromtext('POINT(" +
                dec + " " +ra+")' , 4326), Coordinates.cords) ";


        String point = "POINT( " + dec + " " + ra + ")";
        List<Coordinate> result = coordinatesMapper.listCoordinatesInfoLimitByOrder(point, count, order);

        List<CoordinateVo> coordinateVos = new ArrayList();
        for(Coordinate c: result){

            coordinateVos.add(coordinate2CoodinateVo(c));
        }

        return coordinateVos;
    }

    @Override
    public List<CoordinateVo> neighborsDetailsAllOrder(String ra, String dec, String order) {

        Double ra_double = RAConverter.RAto180(ra);
        ra = String.valueOf(ra_double);

        String query = "st_distance(st_geomfromtext('POINT(" +
                dec + " " +ra+")' , 4326), Coordinates.cords) ";


        String point = "POINT( " + dec + " " + ra + ")";


        List<Coordinate> result = coordinatesMapper.listCoordinatesInfoAllByOrder(point, order);

        List<CoordinateVo> coordinateVos = new ArrayList();
        for(Coordinate c: result){

            coordinateVos.add(coordinate2CoodinateVo(c));
        }

        return coordinateVos;
    }

    @Override
    public void updateComments(String comments, String id){
        coordinatesMapper.updateComment(comments, id);
    }


    private CoordinateVo coordinate2CoodinateVo(Coordinate coordinate){
        CoordinateVo coordinateVo = new CoordinateVo();
        System.out.println(coordinate.toString());
        BeanUtils.copyProperties(coordinate, coordinateVo);
        System.out.println(coordinateVo.toString());
        return coordinateVo;

    }


}
