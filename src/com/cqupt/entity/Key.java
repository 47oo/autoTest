package com.cqupt.entity;

import java.util.List;

public class Key extends Keys{
	private String name;
	private String value;
	private List<Key> keychilds;
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
	
	
	
}
