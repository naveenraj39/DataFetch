package dataComp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
private static  String url = "jdbc:postgresql://localhost:4200/tmx_qa";

private static  String user ="naveenraj";
private static  String pass ="bm8va40k5VCu"; 




    public static Connection getConnection() throws SQLException {
    	return DriverManager.getConnection(url, user, pass);
    }

	
	

}
