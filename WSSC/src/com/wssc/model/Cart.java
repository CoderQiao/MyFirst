package com.wssc.model;

import af.sql.annotation.AFCOLUMNS; 
import af.sql.annotation.AFTABLE; 
import java.util.Date; 

@AFTABLE(name="cart")  
@AFCOLUMNS(auto=true,generated="cartID") 
public class Cart 
{ 
 
	public Integer cartID ; 
	public Integer userID ; 
	public Integer goodID ; 
	public Integer price ; 
	public Integer number ; 
	public String title ; 
	public String picturePath ; 


	public void setCartID(Integer cartID)
	{
		this.cartID=cartID;
	}
	public Integer getCartID()
	{
		return this.cartID;
	}
	public void setUserID(Integer userID)
	{
		this.userID=userID;
	}
	public Integer getUserID()
	{
		return this.userID;
	}
	public void setGoodID(Integer goodID)
	{
		this.goodID=goodID;
	}
	public Integer getGoodID()
	{
		return this.goodID;
	}
	public void setPrice(Integer price)
	{
		this.price=price;
	}
	public Integer getPrice()
	{
		return this.price;
	}
	public void setNumber(Integer number)
	{
		this.number=number;
	}
	public Integer getNumber()
	{
		return this.number;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setPicturePath(String picturePath)
	{
		this.picturePath=picturePath;
	}
	public String getPicturePath()
	{
		return this.picturePath;
	}

} 
 