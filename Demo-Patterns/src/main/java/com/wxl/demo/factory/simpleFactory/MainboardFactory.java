package com.wxl.demo.factory.simpleFactory;

import com.wxl.demo.factory.AmdMainboard;
import com.wxl.demo.factory.IntelMainboard;
import com.wxl.demo.factory.Mainboard;

public class MainboardFactory {

	public static Mainboard createMainboard(int type){
		Mainboard mainboard = null;
		if (1==type) {
			mainboard = new IntelMainboard(774);
		}
		if (2==type) {
			mainboard = new AmdMainboard(938);
		}
		return mainboard;
	}
	
}
