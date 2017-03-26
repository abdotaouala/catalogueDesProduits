package metier;
import java.sql.*;

public class SingletonConnection {

	private static Connection connection;
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/catalogue","root","");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return connection;
	}
}
