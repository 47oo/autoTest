package com.cqupt.entity;

import java.util.List;
/**
 * 
 * @author 47
 * keys标签,有且只能有一个
 */
public class Keys {
	private List<Key> keyChilds;
	
	public Keys(){
		
	}
	public void setKeyChilds(List<Key> keys){
		this.keyChilds =keys;
	}
	public List<Key> getKeychilds(){
		return keyChilds;
	}
}
