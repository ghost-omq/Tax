package omq.poi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class PoiPull {

	public static void main(String[] args) throws IOException {
		FileInputStream inputStrem = new FileInputStream("F:\\java\\工作簿.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(inputStrem);
		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFRow row = sheet.getRow(0);
		HSSFCell cell = row.getCell(2);
		System.out.println("C1单元格内容为：" + cell.getStringCellValue());
	}
}
