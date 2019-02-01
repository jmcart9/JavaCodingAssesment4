import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class NetworkRequestCount {
	
	public static void counter(String fileName) {
		Scanner inputFile;
		try {
			inputFile = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Inupt file could not be found.");
			e.printStackTrace();
			return;
		}
		
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		counts.put("GET", 0);
		counts.put("POST", 0);
		counts.put("PUT", 0);
		counts.put("DELETE", 0);
		counts.put("HEAD", 0);
		counts.put("CONNECT", 0);
		counts.put("OPTIONS", 0);
		counts.put("TRACE", 0);
		
		while(inputFile.hasNextLine()) {
			String inputLine = inputFile.nextLine();
			
			if(inputLine.contains("GET")) {
				counts.replace("GET", counts.get("GET")+1);
				continue;
			}
			if(inputLine.contains("POST")) {
				counts.replace("POST", counts.get("POST")+1);
				continue;
			}
			if(inputLine.contains("PUT")) {
				counts.replace("PUT", counts.get("PUT")+1);
				continue;
			}
			if(inputLine.contains("DELETE")) {
				counts.replace("DELETE", counts.get("DELETE")+1);
				continue;
			}
			if(inputLine.contains("HEAD")) {
				counts.replace("HEAD", counts.get("HEAD")+1);
				continue;
			}
			if(inputLine.contains("CONNECT")) {
				counts.replace("CONNECT", counts.get("CONNECT")+1);
				continue;
			}
			if(inputLine.contains("OPTIONS")) {
				counts.replace("OPTIONS", counts.get("OPTIONS")+1);
				continue;
			}
			if(inputLine.contains("TRACE")) {
				counts.replace("TRACE", counts.get("TRACE")+1);
				continue;
			}
		}
		
		System.out.println(counts.toString());
		inputFile.close();
	}

	public static void main(String args []) {
		String fileName = "localhost_access_log.2016-08-04.txt";
		counter(fileName);
	}
}
