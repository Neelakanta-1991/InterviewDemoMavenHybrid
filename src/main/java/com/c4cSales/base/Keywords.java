package com.c4cSales.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Keywords {

	private WebDriver driver;

	// 1.For properties File reading : Browser specific
	private FileInputStream fis;
	private Properties prop;
	
	// 2. for preoperties File Reading : for OBJECT Repository spcific
	private FileInputStream ObjRepPath;
	private Properties ObjRepoProp;

	public void OpenBrowser() {

		// 1. Using here to read the properties file content
		try {
			fis = new FileInputStream("C:\\Users\\C5216839\\eclipse-workspace\\sapC4cSales\\src\\main\\java\\com\\c4cSales\\base\\config.properties");
			prop = new Properties();
			prop.load(fis);
			
			String BrowserName = prop.getProperty("BrowserName");
			if(BrowserName.equals("Chrome")) {
				driver = new ChromeDriver();
			}else if(BrowserName.equals("Firefox")) {
				driver = new FirefoxDriver();
			}	
			
			//2. properties file for OBJ repo 
			//kept it here as this function will run mandatorily
			// hence while executing both the properties files will be loaded
			ObjRepPath = new FileInputStream("C:\\Users\\C5216839\\eclipse-workspace\\sapC4cSales\\src\\main\\java\\com\\c4cSales\\base\\ObjectProperties");
			ObjRepoProp = new Properties();
			ObjRepoProp.load(ObjRepPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void LaunchURL(String URL) {
		driver.get(URL);	
	}

	public void Input(String inputData, String objName) {
		driver.findElement(By.xpath(ObjRepoProp.getProperty(objName))).sendKeys(inputData);
	}

	public void click(String objName) {
		driver.findElement(By.xpath(ObjRepoProp.getProperty(objName))).click();	
	}

	public void CloseBrowser() {
		driver.close();
	}

}
