package com.cqupt.entity;

/**
 * 
 * @author 47 配置文件的最外层的属性
 */
public class Conf {
	private String type;
	private String sum;
	private String standard;
	// conf的子节点且只有一个
	private Keys keys;
	private Chars chars;

	@Override
	public String toString() {
		return "Conf [type=" + type + ", sum=" + sum + ", standard=" + standard + ", keys=" + keys + ", chars=" + chars
				+ "]";
	}

	public Conf() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	public void setKeys(Keys keys){
		this.keys = keys;
	}
	public Keys getKeys() {
		return keys;
	}
	public void setChars(Chars chars){
		this.chars=chars;
	}
	public Chars getChars() {
		return chars;
	}
}
