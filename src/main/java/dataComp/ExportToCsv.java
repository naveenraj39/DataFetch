package dataComp;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ExportToCsv {
	
//	 public static void main (String[] args) {
	
	public static void exportDataToCsv(String query, String fileName) {
		 
	
//		 String query = "SELECT patient.mrn, patient.name FROM tmx_prism_trialfinder.patient as patient\n"
//          		+ "         left join tmx_prism_trialfinder.patient_review_task task on patient.db_id = task.fk_patient_db_id\n"
//          		+ "         left join tmx_prism_trialfinder.patient_review_subtask subtask\n"
//          		+ "                   on task.db_id = subtask.fk_patient_review_task_db_id WHERE patient.tenant_id= 'fe6a0e03-9a27-4a78-abba-a09bef79d9c7' group by patient.mrn, patient.name";
//		 
//		 
//		 String query = "SELECT patient.mrn, patient.name, COUNT(CASE WHEN subtask.relevancy = 'RELEVANT' THEN 1 END) AS relevant_subtask_count FROM tmx_prism_trialfinder.patient AS patient\n"
//		 		+ "LEFT JOIN tmx_prism_trialfinder.patient_review_task task \n"
//		 		+ "    ON patient.db_id = task.fk_patient_db_id\n"
//		 		+ "LEFT JOIN tmx_prism_trialfinder.patient_review_subtask subtask \n"
//		 		+ "    ON task.db_id = subtask.fk_patient_review_task_db_id\n"
//		 		+ "WHERE patient.tenant_id = 'fe6a0e03-9a27-4a78-abba-a09bef79d9c7'\n"
//		 		+ "GROUP BY patient.mrn, patient.name";
		 
		 
		 
		 
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query);
	        		
	             ResultSet rs = stmt.executeQuery();
	             FileWriter csvWriter = new FileWriter(fileName)) {


	            ResultSetMetaData metaData = rs.getMetaData();
	            int columnCount = metaData.getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                csvWriter.append(metaData.getColumnName(i)).append(",");
	            }
	            csvWriter.append("\n");

	            while (rs.next()) {
	                for (int i = 1; i <= columnCount; i++) {
	                    csvWriter.append(rs.getString(i)).append(",");
	                }
	                csvWriter.append("\n");
	            }

	            System.out.println("Data exported successfully to " + fileName);
	        } catch (SQLException | IOException e) {
	            e.printStackTrace();
	        }
	        
	        
	    }

}
