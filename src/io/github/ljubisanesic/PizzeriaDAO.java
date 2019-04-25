package io.github.ljubisanesic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PizzeriaDAO {
	
	private Connection myCon;
	
	public PizzeriaDAO() throws Exception {
		
		Properties propetis = new Properties();
		propetis.load(new FileInputStream("demo.properties"));
		
		String user = propetis.getProperty("user");
		String password = propetis.getProperty("password");
		String dburl =  propetis.getProperty("dburl");
		String timeZone = propetis.getProperty("timeZoneSetings");
		String url = dburl + timeZone;
		myCon = DriverManager.getConnection(url, user, password);
		
		System.out.println("Baza podataka uspjesno povezana sa: " + dburl);
	}

}
