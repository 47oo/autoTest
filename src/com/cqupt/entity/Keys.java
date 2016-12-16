package com.cqupt.entity;

import java.util.List;

public class Keys {
	private List<Key> keyChilds;
	
	public Keys(){
		
	}
	public void setKeyChilds(List<Key> keys){
		this.keyChilds =keys;
	}
	public List<Key> getList(){
		return keyChilds;
	}
}
