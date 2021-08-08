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

    @Select ("WITH T1 AS (\n" +
            "\tSELECT coord.ID, coord.RA, coord.DE, coord.MagFilter, coord.MagBrightness, coord.MagFaintest, \n" +
            "\t\t   coord.QSOorigin, coord.Method, coord.PossibleType, coord.CandidateStatus, coord.Notes,\n" +
            "\t\t   GROUP_CONCAT(DISTINCT CONCAT('\n', comm.datetime,'\n', comm.comment) ORDER BY comm.datetime SEPARATOR '\n') AS comment, st_astext(coord.cords),\n" +
            "           #{text} AS planar_degrees\n" +
            "\tFROM Coordinates AS coord\n" +
            "    LEFT JOIN comments AS comm \n" +
            "\t\tON coord.ID = comm.coordinate_id\n" +
            "\tGROUP BY coord.ID\n" +
            "    ORDER BY planar_degrees\n" +
            "    LIMIT #{count}\n" +
            ")\n" +
            "SELECT ID, RA, DE, MagFilter, MagBrightness, MagFaintest, QSOorigin, Method,\n" +
            "       PossibleType, CandidateStatus, Notes\n" +
            "FROM T1")
    List<Coordinate> listCoordinatesInfo(@Param("text")String text, @Param("Count") Integer count);


    @Select ("WITH T1 AS (\n" +
            "\tSELECT coord.ID, coord.RA, coord.DE, coord.MagFilter, coord.MagBrightness, coord.MagFaintest, \n" +
            "\t\t   coord.QSOorigin, coord.Method, coord.PossibleType, coord.CandidateStatus, coord.Notes,\n" +
            "\t\t   GROUP_CONCAT(DISTINCT CONCAT('\n', comm.datetime,'\n', comm.comment) ORDER BY comm.datetime SEPARATOR '\n') AS comment, st_astext(coord.cords),\n" +
            "           st_distance(st_geomfromtext(#{point} , 4326), coord.cords) AS planar_degrees\n" +
            "\tFROM Coordinates AS coord\n" +
            "    LEFT JOIN comments AS comm \n" +
            "\t\tON coord.ID = comm.coordinate_id\n" +
            "\tGROUP BY coord.ID\n" +
            "    ORDER BY planar_degrees\n" +
            ")\n" +
            "SELECT ID, RA, DE, MagFilter, MagBrightness, MagFaintest, QSOorigin, Method,\n" +
            "       PossibleType, CandidateStatus, Notes, Comment\n" +
            "FROM T1\n" +
            "LIMIT #{Count}")
    List<Coordinate> listCoordinatesInfoLimit(@Param("point") String point, @Param("Count") Integer count);

    @Select ("WITH T1 AS (\n" +
            "\tSELECT coord.ID, coord.RA, coord.DE, coord.MagFilter, coord.MagBrightness, coord.MagFaintest, \n" +
            "\t\t   coord.QSOorigin, coord.Method, coord.PossibleType, coord.CandidateStatus, coord.Notes,\n" +
            "\t\t   GROUP_CONCAT(DISTINCT CONCAT('\n', comm.datetime,'\n', comm.comment) ORDER BY comm.datetime SEPARATOR '\n') AS comment, st_astext(coord.cords),\n" +
            "           st_distance(st_geomfromtext(#{point} , 4326), coord.cords) AS planar_degrees\n" +
            "\tFROM Coordinates AS coord\n" +
            "    LEFT JOIN comments AS comm \n" +
            "\t\tON coord.ID = comm.coordinate_id\n" +
            "\tGROUP BY coord.ID\n" +
            "    ORDER BY planar_degrees\n" +
            ")\n" +
            "SELECT ID, RA, DE, MagFilter, MagBrightness, MagFaintest, QSOorigin, Method,\n" +
            "       PossibleType, CandidateStatus, Notes, Comment\n" +
            "FROM T1")
    List<Coordinate> listCoordinatesInfoAll(@Param("point") String point);

    @Select ("WITH T1 AS (\n" +
            "\tSELECT coord.ID, coord.RA, coord.DE, coord.MagFilter, coord.MagBrightness, coord.MagFaintest, \n" +
            "\t\t   coord.QSOorigin, coord.Method, coord.PossibleType, coord.CandidateStatus, coord.Notes,\n" +
            "\t\t   GROUP_CONCAT(DISTINCT CONCAT('\n', comm.datetime,'\n', comm.comment) ORDER BY comm.datetime SEPARATOR '\n') AS comment, st_astext(coord.cords),\n" +
            "           st_distance(st_geomfromtext(#{point} , 4326), coord.cords) AS planar_degrees\n" +
            "\tFROM Coordinates AS coord\n" +
            "    LEFT JOIN comments AS comm \n" +
            "\t\tON coord.ID = comm.coordinate_id\n" +
            "\tGROUP BY coord.ID\n" +
            "    ORDER BY ${order_by}\n" +
            ")\n" +
            "SELECT ID, RA, DE, MagFilter, MagBrightness, MagFaintest, QSOorigin, Method,\n" +
            "       PossibleType, CandidateStatus, Notes, Comment\n" +
            "FROM T1\n" +
            "LIMIT #{Count}")
    List<Coordinate> listCoordinatesInfoLimitByOrder(@Param("point") String point, @Param("Count") Integer count, @Param("order_by") String order);



    @Select ("WITH T1 AS (\n" +
            "\tSELECT coord.ID, coord.RA, coord.DE, coord.MagFilter, coord.MagBrightness, coord.MagFaintest, \n" +
            "\t\t   coord.QSOorigin, coord.Method, coord.PossibleType, coord.CandidateStatus, coord.Notes,\n" +
            "\t\t   GROUP_CONCAT(DISTINCT CONCAT('\n', comm.datetime,'\n', comm.comment) ORDER BY comm.datetime SEPARATOR '\n') AS comment, st_astext(coord.cords),\n" +
            "           st_distance(st_geomfromtext(#{point} , 4326), coord.cords) AS planar_degrees\n" +
            "\tFROM Coordinates AS coord\n" +
            "    LEFT JOIN comments AS comm \n" +
            "\t\tON coord.ID = comm.coordinate_id\n" +
            "\tGROUP BY coord.ID\n" +
            "    ORDER BY #{order_by}\n" +
            ")\n" +
            "SELECT ID, RA, DE, MagFilter, MagBrightness, MagFaintest, QSOorigin, Method,\n" +
            "       PossibleType, CandidateStatus, Notes, Comment\n" +
            "FROM T1")
    List<Coordinate> listCoordinatesInfoAllByOrder(@Param("point") String point, @Param("order_by") String order);


    @Select ("SELECT Notes FROM Coordinates WHERE id = #{id} LIMIT 2")
    List<String> getNotesById(@Param("id") String id);

    @Insert("INSERT INTO comments (coordinate_id, comment) VALUES (#{id}, #{comments})")
    // @Update("UPDATE Coordinates SET COMMENT = concat(COMMENT, #{comments}) WHERE ID = #{id}")
    void updateComment(@Param("comments") String comments, @Param("id") String id);
}
