package com.wxl.demo.factory;

import com.wxl.demo.factory.Mainboard;

public class IntelMainboard implements Mainboard {

	private int cpuHoles = 0;
	
	public IntelMainboard(int cpuHoles){
		this.cpuHoles = cpuHoles;
	}
	
	public void installCPU() {
		// TODO Auto-generated method stub
		System.err.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
	}

}
