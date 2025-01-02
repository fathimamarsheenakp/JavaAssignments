package FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadImage {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			String path1 = "C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\File\\inputImage.png";
			String path2 = "C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\File\\outputImage.png";
			
			fis = new FileInputStream(path1);
			fos = new FileOutputStream(path2);
			
			int x;
			while ((x = fis.read()) != -1) {
				fos.write(x);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
