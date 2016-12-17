package com.cqupt.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.cqupt.entity.Key;
import com.cqupt.entity.Keys;

/**
 * 
 * @author hp
 *
 * @param <T> ������������
 * @param <E> ������Ԫ������
 */
public class ObjectReflect{
	
	private final static String PREFIX="set";
	/**
	 * �����Է�װ����
	 * @param e
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	@SuppressWarnings("unchecked")
	public static <T>T getObject(Iterator<Attribute> it,Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Object obj = clazz.newInstance();
		while(it.hasNext()){
			Attribute ae = it.next();
			String name = ae.getName();
			String value = ae.getValue();
			Method m = clazz.getMethod(PREFIX+getUpperByFirst(name), String.class);
			m.invoke(obj, value);
		}
		return (T) obj;
	}
	
	//ѭ��Ƕ��,����ӽڵ����������ֵ
	@SuppressWarnings("unchecked")
	public static void getObjectAll(Iterator<Element> it,Keys k) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		ArrayList<Key> keys = new ArrayList<>();
		while(it.hasNext()){
			Element e = it.next();
			Key key = getObject(e.attributeIterator(),Key.class);
			if(e.hasMixedContent()){
				getObjectAll(e.elementIterator(),key);
			}
			keys.add(key);
		}
		k.setKeyChilds(keys);
	}
	/**
	 * ���ڵ����ĵ�һ����ĸ��Ϊ��д
	 * @param name
	 * @return
	 */
	private static String getUpperByFirst(String name){
		if(name==null||name.trim().equals("")){
			throw new RuntimeException("auto:====>>>name����Ϊ��");
		}
		String nameNew = name.substring(0, 1).toUpperCase()+name.substring(1);
		return nameNew;
	}
	
}