package com.cqupt.tostring;

import java.util.List;

import com.cqupt.chain.JsonType;
import com.cqupt.chain.NeedType;
import com.cqupt.entity.Chars;
import com.cqupt.entity.Conf;
import com.cqupt.entity.Key;
import com.cqupt.entity.Keys;
import com.cqupt.utils.Utils;
/**
 * 解析Conf对象并将其转化为json形式
 * @author 47
 * 注意:目前只支持json形式
 *
 */
public class ToString {
	private StringBuilder sb = new StringBuilder();
	private final static String LEFT_BRACKET = "{";
	private final static String RIFHT_BRACKET = "}";
	private final static String COMMA = ",";
//	private final static String SPACE = " ";
	private final static String COLON = ":";
	private Chars chars;

	public String getNeedString(Conf conf) {
		String type = conf.getType();
		JsonType jt = new JsonType(new NeedType());
		this.chars = conf.getChars();
		//使用责任链模式,宽展方便
		if (jt.isNeedType(type)) {
			String sum = conf.getSum();
			for (int i = 0; i < Integer.parseInt(sum); i++) {
				sb.append(step1String(conf.getKeys()));
				//删除掉最后一个逗号
				sb.deleteCharAt(sb.length()-2);
				sb.append("\n");
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
	 * 用于产生随机的字符串作为值
	 * @return
	 */
	private String randomString() {

		return Utils.RandomString(chars);
	}
	/**
	 * 不知道起什么名字我就放弃了
	 * @param keys
	 * @return
	 */
	private String step1String(Keys keys) {
		if (isNeedChars()) {
			return step2String(keys);
		} else {
			throw new RuntimeException("目前只支持随机产生");
		}
	}
	/**
	 * 同上
	 * @param keys
	 * @return
	 */
	private String step2String(Keys keys) {
		StringBuilder s = new StringBuilder();
		List<Key> list = keys.getKeychilds();
		s.append(LEFT_BRACKET);
		for (int i = 0; i < list.size(); i++) {
			Key k = list.get(i);
			List<Key> childs = k.getKeychilds();
			if (childs != null) {
				s.append(k.getName() + COLON);
				s.append(childsString(childs));
			} else {
				s.append(SinglekeyString(k));
				if(i==list.size()-1){
					s.deleteCharAt(s.length()-1);
				}
			}
		}
		s.append(RIFHT_BRACKET);
		return s.toString();
	}

	private String childsString(List<Key> childs) {
		StringBuilder s = new StringBuilder();
		s.append(LEFT_BRACKET);
		for (int i = 0; i < childs.size(); i++) {
			Key key = childs.get(i);
			if (key.getKeychilds() != null) { 
				s.append(key.getName()+COLON);
				s.append(step2String(key)+COMMA);
			} else {
				s.append(key.getName() + COLON + randomString() + COMMA);
				if(i==childs.size()-1){
					s.deleteCharAt(s.length()-1);
				}
			}
		}
		s.append(RIFHT_BRACKET + COMMA);
		return s.toString();
	}
	/**
	 * 对没有子节点所做的操作
	 * @param k
	 * @return
	 */
	private String SinglekeyString(Key k) {
		StringBuilder s = new StringBuilder();
		String name = k.getName();
		String value = randomString();
		s.append(name + COLON + value + COMMA);
		return s.toString();
	}

}
