package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.userMessageBean;
import com.training.dao.ELearningDAO;
import com.training.dao.RealEstateDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0;
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		return result;
	}
	
	@DataProvider(name = "db-inputs_073")
	public Object [][] getDBData1() {

		List<userMessageBean> list1 = new RealEstateDAO().getUserMsg(); 
		
		Object[][] result = new Object[list1.size()][]; 
		int count = 0;
		for(userMessageBean temp1 : list1){
			Object[]  obj = new Object[4]; 
			obj[0] = temp1.getName(); 
			obj[1] = temp1.getEmail();
			obj[2] = temp1.getSubject();
			obj[3] = temp1.getMessage();
			
			result[count ++] = obj;
		}
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs_RETC_071")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\KRISHNARAVI\\Documents\\Selenium Training docs\\Selenium Project\\DataProvider\\ComplexScenario.xlsx"; 
		String sheetName = "RETC_071";
	return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs_RETC_072")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Users\\KRISHNARAVI\\Documents\\Selenium Training docs\\Selenium Project\\DataProvider\\ComplexScenario.xlsx"; 
		String sheetName = "RETC_072";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs_RETC_074")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Users\\KRISHNARAVI\\Documents\\Selenium Training docs\\Selenium Project\\DataProvider\\ComplexScenario.xlsx"; 
		String sheetName = "RETC_074";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-test")
	public Object[][] getExcelDatatest(){
		String fileName ="C:\\Users\\KRISHNARAVI\\Documents\\Selenium Training docs\\Selenium Project\\DataProvider\\ComplexScenario.xlsx"; 
		String sheetName = "test";
	return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
