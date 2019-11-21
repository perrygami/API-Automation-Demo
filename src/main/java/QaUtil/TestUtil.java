package QaUtil;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil  {

	static org.apache.poi.ss.usermodel.Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;

	public static String TESTDATA_SHEET_PATH = "/Users/perry.gami/eclipse/My Automation/Cloud/APITestingRestassured/Resources/Testdata.xlsx";

	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		int lastNRowNumber = sheet.getLastRowNum();
		// int lastCellNumber = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i < lastNRowNumber; i++) {
			for (int k = 0; k < sheet.getRow(i).getLastCellNum(); k++) {

				try {
					if (!sheet.getRow(i + 1).getCell(k).equals("")) {
						data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					}

					System.out.println(data[i][k]);
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return data;

	}
	
	
}
