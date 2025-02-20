package dataComp;

import java.io.IOException;

public class Compare {
	 public static void compareCSV(String file1, String file2) {
	        try {
	            ProcessBuilder processBuilder = new ProcessBuilder("diff", file1, file2);
	            processBuilder.inheritIO();
	            Process process = processBuilder.start();
	            process.waitFor();
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

}
