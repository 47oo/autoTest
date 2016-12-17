package com.cqupt.parse;

import org.dom4j.Document;

public interface IParse {
	
	
	Document getAutoXml(String path) throws Exception;
	

	Document getAutoXml() throws Exception;

}
