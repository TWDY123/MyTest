package com.wxl.demo.factory.abstractFactory;

import com.wxl.demo.factory.Cpu;
import com.wxl.demo.factory.Mainboard;

public class Client {

	public static void main(String[] args) {
		AbstractFactory af = new IntelFactory();
		Cpu cpu = af.createCpu();
		Mainboard mainboard = af.createMainboard();
		cpu.calculate();
		mainboard.installCPU();
	}
	
}
