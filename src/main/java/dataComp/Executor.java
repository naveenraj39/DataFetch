package dataComp;

public class Executor extends ExportToCsv{
	

	public static void main (String []args) {
		
		String query1 = "SELECT \n"
				+ "    patient.mrn, \n"
				+ "    patient.name, \n"
				+ "    COUNT(CASE WHEN subtask.relevancy = 'RELEVANT' THEN 1 END) AS relevant_subtask_count, \n"
				+ "    STRING_AGG(DISTINCT study.public_title, ', ') AS study_titles\n"
				+ "FROM tmx_prism_trialfinder.patient AS patient\n"
				+ "LEFT JOIN tmx_prism_trialfinder.patient_review_task task \n"
				+ "    ON patient.db_id = task.fk_patient_db_id\n"
				+ "LEFT JOIN tmx_prism_trialfinder.patient_review_subtask subtask \n"
				+ "    ON task.db_id = subtask.fk_patient_review_task_db_id\n"
				+ "LEFT JOIN tmx_admin.tmx_clinical_study study \n"
				+ "    ON subtask.study_id = study.study_id\n"
				+ "WHERE patient.tenant_id = 'fe6a0e03-9a27-4a78-abba-a09bef79d9c7'\n"
				+ "GROUP BY patient.mrn, patient.name LIMIT 20 OFFSET 0;";
		String query2 = "SELECT \n"
				+ "    patient.mrn, \n"
				+ "    patient.name, \n"
				+ "    COUNT(CASE WHEN subtask.relevancy = 'RELEVANT' THEN 1 END) AS relevant_subtask_count, \n"
				+ "    STRING_AGG(DISTINCT study.public_title, ', ') AS study_titles\n"
				+ "FROM tmx_prism_trialfinder.patient AS patient\n"
				+ "LEFT JOIN tmx_prism_trialfinder.patient_review_task task \n"
				+ "    ON patient.db_id = task.fk_patient_db_id\n"
				+ "LEFT JOIN tmx_prism_trialfinder.patient_review_subtask subtask \n"
				+ "    ON task.db_id = subtask.fk_patient_review_task_db_id\n"
				+ "LEFT JOIN tmx_admin.tmx_clinical_study study \n"
				+ "    ON subtask.study_id = study.study_id\n"
				+ "WHERE patient.tenant_id = 'fe6a0e03-9a27-4a78-abba-a09bef79d9c7'\n"
				+ "GROUP BY patient.mrn, patient.name LIMIT 20 OFFSET 20;";
		
	   ExportToCsv.exportDataToCsv(query1, "File1.csv");
	   ExportToCsv.exportDataToCsv(query2, "File2.csv");
	   
	   
	   Compare.compareCSV("File1.csv", "File2.csv");
	}

	

}
