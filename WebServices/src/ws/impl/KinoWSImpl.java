package ws.impl;

import java.sql.SQLException;
import javax.jws.WebService;
import ws.database.controller.Controller;
import ws.interf.KinoWS;


@WebService(endpointInterface = "ws.interf.KinoWS")
public class KinoWSImpl implements KinoWS{

	private Controller controller;
	
	public String getMiejsca(int session_id) {	
		
		
		try {
			controller=new Controller();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String miejsca=controller.getMiejsca(session_id);
		
		return miejsca;
	}

	public boolean dodajRejestracje(int id_seansu, String imie, String nazwisko, String email, String nr_tel, String miejsca) {	
		
		boolean status;
		try {
			controller=new Controller();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		status=sprawdzMiejsca(id_seansu, miejsca);
		
		if(status==true)
		{
			String miejsca_z=miejsca + "/" + controller.getMiejsca(id_seansu);
			controller.updateMiejsca(id_seansu, miejsca_z);
			controller.dodajRezerwacje(id_seansu, imie, nazwisko, email, nr_tel, miejsca);
		}
		
		return status;
	}
	
	public boolean sprawdzMiejsca(int id_seansu, String miejsca)
	{
		boolean status=true;
		String[] tab=miejsca.split("/");
		String zajete=controller.getMiejsca(id_seansu);
		
		for(int i=0;i<tab.length;i++)
		{
			if(zajete.contains(tab[i]))
			{
				status=false;
			}
		}
		
		return status;
	}
}