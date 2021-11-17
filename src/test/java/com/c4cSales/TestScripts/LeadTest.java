package com.c4cSales.TestScripts;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.c4cSales.base.ExcelReader;
import com.c4cSales.base.Keywords;

public class LeadTest {
	
	@Test
	public void LoginTestCase() {
		
		//Keyword Class object
		Keywords key = new Keywords();
		
		
		ExcelReader reader = new ExcelReader();
		ArrayList testData = reader.testData("C:\\Users\\C5216839\\Desktop\\MyPractice\\c4cAutomationTestData\\LeadsTestSuite.xlsx", 0);
		
		for (int i = 0 ; i < testData.size() ; i++) {
				if(testData.get(i).equals("OpenBrowser")) {
					key.OpenBrowser();
				}
				
				if(testData.get(i).equals("LaunchURL")) {
					String URL = (String) testData.get(i+1);
					key.LaunchURL(URL);	
				}
				
				if(testData.get(i).equals("Input")) {
					String inputData = (String) testData.get(i+1);
					String objName = (String) testData.get(i+2);
					key.Input(inputData,objName);
				}
				
				if(testData.get(i).equals("Click")) {
					String objName = (String) testData.get(i+2);
					key.click(objName);
					try {
						Thread.sleep(10000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
				if(testData.get(i).equals("CloseBrowser")) {
					key.CloseBrowser();
				}
				
		}
	}

}
