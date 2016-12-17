package com.cqupt.utils;

import java.util.Random;

import com.cqupt.entity.Chars;

/**
 * 工具类
 * @author 47
 *
 */
public class Utils {
	//随机生成字符串方法
	private static Random r = new Random();
	public static String RandomString(Chars c){
		StringBuilder sb = new StringBuilder();
		String regex = c.getRegex();
		String str = c.getChars();
		String[] arr = str.split(regex);
		int need = r.nextInt(arr.length);
		for(int i=0;i<need;i++){
			sb.append(arr[r.nextInt(arr.length)]);
		}
//		System.out.println(sb.toString());
//		i++;
//		System.out.println(i);
		return sb.toString();
	}
}
