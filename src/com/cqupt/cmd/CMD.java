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
			//将配置文件的东西装载到对象
			Conf conf = le.loadConf(d);
			//转化为字符串
			ToString ts = new ToString();
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
