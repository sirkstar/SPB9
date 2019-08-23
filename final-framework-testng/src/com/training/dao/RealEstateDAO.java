package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.userMessageBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class RealEstateDAO {
	
	Properties properties; 
	
	public RealEstateDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<userMessageBean> getUserMsg(){
		String sql = properties.getProperty("get.usermessage"); 
		
		GetConnection gc  = new GetConnection(); 
		List<userMessageBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<userMessageBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				userMessageBean temp = new userMessageBean();
				temp.setName(gc.rs1.getString(1));
				temp.setEmail(gc.rs1.getString(2));
				temp.setSubject(gc.rs1.getString(3));
				temp.setMessage(gc.rs1.getString(4));
//				
//				LoginBean temp = new LoginBean();
//				temp.setUserName(gc.rs1.getString(1));
//				temp.setPassword(gc.rs1.getString(2));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RealEstateDAO().getUserMsg().forEach(System.out :: println);
	}
	
	
}
