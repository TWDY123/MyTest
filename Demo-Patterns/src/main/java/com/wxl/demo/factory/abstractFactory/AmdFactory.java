package com.wxl.demo.factory.abstractFactory;

import com.wxl.demo.factory.AmdCpu;
import com.wxl.demo.factory.AmdMainboard;
import com.wxl.demo.factory.Cpu;
import com.wxl.demo.factory.Mainboard;

public class AmdFactory implements AbstractFactory {

	public Cpu createCpu() {
		// TODO Auto-generated method stub
		return new AmdCpu(938);
	}

	public Mainboard createMainboard() {
		// TODO Auto-generated method stub
		return new AmdMainboard(938);
	}

}
