package com.wssc.model;

import af.sql.annotation.AFCOLUMNS; 
import af.sql.annotation.AFTABLE; 
import java.util.Date; 

@AFTABLE(name="user")  
@AFCOLUMNS(auto=true,generated="userID") 
public class User 
{ 
 
	public Integer userID ; 
	public String name ; 
	public String realName ; 
	public String telephone ; 
	public String address ; 
	public Date addTime ; 
	public String password ; 
	public String picturePath ; 
	public String sex ; 


	public void setUserID(Integer userID)
	{
		this.userID=userID;
	}
	public Integer getUserID()
	{
		return this.userID;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setRealName(String realName)
	{
		this.realName=realName;
	}
	public String getRealName()
	{
		return this.realName;
	}
	public void setTelephone(String telephone)
	{
		this.telephone=telephone;
	}
	public String getTelephone()
	{
		return this.telephone;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getAddress()
	{
		return this.address;
	}
	public void setAddTime(Date addTime)
	{
		this.addTime=addTime;
	}
	public Date getAddTime()
	{
		return this.addTime;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPicturePath(String picturePath)
	{
		this.picturePath=picturePath;
	}
	public String getPicturePath()
	{
		return this.picturePath;
	}
	public void setSex(String sex)
	{
		this.sex=sex;
	}
	public String getSex()
	{
		return this.sex;
	}

} 
 