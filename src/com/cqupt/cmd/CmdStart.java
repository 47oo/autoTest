package com.cqupt.cmd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author 47 命令行启动 
 * create default 
 * create xmlpath 
 * to savepath
 */
public class CmdStart {
	private static String CMD_CREATE="create";
	private static String CMD_TO="to";
	//这里我就不写常量了
	public static void main(String[] args) throws Exception {
		if (args.length % 2 != 0) {
			System.out.println("请仔细检查输入的命令");
		} else {
			Map<String, String> map = new HashMap<>();
			for (int i = 0; i < args.length; i += 2) {
				map.put(args[i], args[i + 1]);
			}
			start(map);
		}
	}

	private static void start(Map<String, String> map) {
		Set<Entry<String, String>> set = map.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		String create = null;
		String to =null;
		while(it.hasNext()){
			Entry<String, String> e = it.next();
			if(CMD_CREATE.equals(e.getKey())){
				create = e.getValue();
			}else if(CMD_TO.equals(e.getKey())){
				to=e.getValue();
			}else{
				System.out.println("[ERROR-AUTO]:无效命令!!!");
			}
		}
		if(to==null||create==null){
			System.out.println("[ERROR-AUTO]:请补全命令:");
			System.out.println("命令格式: create default/xmlpath to savepath");
			return;
		}
		if(create.equals("default")){
			System.out.println(CMD.createTestCaseFile(to));
		}else{
			System.out.println(CMD.createTestCaseFile(create, to));
		}
	}
	
}
