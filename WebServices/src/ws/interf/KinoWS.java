package ws.interf;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface KinoWS {

	@WebMethod
	String getMiejsca(int session_id);
	
	@WebMethod
	boolean dodajRejestracje(int id_seansu, String imie, String nazwisko, String email, String nr_tel, String miejsca);

}