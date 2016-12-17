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
		// ��ȡ���ڵ�conf,����ֻ��һ��conf
		Element root = d.getRootElement();
		// �õ����ڵ������
		@SuppressWarnings("unchecked")
		Conf conf = ObjectReflect.getObject(root.attributeIterator(), Conf.class);
		//�������ӽڵ�װ��ȥ
		conf.setChars(loadChars(root));
		conf.setKeys(loadKeys(root));
		return conf;
	}

	private Chars loadChars(Element root) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//�õ����ڵ���ӽڵ�
		Element ce = root.element("chars");
		@SuppressWarnings("unchecked")
		Chars chars = ObjectReflect.getObject(ce.attributeIterator(), Chars.class);
		chars.setChars((String) ce.getData());
		return chars;
	}
	
	@SuppressWarnings("unchecked")
	private Keys loadKeys(Element root) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Element ke = root.element("keys");
		//�õ�keys��ǩ�������ӽڵ�
		Keys keys = new Keys();
		ObjectReflect.getObjectAll(ke.elementIterator(), keys);
		return keys;
	}
}
