package com.excelutility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static FileInputStream fis;
	static Workbook wb;

	public static String getCellValue(String sheetName, String id, String colName) {

		File f = new File(".\\Excel\\Excel.xlsx");
		String val = "";
		try {
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
			int col_Num = -1;
			Sheet sheet = wb.getSheet(sheetName);
			Row row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
					col_Num = i;
				}
			}
			int numberOfRows = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < numberOfRows; i++) {
				Row row1 = sheet.getRow(i);
				if (sheet.getRow(i).getCell(0).getStringCellValue().equals(id)) {

					val = row1.getCell(col_Num).getStringCellValue();
				}
			}
		} catch (Exception e) {

		}

		return val;
	}

}
