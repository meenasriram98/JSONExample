import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.codehaus.jackson.map.ObjectMapper; 

//public class Main {
//	
//	public static void main(String args[])
//	{
//		String result;
//		Person person=new Person();
//		person.name="meena";
//		person.age=21;
//		
//		ObjectMapper mapper=new ObjectMapper();
//		
//		try {
//			 result=mapper.writeValueAsString(person);
//			 System.out.println(result);
//			 
//			 Person p=mapper.readValue(result, Person.class);
//			 System.out.println(p);
//		} 
//		
//		catch (JsonProcessingException e) {
//			e.printStackTrace();
//		} 
//		
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public class Main {

		
	 
	    public static void main(String args[]) {
	    	
	    	Convert convert=new Convert();
	    	convert.dbToFile();
	       
	    }

}
