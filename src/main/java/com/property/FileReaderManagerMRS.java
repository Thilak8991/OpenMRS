package com.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

public class FileReaderManagerMRS {
	private static Properties property;
	private static FileInputStream fileInputStream;
	
	private static void setupProperty() throws IOException{

		if (property==null) {
			File file=new File("C:\\Users\\HP\\eclipse-workspace\\TestNG\\src\\main\\resources\\OpenMRSData");
			try {
				fileInputStream = new FileInputStream(file);
				property=new Properties();
				property.load(fileInputStream);
			} catch (FileNotFoundException e) {
				Assert.fail("ERROR : FILENOTFOUND EXCEPTION OCCUR DURING PROPERTY FILE LOADING");
			}catch (Exception e) {
				Assert.fail("ERROR : FILENOTFOUND EXCEPTION OCCUR DURING PROPERTY FILE LOADING");

			}
			
		}
	}
	public static String getDataProperty(String dataValue) throws Throwable {
		setupProperty();
		String browsername=property.getProperty(dataValue);
		return browsername;
		

	}

}
