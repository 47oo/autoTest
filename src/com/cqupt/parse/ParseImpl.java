package com.cqupt.parse;

import java.io.File;

import org.dom4j.Document;

public class ParseImpl implements IParse{

	@Override
	public Document getAutoXml(String path) {
		//��ȡ�����ļ���file
		File file = new File(path);
		
		return null;
	}

	@Override
	public Document getAutoXml() {
		return null;
	}
	
}
