package com.wxl.demo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelUtil {

	private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

	private static final String EXTENSION_XLS = "xls";
	private static final String EXTENSION_XLSX = "xlsx";

	/**
	 * 读取Excel内容
	 * 文件带头
	 * @param filePath 文件全路径
	 * @return
	 */
	public static List<Map<String, String>> readExcelHaveHead(String filePath){
		List<Map<String, String>> resList = new ArrayList<Map<String,String>>();
		List<List<String>> contentList = readExcel(filePath);
		if (contentList.size()<2) {
			return resList;
		}
		List<String> headList = contentList.get(0);
		for (int i = 1; i < contentList.size(); i++) {
			List<String> content = contentList.get(i);
			Map<String, String> map = new HashMap<String, String>();
			for (int j = 0; j < content.size(); j++) {
				map.put(headList.get(j), content.get(j));
			}
			resList.add(map);
		}
		return resList;
	}
	
	/**
	 * 读取Excel内容
	 * 文件不带头
	 * @param filePath 文件全路径
	 * @return
	 */
	public static List<List<String>> readExcelNoHead(String filePath){
		return readExcel(filePath);
	}
	
	
	/**
	 * 读取Excel内容
	 * @param filePath 文件全路径
	 * @return
	 */
	private static List<List<String>> readExcel(String filePath) {
		List<List<String>> contentList = new ArrayList<List<String>>();
		Workbook wb = getWorkbook(filePath);
		try {
			if (null == wb) {
				return contentList;
			}
			Sheet sheet = wb.getSheetAt(0);
			if (null == sheet) {
				return contentList;
			}
			int firstRowIndex = sheet.getFirstRowNum();// 首行
			int lastRoleIndex = sheet.getLastRowNum();// 最后一行
			for (int i = firstRowIndex; i <= lastRoleIndex; i++) {
				Row row = sheet.getRow(i);
				int firstColumnIndex = row.getFirstCellNum(); // 首列
				int lastColumnIndex = row.getLastCellNum();// 最后一列
				List<String> rowList = new ArrayList<String>();
				for (int j = firstColumnIndex; j < lastColumnIndex; j++) {
					rowList.add(getCellValue(row.getCell(j)));
				}
				contentList.add(rowList);
			}
		} catch (Exception e) {
			log.error("读取Excel出错", e);
		} finally {
			try {
				if (wb != null) {
					wb.close();
				}
			} catch (Exception e2) {
				log.error("关闭资源失败", e2);
			}
		}
		return contentList;
	}

	/**
	 * 判断03还是07
	 * @param filePath
	 * @return
	 */
	private static Workbook getWorkbook(String filePath) {
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
			if (filePath.endsWith(EXTENSION_XLS)) {
				return new HSSFWorkbook(is);
			}
			if (filePath.endsWith(EXTENSION_XLSX)) {
				return new XSSFWorkbook(is);
			}
			log.error("文件格式错误");
		} catch (FileNotFoundException e) {
			log.error("文件不存在", e);
		} catch (IOException e) {
			log.error("读取Excel失败", e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e2) {
				log.error("关闭资源失败", e2);
			}
		}
		return null;
	}
	
	/**
     * 取单元格的值
     * @param cell 单元格对象
     * @return
     */
    private static String getCellValue(Cell cell) {
    	String val = null;
        if (cell == null) {
            return val;
        }
//        cell.setCellType(Cell.CELL_TYPE_STRING);
        switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				val = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				val = String.valueOf(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				val = cell.getStringCellValue();
			default:
				break;
		}
        return val;
    }


}
