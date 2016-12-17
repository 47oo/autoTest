package com.cqupt.parse;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class ParseImpl implements IParse{
	
	/**
	 * 读取配置文件
	 */
	@Override
	public Document getAutoXml(String path) throws DocumentException {
		File file = new File(path);
		SAXReader reader = new SAXReader();
		Document d = reader.read(file);
		return d;
	}
	/**
	 * 默认读取配置文件
	 */
	@Override
	public Document getAutoXml() throws DocumentException {
		SAXReader reader = new SAXReader();
		String path = System.getProperty("user.dir") + "/conf/auto.xml";
		Document d = reader.read(new File(path));
		return d;
	}
	
}
