package com.wxl.demo.single;

public class Singleton {

	private Singleton(){};
	
	public enum SomeThing {
	    INSTANCE;
	    private Singleton instance;
	    SomeThing() {
	        instance = new Singleton();
	    }
	    public Singleton getInstance() {
	        return instance;
	    }
	}
	
}
