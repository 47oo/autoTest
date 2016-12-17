package com.cqupt.load;

import java.lang.reflect.InvocationTargetException;

import org.dom4j.Document;
import org.dom4j.Element;

import com.cqupt.entity.Chars;
import com.cqupt.entity.Conf;
import com.cqupt.entity.Keys;
import com.cqupt.reflect.ObjectReflect;

public class LoadEntity {

	public Conf loadConf(Document d) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		// 获取根节点conf,有且只有一个conf
		Element root = d.getRootElement();
		// 得到根节点的属性
		@SuppressWarnings("unchecked")
		Conf conf = ObjectReflect.getObject(root.attributeIterator(), Conf.class);
		//将它的子节点装进去
		conf.setChars(loadChars(root));
		conf.setKeys(loadKeys(root));
		return conf;
	}

	private Chars loadChars(Element root) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//得到根节点的子节点
		Element ce = root.element("chars");
		@SuppressWarnings("unchecked")
		Chars chars = ObjectReflect.getObject(ce.attributeIterator(), Chars.class);
		chars.setChars((String) ce.getData());
		return chars;
	}
	
	@SuppressWarnings("unchecked")
	private Keys loadKeys(Element root) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Element ke = root.element("keys");
		//得到keys标签的所有子节点
		Keys keys = new Keys();
		ObjectReflect.getObjectAll(ke.elementIterator(), keys);
		return keys;
	}
}
