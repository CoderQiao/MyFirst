package com.wssc.service;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class HtmlGen
{
	// 全局实例
	public static HtmlGen i = new HtmlGen();
	
	protected Configuration frmkConfig;
	protected File appDir;
	
	// appDir ： 模板文件所在目录 ( app所在目录 )
	// 注: 可以在BootLoader（Filter) 里初始化这个对象
	public synchronized void init(File appDir)
	{
		if(this.appDir != null) return; // 只初始化一次
		
		// 初始化
		this.appDir = appDir;
		try{
			frmkConfig = new Configuration(Configuration.VERSION_2_3_28);
			frmkConfig.setDirectoryForTemplateLoading(appDir); // 设置模板根目录
			frmkConfig.setDefaultEncoding("UTF-8");
			frmkConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			frmkConfig.setLogTemplateExceptions(false);
		}
		catch(Exception e)
		{		
			System.out.println("This Should Not Happen!");
		}
	}
	
	public void generate(String template, Object model, Writer out)throws Exception
	{
		if(appDir == null)
			throw new Exception("你忘记调用init()了! 请在BootLoader里初始化!");
		
		Template tp = frmkConfig.getTemplate(template); 
		tp.process(model, out);
	}
	
	// template : 模板文件
	// model: 数据
	// outPath: 生成的html文件路径（相对于appDir)
	public void generate(String template,String htmlPath, Object model )throws Exception
	{
		File htmlFile = new File(appDir, htmlPath);
		Writer out = new FileWriter(htmlFile);
		try{
			Template tp = frmkConfig.getTemplate(template); 
			generate(template, model, out);
		}
		finally{
			// 确保文件句柄被关闭
			try{ out.close();}catch(Exception e){}
		}		
	}	
	
}
