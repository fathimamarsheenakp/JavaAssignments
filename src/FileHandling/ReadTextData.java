package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadTextData {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			br = new BufferedReader(new FileReader("C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\File\\Sample.txt"));
			bw = new BufferedWriter(new FileWriter("C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\File\\SampleOutput.txt"));
			
			String str;
			while ((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				br.close();
				bw.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
