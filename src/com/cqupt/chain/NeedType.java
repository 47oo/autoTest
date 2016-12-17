package com.cqupt.chain;

public class NeedType {

	public boolean isNeedType(String type) {
		if(isType(type)){
			return true;
		}
		return false;
	}
	
	protected boolean isType(String type){
		String temp = getClass().getSimpleName().toLowerCase().replace("type", "");
		if(type.equals(temp)){
			
			return true;
		}
		return false;
		
	}
}
