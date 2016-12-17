package com.cqupt.entity;

import java.util.List;
/**
 * 
 * @author 47
 *	key标签
 */
public class Key extends Keys{
	private String name;
	private String value;
	private String isArray;
	//单个对象
	private List<Key> keychilds;
	//数组对象未实现
	private List<Arr> arrChilds;
	public Key(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<Key> getKeychilds() {
		return keychilds;
	}
	public void setKeyChilds(List<Key> keys){
		this.keychilds=keys;
	}
	@Override
	public String toString() {
		return "Key [name=" + name + ", value=" + value + "]";
	}
	public String getIsArray() {
		return isArray;
	}
	public void setIsArray(String isArray) {
		this.isArray = isArray;
	}
	public List<Arr> getArrChilds() {
		return arrChilds;
	}
	public void setArrChilds(List<Arr> arrChilds) {
		this.arrChilds = arrChilds;
	}
	
}
