package test;

import java.sql.SQLException;
import javax.jws.WebService;
import ws.database.controller.Controller;


@WebService(endpointInterface = "test.TestWS")
public class TestWSImpl implements TestWS{

	private Controller controller;
	
	public String printMessage() {	
		
		
		try {
			controller=new Controller();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "Test WS";
	}

}