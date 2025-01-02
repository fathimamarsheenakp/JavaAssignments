package FileHandling;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			
			String path = "C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\File\\SampleData.xlsx";
			
			fis = new FileInputStream(path);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			Sheet sheet = workbook.getSheetAt(0);
			
			for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
			
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
