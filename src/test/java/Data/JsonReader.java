package Data;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
String fristname,lastname,email,company,pass,conpass;
public void readDataJson() {
	String filePath=System.getProperty("user.dir")+"/src/test/java/Data/JsonReader.java";
	File filesrc=new File(filePath);
	
	JSONParser parser = new JSONParser(); 
	JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile)); 

	for(Object jsonObj : jarray) 
	{
		JSONObject person = (JSONObject) jsonObj ; 
		fristname  = (String) person.get("firstname"); 
		System.out.println(fristname);

		lastname = (String) person.get("lastname"); 
		System.out.println(lastname);

		email = (String) person.get("email"); 
		System.out.println(email);

		password = (String) person.get("password"); 
		System.out.println(password);

	}
	
}
}
