package com.wssc.model;

import af.sql.annotation.AFCOLUMNS; 
import af.sql.annotation.AFTABLE; 
import java.util.Date; 

@AFTABLE(name="cloth")  
@AFCOLUMNS(auto=true,generated="cloID") 
public class Cloth 
{ 
 
	public Integer cloID ; 
	public String title ; 
	public String information ; 
	public String pictureName ; 
	public String picturePath ; 
	public Integer remainNum ; 
	public Integer price ; 
	public Date addTime ; 


	public void setCloID(Integer cloID)
	{
		this.cloID=cloID;
	}
	public Integer getCloID()
	{
		return this.cloID;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setInformation(String information)
	{
		this.information=information;
	}
	public String getInformation()
	{
		return this.information;
	}
	public void setPictureName(String pictureName)
	{
		this.pictureName=pictureName;
	}
	public String getPictureName()
	{
		return this.pictureName;
	}
	public void setPicturePath(String picturePath)
	{
		this.picturePath=picturePath;
	}
	public String getPicturePath()
	{
		return this.picturePath;
	}
	public void setRemainNum(Integer remainNum)
	{
		this.remainNum=remainNum;
	}
	public Integer getRemainNum()
	{
		return this.remainNum;
	}
	public void setPrice(Integer price)
	{
		this.price=price;
	}
	public Integer getPrice()
	{
		return this.price;
	}
	public void setAddTime(Date addTime)
	{
		this.addTime=addTime;
	}
	public Date getAddTime()
	{
		return this.addTime;
	}

} 
 