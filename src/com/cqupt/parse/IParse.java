package com.cqupt.parse;

import org.dom4j.Document;

public interface IParse {
	
	//加载XML文件
	Document getAutoXml(String path) throws Exception;
	
	//默认位置加载XML文件
	Document getAutoXml() throws Exception;

}
