package test;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionFactory;

public class ConnectionTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.getConnection();
		System.out.println(con);
		
	}
}
