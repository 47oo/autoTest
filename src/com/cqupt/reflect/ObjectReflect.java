package com.cqupt.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.dom4j.Attribute;

/**
 * 
 * @author hp
 *
 * @param <T> ������������
 * @param <E> ������Ԫ������
 */
public class ObjectReflect<T>{
	
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
	public T getObject(Iterator<Attribute> it,Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Object obj = clazz.newInstance();
		while(it.hasNext()){
			Attribute ae = it.next();
			String name = ae.getName();
			String value = ae.getValue();
			Method m = clazz.getMethod(PREFIX+getUpperByFirst(name), String.class);
			m.invoke(obj, value);
		}
		return (T)obj;
	}
	
	/**
	 * ���ڵ����ĵ�һ����ĸ��Ϊ��д
	 * @param name
	 * @return
	 */
	private String getUpperByFirst(String name){
		if(name==null||name.trim().equals("")){
			throw new RuntimeException("auto:====>>>name����Ϊ��");
		}
		String nameNew = name.substring(0, 1).toUpperCase()+name.substring(1);
		return nameNew;
	}
	
}