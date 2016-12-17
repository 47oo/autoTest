package com.cqupt.cmd;

import java.io.IOException;

import org.dom4j.Document;

import com.cqupt.entity.Conf;
import com.cqupt.load.LoadEntity;
import com.cqupt.parse.IParse;
import com.cqupt.parse.ParseImpl;
import com.cqupt.tostring.ToString;
import com.cqupt.utils.Utils;

public class CMD {

	private CMD() {

	}

	public static String createTestCaseString(String path) {
		IParse ie = new ParseImpl();
		Document d;
		try {
			// 加载配置文件
			if (path == null) {
				d = ie.getAutoXml();
			} else {
				d = ie.getAutoXml(path);
			}
			LoadEntity le = new LoadEntity();
			// 将配置文件信息装载到对象
			Conf conf = le.loadConf(d);
			ToString ts = new ToString();
			// 将对象内容转化为json字符串
			return ts.getNeedString(conf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "[ERROR]:加载失败";
	}
	
	public static String createTestCaseString(){
		
		return createTestCaseString(null);
	}
	public static String createTestCaseFile(String xmlpath,String to){
		String result="失败";
		try {
			result = Utils.toFile(createTestCaseString(xmlpath), to);
		} catch (IOException e) {
			System.out.println("[ERROR-AUTO]:IO异常");
		}
		
		return result;
	}
	public static String createTestCaseFile(String to){
		String result="失败";
		try {
			result = Utils.toFile(createTestCaseString(null), to);
		} catch (IOException e) {
			System.out.println("[ERROR-AUTO]:IO异常");
		}
		return result;
	}
	
}
