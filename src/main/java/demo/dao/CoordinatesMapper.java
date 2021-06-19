package demo.dao;

import demo.pojo.Coordinate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CoordinatesMapper {
//   @Select("SELECT T1.id FROM" +
//            "(SELECT id, st_distance(st_geomfromtext('POINT(#{Ra} #{Dec})', 4326), Coordinates.cords) as planar_degrees" +
//            "FROM Coordinates" +
//            "ORDER BY planar_degrees" +
//            "LIMIT #{Count}) AS T1")
    //List<String> listCoordinates(@Param("Ra") Double Ra, @Param("Dec") Double Dec, @Param("Count") Integer count);

    //@Select ("SELECT T1.id FROM ( SELECT id, st_astext(cords), #{text} as planar_degrees FROM Coordinates ORDER BY planar_degrees LIMIT #{Count}) AS T1")
    List<String> listCoordinates(@Param("text")String text, @Param("Count") Integer count);

    @Select ("SELECT ID,RA,DE,MagFilter,MagBrightness,MagFaintest,QSOorigin,Method," +
            "PossibleType,CandidateStatus,Notes,Comment " +
            "FROM ( SELECT ID,RA,DE,MagFilter,MagBrightness,MagFaintest,QSOorigin,Method," +
            "PossibleType,CandidateStatus,Notes,Comment, st_astext(cords), #{text} as planar_degrees " +
            "FROM Coordinates ORDER BY planar_degrees LIMIT #{Count}) AS T1")
    List<Coordinate> listCoordinatesInfo(@Param("text")String text, @Param("Count") Integer count);


    @Select ("SELECT ID,RA,DE,MagFilter,MagBrightness,MagFaintest,QSOorigin,Method," +
            "PossibleType,CandidateStatus,Notes,Comment " +
            "FROM ( SELECT ID,RA,DE,MagFilter,MagBrightness,MagFaintest,QSOorigin,Method," +
            "PossibleType,CandidateStatus,Notes,Comment, st_astext(cords), st_distance(st_geomfromtext(#{point} , 4326), Coordinates.cords) as planar_degrees " +
            "FROM Coordinates ORDER BY planar_degrees LIMIT #{Count}) AS T1")
    List<Coordinate> listCoordinatesInfoLimit(@Param("point") String point, @Param("Count") Integer count);

    @Select ("SELECT ID,RA,DE,MagFilter,MagBrightness,MagFaintest,QSOorigin,Method," +
            "PossibleType,CandidateStatus,Notes,Comment " +
            "FROM ( SELECT ID,RA,DE,MagFilter,MagBrightness,MagFaintest,QSOorigin,Method," +
            "PossibleType,CandidateStatus,Notes,Comment, st_astext(cords), st_distance(st_geomfromtext(#{point} , 4326), Coordinates.cords) as planar_degrees " +
            "FROM Coordinates ORDER BY planar_degrees) AS T1")
    List<Coordinate> listCoordinatesInfoAll(@Param("point") String point);

    @Select ("SELECT ID,RA,DE,MagFilter,MagBrightness,MagFaintest,QSOorigin,Method," +
            "PossibleType,CandidateStatus,Notes,Comment " +
            "FROM ( SELECT ID,RA,DE,MagFilter,MagBrightness,MagFaintest,QSOorigin,Method," +
            "PossibleType,CandidateStatus,Notes,Comment, st_astext(cords), st_distance(st_geomfromtext(#{point} , 4326), Coordinates.cords) as planar_degrees " +
            "FROM Coordinates ORDER BY planar_degrees LIMIT #{Count}) AS T1 "+
            "ORDER BY ${order_by}")
    List<Coordinate> listCoordinatesInfoLimitByOrder(@Param("point") String point, @Param("Count") Integer count, @Param("order_by") String order);



    @Select ("SELECT ID,RA,DE,MagFilter,MagBrightness,MagFaintest,QSOorigin,Method," +
            "PossibleType,CandidateStatus,Notes,Comment " +
            "FROM ( SELECT ID,RA,DE,MagFilter,MagBrightness,MagFaintest,QSOorigin,Method," +
            "PossibleType,CandidateStatus,Notes,Comment, st_astext(cords), st_distance(st_geomfromtext(#{point} , 4326), Coordinates.cords) as planar_degrees " +
            "FROM Coordinates ORDER BY planar_degrees) AS T1 "+
            "ORDER BY ${order_by}")
    List<Coordinate> listCoordinatesInfoAllByOrder(@Param("point") String point, @Param("order_by") String order);


    @Select ("SELECT Notes FROM Coordinates WHERE id = #{id} LIMIT 2")
    List<String> getNotesById(@Param("id") String id);

    @Update("UPDATE Coordinates SET COMMENT = concat(COMMENT, #{comments}) WHERE ID = #{id}")
    void updateComment(@Param("comments") String comments, @Param("id") String id);
}
