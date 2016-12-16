package com.cqupt.cmd;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.cqupt.entity.Conf;
import com.cqupt.entity.Key;
import com.cqupt.reflect.ObjectReflect;

public class CmdStart {
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		String path = System.getProperty("user.dir") + "/conf/auto.xml";
		Document d = reader.read(new File(path));
		// 获取根节点
		Element root = d.getRootElement();
		String confname = root.getName();
		Iterator<Attribute> it = root.attributeIterator();
		ObjectReflect<Conf> o = new ObjectReflect<>();
		Conf conf = o.getObject(it, Conf.class);
		System.out.println(conf);
		Element chars = root.element("chars");
		System.out.println(chars.getData());
		//是否有混合的内容
		System.out.println(chars.hasMixedContent());
		Element keys = root.element("keys");
		System.out.println(keys.hasMixedContent());
		List<Element> list = keys.elements();
		for(int i =0;i<list.size();i++){
			Element ee = list.get(i);
			Iterator<Attribute> itt = ee.attributeIterator();
			ObjectReflect<Key> oo = new ObjectReflect<>();
			Key kk = oo.getObject(itt, Key.class);
			System.out.println(kk);
		}
	}
}
