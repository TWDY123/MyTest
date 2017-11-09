package com.wxl.demo.util;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ExcelUtilTest {

	@Test
	public void readExcelTest(){
		String filePath = "C:\\dev\\temp\\test1.xlsx";
		List<Map<String, String>> contentList = ExcelUtil.readExcelHaveHead(filePath);
		for (Map<String, String> map : contentList) {
			for(String key : map.keySet()){
				System.err.println("key="+key+",val="+map.get(key));
			}
		}
	}
	
}
