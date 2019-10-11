package com.wssc.model; 

import af.sql.annotation.AFCOLUMNS; 
import af.sql.annotation.AFTABLE; 
import java.util.Date; 

@AFTABLE(name="admin")  
@AFCOLUMNS(auto=true) 
public class Admin 
{ 
 
	public Integer admID ; 
	public String userName ; 
	public String password ; 


	public void setAdmID(Integer admID)
	{
		this.admID=admID;
	}
	public Integer getAdmID()
	{
		return this.admID;
	}
	public void setUserName(String userName)
	{
		this.userName=userName;
	}
	public String getUserName()
	{
		return this.userName;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return this.password;
	}

} 
 