package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	public static String URL;
	public static String USER;
	public static String PASSWORD;

	public static void loadConfig() {

		Properties prop = new Properties();
		InputStream in = null;

		try {

			in = new FileInputStream("db.properties");

			prop.load(in);

			URL = prop.getProperty("db.url");
			USER = prop.getProperty("db.user");
			PASSWORD = prop.getProperty("db.password");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}