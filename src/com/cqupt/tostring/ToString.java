package com.cqupt.tostring;

import java.util.List;

import com.cqupt.chain.JsonType;
import com.cqupt.chain.NeedType;
import com.cqupt.entity.Chars;
import com.cqupt.entity.Conf;
import com.cqupt.entity.Key;
import com.cqupt.entity.Keys;
import com.cqupt.utils.Utils;

public class ToString {
	private StringBuilder sb = new StringBuilder();
	private final static String LEFT_BRACKET = "{";
	private final static String RIFHT_BRACKET = "}";
	private final static String COMMA = ",";
	private final static String SPACE = " ";
	private final static String COLON = ":";
	private Chars chars;

	public String getNeedString(Conf conf) {
		String type = conf.getType();
		JsonType jt = new JsonType(new NeedType());
		this.chars = conf.getChars();
		// 规范暂时无效
		if (jt.isNeedType(type)) {
			String sum = conf.getSum();
			for (int i = 0; i < Integer.parseInt(sum); i++) {
				sb.append(step1String(conf.getKeys()) + "\n");
			}
			return sb.toString();
		} else {
			return null;
		}
	}

	private boolean isNeedChars() {
		return chars.getOpen().equals("true");
	}

	/**
	 * 生成随机字符串
	 * 
	 * @return
	 */
	private String randomString() {

		return Utils.RandomString(chars);
	}

	private String step1String(Keys keys) {
		if (isNeedChars()) {
			return step2String(keys);
		} else {
			return null;
		}
	}

	private String step2String(Keys keys) {
		StringBuilder s = new StringBuilder();
		List<Key> list = keys.getKeychilds();
		s.append(LEFT_BRACKET + SPACE);
		for (int i = 0; i < list.size(); i++) {
			Key k = list.get(i);
			List<Key> childs = k.getKeychilds();
			if (childs != null) {
				s.append(k.getName() + COLON);
				s.append(childsString(childs));
			} else {
				s.append(SinglekeyString(k));
			}
		}
		s.append(RIFHT_BRACKET + SPACE);
		return s.toString();
	}

	private String childsString(List<Key> childs) {
		StringBuilder s = new StringBuilder();
		s.append(LEFT_BRACKET + SPACE);
		for (int i = 0; i < childs.size(); i++) {
			Key key = childs.get(i);
			if (key.getKeychilds() != null) { //新修改
				s.append(key.getName()+COLON);
				s.append(step2String(key));
			} else {

				s.append(key.getName() + COLON + randomString() + COMMA);
			}
		}
		s.append(RIFHT_BRACKET + COMMA);
		return s.toString();
	}

	private String SinglekeyString(Key k) {
		StringBuilder s = new StringBuilder();
		String name = k.getName();
		String value = randomString();
		s.append(name + COLON + value + COMMA);
		return s.toString();
	}

}
