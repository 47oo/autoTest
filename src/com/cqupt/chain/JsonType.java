package com.cqupt.chain;

public class JsonType extends NeedType {

	private NeedType need;

	public JsonType(NeedType need ){
		this.need = need;
	}

	@Override
	public boolean isNeedType(String type) {

		if (isType(type)) {
			return true;
		} else {
			return need.isNeedType(type);
		}
	}

}
