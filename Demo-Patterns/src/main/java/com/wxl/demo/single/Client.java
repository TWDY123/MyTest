package com.wxl.demo.single;

import com.wxl.demo.single.Singleton.SomeThing;

public class Client {

	public static void main(String[] args) {
		Singleton singleton = SomeThing.INSTANCE.getInstance();
	}
	
}
