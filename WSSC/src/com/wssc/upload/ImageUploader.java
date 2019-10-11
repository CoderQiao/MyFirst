package com.wssc.upload;

import java.io.File;

import org.json.JSONObject;

import af.web.AfFormData;
import af.web.fileupload.AfUploadHandler;
import af.web.fileupload.AfUploadUtils;

public class ImageUploader extends AfUploadHandler
{
	String tmpFileName;

	@Override
	public File getTmpDir()
	{
		// httpReq 在父类 AfUploadHandler里定义
		String path = httpReq.getServletContext().getRealPath("/tmp");
		return new File( path);
	}
	
	@Override
	public File getTmpFile(File tmpDir, String realName)
	{
		String suffix = AfUploadUtils.fileSuffix(realName);
		String uuid = AfUploadUtils.createUUID();
		this.tmpFileName = uuid + "." + suffix;
		
		return new File(tmpDir, tmpFileName);
	}

	@Override
	public Object complete(long size, AfFormData formData)
	{
		String storePath = "/tmp/" + tmpFileName;
		String contextPath = httpReq.getServletContext().getContextPath();
		String url =  contextPath + storePath;
		
		// 返回一个JSON
		JSONObject result = new JSONObject();
		result.put("storePath", storePath);
		result.put("url", url);		
		return result;
	}
}
