package ws.database.controller;

import java.net.URL;

import java.sql.SQLException;
import java.util.Date;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class Controller{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public Controller () throws SQLException {
		URL url = getClass().getClassLoader().getResource("../../");
		String path=url.toString() + "WEB-INF/applicationContext.xml";
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(path);
		this.dataSource =  (DataSource) appContext.getBean("dataSource");		
		
	}
	
	
	public void dodajRezerwacje(int id_seansu, String imie, String nazwisko, String email, String nr_tel, String miejsca) {
		String SQL = "insert into rezerwacja (id_seansu, data_rezerwacji, imie, nazwisko, email, tel, miejsca) values (?,?,?,?,?,?,?)";
		Date data_rezerwacji=new Date();
		this.jdbcTemplateObject = new JdbcTemplate(
				(javax.sql.DataSource) this.dataSource);

		jdbcTemplateObject.update(SQL, id_seansu, data_rezerwacji, imie, nazwisko, email, nr_tel, miejsca);
		return;
	}
	
	public String getMiejsca(int id_seansu) {
		String SQL = "select miejsca from seans where id_seansu = ?";
		
		this.jdbcTemplateObject = new JdbcTemplate(
				(javax.sql.DataSource) this.dataSource);
		String miejsca = jdbcTemplateObject.queryForObject(SQL,
				new Object[] { id_seansu }, new Mapper());
		return miejsca;
	}
	
	public void updateMiejsca(int id_seansu, String miejsca) {
		String SQL = "UPDATE seans SET miejsca=? WHERE id_seansu=?";
		
		this.jdbcTemplateObject = new JdbcTemplate(
				(javax.sql.DataSource) this.dataSource);

		jdbcTemplateObject.update(SQL, miejsca, id_seansu);
		return;
	}
	
	

}