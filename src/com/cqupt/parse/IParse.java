package com.cqupt.parse;

import org.dom4j.Document;

public interface IParse {
	
	//����XML�ļ�
	Document getAutoXml(String path) throws Exception;
	
	//Ĭ��λ�ü���XML�ļ�
	Document getAutoXml() throws Exception;

}
