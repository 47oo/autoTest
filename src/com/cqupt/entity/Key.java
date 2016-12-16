package com.cqupt.entity;

import java.util.ArrayList;
import java.util.List;

public class Key {
	private String name;
	private String value;
	private static List<Key> keychilds = new ArrayList<>();
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
	public void setKeyChild(Key key){
		keychilds.add(key);
	}
	@Override
	public String toString() {
		return "Key [name=" + name + ", value=" + value + "]";
	}
	
	
	
}
