package com.cqupt.cmd;

import org.dom4j.Document;

import com.cqupt.entity.Conf;
import com.cqupt.load.LoadEntity;
import com.cqupt.parse.IParse;
import com.cqupt.parse.ParseImpl;
import com.cqupt.tostring.ToString;

public class CMD {
	
	private CMD(){
		
	}
	public static void createTestCase(){
		IParse ie = new ParseImpl();
		try {
			//加载配置文件
			Document d = ie.getAutoXml();
			LoadEntity le = new LoadEntity();
			//将配置文件信息装载到对象
			Conf conf = le.loadConf(d);
			ToString ts = new ToString();
			//将对象内容转化为json字符串
			String target = ts.getNeedString(conf);
			System.out.println(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		createTestCase();
	}
}
