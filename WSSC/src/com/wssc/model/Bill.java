package com.wssc.model;


import af.sql.annotation.AFCOLUMNS; 
import af.sql.annotation.AFTABLE; 
import java.util.Date; 

@AFTABLE(name="bill")  
@AFCOLUMNS(auto=true,generated="billID") 
public class Bill 
{ 
 
	public Integer billID ; 
	public Integer userID ; 
	public String name ; 
	public String title ; 
	public Integer number ; 
	public Integer goodID ; 
	public Date buyTime ; 
	public String picturePath ; 
	public Integer price ; 


	public void setBillID(Integer billID)
	{
		this.billID=billID;
	}
	public Integer getBillID()
	{
		return this.billID;
	}
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
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setNumber(Integer number)
	{
		this.number=number;
	}
	public Integer getNumber()
	{
		return this.number;
	}
	public void setGoodID(Integer goodID)
	{
		this.goodID=goodID;
	}
	public Integer getGoodID()
	{
		return this.goodID;
	}
	public void setBuyTime(Date buyTime)
	{
		this.buyTime=buyTime;
	}
	public Date getBuyTime()
	{
		return this.buyTime;
	}
	public void setPicturePath(String picturePath)
	{
		this.picturePath=picturePath;
	}
	public String getPicturePath()
	{
		return this.picturePath;
	}
	public void setPrice(Integer price)
	{
		this.price=price;
	}
	public Integer getPrice()
	{
		return this.price;
	}

} 
 