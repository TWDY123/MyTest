package com.wxl.demo.factory.simpleFactory;

import com.wxl.demo.factory.AmdCpu;
import com.wxl.demo.factory.Cpu;
import com.wxl.demo.factory.IntelCpu;

public class CpuFactory {

	public static Cpu createCpu(int type) {
		Cpu cpu = null;
		if (1 == type) {
			cpu = new IntelCpu(774);
		}
		if (2 == type) {
			cpu = new AmdCpu(938);
		}
		return cpu;
	}

}
