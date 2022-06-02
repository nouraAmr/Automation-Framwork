package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {
static FileInputStream fis=null;
@Test(priority =1 )
public FileInputStream getFileInputStream() {
String path=System.getProperty("user.dir")+"/src/test/java/Data/AutomationTesting.xlsx"	;
File srcFile=new File(path);
try {
	fis=new FileInputStream(srcFile);
} catch (FileNotFoundException e) {
	System.out.println(e.getMessage());
}
return fis;
}

@Test(priority =2)
 public Object[][] getExcelData() throws IOException{
	 fis=getFileInputStream();
	 XSSFWorkbook wb=new XSSFWorkbook(fis);
	 XSSFSheet sheet=wb.getSheetAt(0);
	 int totalNumbersOfRows=(sheet.getLastRowNum()+1);
	 int totalNumbersOfCols=6; 
	 String [][]arrayExcelData=new String[totalNumbersOfRows][totalNumbersOfCols];
	 for(int i=0;i<totalNumbersOfRows;i++) {
		 for(int j=0;j<totalNumbersOfCols;j++) {
			 XSSFRow row=sheet.getRow(i);
			 arrayExcelData[i][j]=row .getCell(j).toString();
			 
		 }
	 }
	 wb.close();
	return arrayExcelData;
 }

}
