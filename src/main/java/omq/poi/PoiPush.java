package omq.poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class PoiPush {

	public static void main(String[] args) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet1 = workbook.createSheet("工作表1");
		HSSFRow row = sheet1.createRow(0);
		HSSFCell cell = row.createCell(2);
		cell.setCellValue("Hello World");
		FileOutputStream outputStream = new FileOutputStream("F:\\java\\工作簿.xls");
		workbook.write(outputStream);
		outputStream.close();
	}

}
