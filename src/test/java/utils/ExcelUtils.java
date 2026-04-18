package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	 public static List<String[]> getLoginData() {
	        List<String[]> dataList = new ArrayList<>();

	        try {
	            FileInputStream fis = new FileInputStream("src/test/resources/LoginData.xlsx");
	            Workbook workbook = new XSSFWorkbook(fis);
	            Sheet sheet = workbook.getSheet("LoginData");

	            int rowCount = sheet.getPhysicalNumberOfRows();

	            for (int i = 1; i < rowCount; i++) {
	                Row row = sheet.getRow(i);

	                String username = row.getCell(0).toString();
	                String password = row.getCell(1).toString();
	                String expected = row.getCell(2).toString();

	                dataList.add(new String[]{username, password, expected});
	            }

	            workbook.close();
	            fis.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return dataList;
	    }
	}
