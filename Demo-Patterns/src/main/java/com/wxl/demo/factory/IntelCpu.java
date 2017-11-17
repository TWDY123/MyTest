package com.wxl.demo.factory;

import com.wxl.demo.factory.Cpu;

public class IntelCpu implements Cpu {

	private int pins = 0;

	public IntelCpu(int pins) {
		this.pins = pins;
	}

	public void calculate() {
		// TODO Auto-generated method stub
		System.err.println("Intel CPU的脚针数为：" + pins);
	}

}
