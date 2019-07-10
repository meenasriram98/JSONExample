import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Convert {
	
	public void dbToFile(){
		
		final String url = "jdbc:mysql://localhost";
		 
	    final String user = "root";
	 
	    final String password = "19981954@Mee";
	   
	 File file=new File("employee.json");
		 try {
	            Connection con = DriverManager.getConnection(url, user, password);
	            System.out.println("Success");
	            
	            String query="use sample";
	            
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	           
	           String q="select * from employee";
	           
	           st=con.createStatement();
	           rs=st.executeQuery(q);
	           
	           copyToFile(rs,file);
	           fileToObject(file);
	        
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	            
	        }
	}
		 
		 public void copyToFile(ResultSet rs,File file) throws SQLException, JsonGenerationException, JsonMappingException, IOException
		 {
			 ObjectMapper mapper=new ObjectMapper();
			 List<Employee> emp_list=new ArrayList<Employee>();
			 
			 while(rs.next())
			 {
				 Employee emp=new Employee(rs.getString(1),rs.getInt(2),rs.getInt(3));
				 System.out.println(emp.name);
				 emp_list.add(emp);
				 
			 }
			 mapper.writeValue(file, emp_list);
		 }
		 
		 public void fileToObject(File file) throws JsonParseException, JsonMappingException, IOException
		 {
			 ObjectMapper mapper=new ObjectMapper();
     		 List<Employee> list=new ArrayList<Employee>();
			 list=mapper.readValue(file, list.getClass());
			 System.out.println(list);
			 
			 
			 
		
		
		 }
		
         
        
		 
	

}
