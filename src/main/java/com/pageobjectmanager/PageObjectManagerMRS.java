package com.pageobjectmanager;

import java.io.FileReader;

import com.baseclass.BaseClass;
import com.property.FileReaderManagerMRS;

import pageobjectmodel.OpenMRSLoginPage;

public class PageObjectManagerMRS extends BaseClass {
	
	private OpenMRSLoginPage loginPage;
	private FileReaderManagerMRS fileReader;
	
	public OpenMRSLoginPage getLoginPage() {
		if (loginPage==null) {
			loginPage =new OpenMRSLoginPage(driver);
		}
		return loginPage;
	}
	public FileReaderManagerMRS getFileReader() {
		if (fileReader ==null) {
			fileReader = new FileReaderManagerMRS();
		}
		return fileReader;
	}
	
	

}
