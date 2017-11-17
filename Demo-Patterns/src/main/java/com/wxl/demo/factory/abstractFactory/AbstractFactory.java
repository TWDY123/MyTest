package com.wxl.demo.factory.abstractFactory;

import com.wxl.demo.factory.Cpu;
import com.wxl.demo.factory.Mainboard;

public interface AbstractFactory {

	public Cpu createCpu();
	
	public Mainboard createMainboard();
	
}
