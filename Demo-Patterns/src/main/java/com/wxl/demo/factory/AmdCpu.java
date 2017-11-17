package com.wxl.demo.factory;

import com.wxl.demo.factory.Cpu;

public class AmdCpu implements Cpu {

	private int pins = 0;

	public AmdCpu(int pins) {
		this.pins = pins;
	}

	public void calculate() {
		// TODO Auto-generated method stub
		System.err.println("AMD CPU的脚针数为：" + pins);
	}

}
