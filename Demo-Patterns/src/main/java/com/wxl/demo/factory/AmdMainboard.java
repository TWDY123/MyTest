package com.wxl.demo.factory;

import com.wxl.demo.factory.Mainboard;

public class AmdMainboard implements Mainboard {

	private int cpuHoles = 0;

	public AmdMainboard(int cpuHoles) {
		this.cpuHoles = cpuHoles;
	}

	public void installCPU() {
		// TODO Auto-generated method stub
		System.err.println("AMD主板的CPU插槽孔数是：" + cpuHoles);
	}

}
