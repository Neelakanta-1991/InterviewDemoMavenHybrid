package com.c4cSales.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	// creating an ArrayList : Wherein all the test data is
	// read and stored into the Arraylist : hence return type : ArrayList

	public ArrayList testData(String Path, int SheetNumber) {

		ArrayList TestData = new ArrayList();

		try {
			FileInputStream fis = new FileInputStream(Path);
			XSSFWorkbook wbks = new XSSFWorkbook(fis);
			XSSFSheet Sheet = wbks.getSheetAt(SheetNumber);

			// initialize the Iterator
			Iterator itr = Sheet.iterator();
			while (itr.hasNext()) {
				Row rowitr = (Row) itr.next();
				Iterator<Cell> cellIterator = rowitr.cellIterator();
				while (cellIterator.hasNext()) {
					Cell celldata = cellIterator.next();
					if (celldata.getCellType() == CellType.STRING) {
						TestData.add(celldata.getStringCellValue());
					}
				}
			}
			return TestData;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
