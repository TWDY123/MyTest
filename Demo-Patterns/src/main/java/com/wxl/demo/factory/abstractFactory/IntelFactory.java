package com.wxl.demo.factory.abstractFactory;

import com.wxl.demo.factory.Cpu;
import com.wxl.demo.factory.IntelCpu;
import com.wxl.demo.factory.IntelMainboard;
import com.wxl.demo.factory.Mainboard;

public class IntelFactory implements AbstractFactory{

	public Cpu createCpu() {
		return new IntelCpu(755);
	}

	public Mainboard createMainboard() {
		return new IntelMainboard(755);
	}



}
