###AutoTestCase使用

+ 命令行  
	```Java
		java -jar jar包   create default/xmlpath to savepath
	```

	- default 默认位置 conf下面的auto.xml文件
	- xmlpath 自己指定位置
	- to 保存文件的位置,生成失败也产生一个简单的日志输出位置会在命令行中提示
	- 依赖jar包 dam4j-1.6.1.jar

+ jar包使用
	```Java
		//需要将autoCase-1.0.jar和dom4j同时使用
	```
	- 对外开放类名CMD
		- 直接调用CMD的方法即可,全部为静态方法,不支持创建CMD对象