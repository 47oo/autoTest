package com.cqupt.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import com.cqupt.entity.Chars;

/**
 *	工具类
 * @author 47
 *
 */
public class Utils {
	//生成随机字符串
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
	/**
	 * 
	 * @param str要导出的字符串
	 * @param to 导出字符串位置
	 * @return
	 * @throws IOException 
	 */
	
	public static String toFile(String str,String to) throws IOException{
		File file = new File(to);
		while(file.exists()){
			to = to +r.nextInt(10000);
			file = new File(to);
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(str.getBytes());
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR-ATHO]:文件没有找到");
		} catch (IOException e) {
			System.out.println("[ERROR-ATHO]:IO异常");
		}finally{
			if(fos!=null){
				fos.close();
			}
		}
		return "已经保存到"+to;
	}
}
