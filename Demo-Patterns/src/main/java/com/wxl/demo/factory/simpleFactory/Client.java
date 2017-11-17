package com.wxl.demo.factory.simpleFactory;

import com.wxl.demo.factory.Cpu;
import com.wxl.demo.factory.Mainboard;

public class Client {

	public static void main(String[] args) {
		Cpu cpu = CpuFactory.createCpu(1);
		Mainboard mainboard = MainboardFactory.createMainboard(1);
		cpu.calculate();
		mainboard.installCPU();
	}
	
}
