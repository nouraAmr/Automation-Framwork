package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
public static Properties userData=loadProperties("F:\\my fram om git\\Automation-Framwork\\src\\main\\java\\Properties\\data.properties");


private static Properties loadProperties(String path){
	Properties pro=new Properties();
	//stream for reading file
		try {
			FileInputStream stream=new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		 return pro;
}
}
