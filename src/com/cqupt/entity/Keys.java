package com.cqupt.entity;

import java.util.ArrayList;
import java.util.List;

public class Keys {
	private static List<Key> keyChilds = new ArrayList<>();
	
	public Keys(){
		
	}
	void addKeyChild(Key k){
		keyChilds.add(k);
	}
	List<Key> getList(){
		return keyChilds;
	}
}
