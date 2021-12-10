package data;



import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Resources {

	public static String get_excel_data(int row, int cell) {
		String data = null;
		try {
			FileInputStream fis = new FileInputStream("./TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			// Get the sheet from the workbook
			Sheet s = wb.getSheet("Sheet1");

			// Get the row num
			Row r = s.getRow(row);

//			//Get Column num
			Cell c = r.getCell(cell);

			data = c.getStringCellValue();

		} catch (Exception e) {
			System.out.println(e);
		}

		return data;

	}

	public void set_excel_data(int row, int cell, String result) throws Exception {

		FileInputStream fis = new FileInputStream("./TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		// Get the sheet from the workbook
		Sheet s = wb.getSheet("Sheet1");

		// Get the row num
		Row r = s.getRow(row);

		Cell cell_create = r.createCell(cell);

		cell_create.setCellValue(result);

		FileOutputStream fos = new FileOutputStream("./TestData.xlsx");
		wb.write(fos);
	}

	@DataProvider(name = "Login")
	public String[][] login_data() throws Exception {

		String[][] un_pwd = { { get_excel_data(1, 0), get_excel_data(1, 1), get_excel_data(1, 2) },
				{ get_excel_data(2, 0), get_excel_data(2, 1), get_excel_data(2, 2) },

		};
		return un_pwd;
	}

	@DataProvider(name = "Recover")
	public String[][] Recover_data() throws Exception {
		String[][] Email_Id = { { get_excel_data(4, 0) }, { get_excel_data(5, 0) } };
		return Email_Id;

	}

	@DataProvider(name = "Message")
	public String[][] Valid_login_data() throws Exception {

		String[][] un_pwd = { { get_excel_data(1, 0), get_excel_data(1, 1), get_excel_data(1, 2) }, };
		return un_pwd;
	}
}
