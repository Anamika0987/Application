package DBConnection;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class Dbconn {
		public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			FileInputStream fis = new FileInputStream("resources/myprop.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			String u= prop.getProperty("url");
			String user = prop.getProperty("username");
			String pass=prop.getProperty("password");
			Connection c = DriverManager.getConnection(u,user,pass);
			return c;
	
		}
	}
		

