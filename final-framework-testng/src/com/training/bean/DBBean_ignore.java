package com.training.bean;

/**
 * 
 * @author Naveen
 * @see this class shall get the bean data 
 */
public class DBBean_ignore {
	private String url; 
	private String driver; 
	private String name;
	private String email;
	private String subject;
	private String message;
	
	public DBBean_ignore(){}
	
	public DBBean_ignore(String url, String driver, String name, String email, String subject, String message) {
		super();
		this.url = url;
		this.driver = driver;
		this.name = name;
		this.email = email;
		this.name = subject;
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
