package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilitiesForApplication {

	public String getPropertyvalue(String key){
		Properties props = new Properties();
		//System.out.println("Test environment" +System.getenv("env"));
		
		FileInputStream inStream;
		try {
			inStream = new FileInputStream("C://Interface//Config.properties");
			props.load(inStream);
			inStream.close();
			return props.getProperty(key);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Properties file missing");
			return null;
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem loading property file");
			return null;
		}
	
}
}
