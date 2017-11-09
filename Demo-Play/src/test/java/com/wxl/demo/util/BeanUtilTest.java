package com.wxl.demo.util;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.wxl.demo.TestBean;

public class BeanUtilTest {

	@Test
	public void buildByMethodTest1(){
		String filePath = "C:\\dev\\temp\\test1.xlsx";
		List<Map<String, String>> contentList = ExcelUtil.readExcelHaveHead(filePath);
		for (Map<String, String> map : contentList) {
			TestBean tb = new TestBean();
			BeanUtil.buildByMethod(map, tb);
			System.err.println(tb);
		}
	}
	
	@Test
	public void buildByMethodTest2(){
		String filePath = "C:\\dev\\temp\\test1.xlsx";
		List<Map<String, String>> contentList = ExcelUtil.readExcelHaveHead(filePath);
		for (Map<String, String> map : contentList) {
			TestBean tb = BeanUtil.buildByMethod(map, TestBean.class);
			System.err.println(tb);
		}
	}
	
	@Test
	public void buildByFieldTest1(){
		String filePath = "C:\\dev\\temp\\test1.xlsx";
		List<Map<String, String>> contentList = ExcelUtil.readExcelHaveHead(filePath);
		for (Map<String, String> map : contentList) {
			TestBean tb = new TestBean();
			BeanUtil.buildByField(map, tb);
			System.err.println(tb);
		}
	}
	
	@Test
	public void buildByFieldTest2(){
		String filePath = "C:\\dev\\temp\\test1.xlsx";
		List<Map<String, String>> contentList = ExcelUtil.readExcelHaveHead(filePath);
		for (Map<String, String> map : contentList) {
			TestBean tb = BeanUtil.buildByField(map, TestBean.class);
			System.err.println(tb);
		}
	}
	
	@Test
	public void buildTest1(){
		String filePath = "C:\\dev\\temp\\test1.xlsx";
		List<Map<String, String>> contentList = ExcelUtil.readExcelHaveHead(filePath);
		for (Map<String, String> map : contentList) {
			TestBean tb = new TestBean();
			BeanUtil.build(map, tb);
			System.err.println(tb);
		}
	}
	
}
