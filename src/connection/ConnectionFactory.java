package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import helper.Config;

public class ConnectionFactory {

	private String URL;
	private String USER;
	private String PASSWORD;

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Config.loadConfig();

		this.URL = Config.URL;
		this.USER = Config.USER;
		this.PASSWORD = Config.PASSWORD;
		
		return DriverManager.getConnection(URL, USER, PASSWORD);
		
	}

}