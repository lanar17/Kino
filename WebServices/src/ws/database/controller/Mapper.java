package ws.database.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class Mapper implements RowMapper<String> {
	
   public String mapRow(ResultSet rs, int rowNum) throws SQLException 
   {
      String result = rs.getString("miejsca");
 
      return result;
   }
}
