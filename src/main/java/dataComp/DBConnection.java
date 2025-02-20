package dataComp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
private static  String url = "jdbc:postgresql://localhost:4200/tmx_qa";

private static  String user ="";
private static  String pass =""; 




    public static Connection getConnection() throws SQLException {
    	return DriverManager.getConnection(url, user, pass);
    }

	
	

}
