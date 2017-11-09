package com.wxl.demo.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanUtil {

	private static final Logger log = LoggerFactory.getLogger(BeanUtil.class);

	/**
	 * 通过参数和方法赋值构建bean
	 * @param contentMap
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T build(Map<String, String> contentMap, Class<T> t) {
		try {
			Object obj = t.newInstance();
			return (T) build(contentMap, obj);
		} catch (Exception e) {
			log.error("初始化对象失败", e);
		}
		return null;
	}
	
	/**
	 * 通过参数和方法赋值构建bean
	 * @param contentMap
	 * @param t 对象
	 * @return
	 */
	public static <T> T build(Map<String, String> contentMap, T obj) {
		buildByField(contentMap, obj);
		buildByMethod(contentMap, obj); 
		return obj;
	}
	
	
	/**
	 * 通过参数赋值构建bean
	 * @param contentMap
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T buildByField(Map<String, String> contentMap, Class<T> t) {
		try {
			Object obj = t.newInstance();
			return (T) buildByField(contentMap, obj);
		} catch (Exception e) {
			log.error("初始化对象失败", e);
		}
		return null;
	}

	/**
	 * 通过参数赋值构建bean
	 * @param contentMap
	 * @param obj
	 * @return
	 */
	public static <T> T buildByField(Map<String, String> contentMap, T obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		Map<String, Field> fieldMap = new HashMap<String, Field>();
		for (Field field : fields) {
			fieldMap.put(field.getName(), field);
		}
		for (String key : contentMap.keySet()) {
			Field field = fieldMap.get(key);
			if (null == field) {
				continue;
			}
			field.setAccessible(true);
			String val = contentMap.get(key);
			try {
				field.set(obj, dealVal(val, field.getType()));
			} catch (Exception e) {
				log.error("赋值失败,field=" + field.getName() + ",val=" + val, e);
			}
		}
		return obj;
	}

	/**
	 * 通过方法赋值构建bean
	 * @param contentMap
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T buildByMethod(Map<String, String> contentMap, Class<T> t) {
		try {
			Object obj = t.newInstance();
			return (T) buildByMethod(contentMap, obj);
		} catch (Exception e) {
			log.error("初始化对象失败", e);
		}
		return null;
	}

	/**
	 * 通过方法赋值构建bean
	 * @param contentMap
	 * @param obj
	 * @return
	 */
	public static <T> T buildByMethod(Map<String, String> contentMap, T obj) {
		Method[] Methods = obj.getClass().getDeclaredMethods();
		Map<String, Method> methodMap = new HashMap<String, Method>();
		for (Method method : Methods) {
			// 只要public的方法
			if (method.getModifiers() != 1) {
				continue;
			}
			methodMap.put(method.getName(), method);
		}
		for (String key : contentMap.keySet()) {
			Method method = methodMap.get(key);
			if (null == method) {
				continue;
			}
			// TODO 暂时只支持单个参数传入
			if (method.getParameterCount() != 1) {
				continue;
			}
			String val = contentMap.get(key);
			Parameter param = method.getParameters()[0];
			try {
				method.invoke(obj, dealVal(val, param.getType()));
			} catch (Exception e) {
				log.error("赋值失败,methodName=" + key + ",val=" + val, e);
			}
		}
		return obj;
	}

	/**
	 * 处理值
	 * @param val
	 * @param type
	 * @return
	 */
	private static Object dealVal(String val, Class<?> type) throws Exception {
		if (val == null) {
			return null;
		}
		if (type.equals(String.class)) {
			return val;
		}
		if (type.equals(Integer.class) || type.equals(int.class)) {
			return convertInteger(val);
		}
		if (type.equals(Double.class) || type.equals(double.class)) {
			return convertDouble(val);
		}
		if (type.equals(Float.class) || type.equals(float.class)) {
			return convertFloat(val);
		}
		if (type.equals(Boolean.class) || type.equals(boolean.class)) {
			return convertBoolean(val);
		}
		return val;
	}
	
	/**
	 * 转成int
	 * @param val
	 * @return
	 */
	private static Integer convertInteger(String val){
		BigDecimal bd = new BigDecimal(val);
		return bd.intValue();
	}
	
	/**
	 * 转成Double
	 * @param val
	 * @return
	 */
	private static Double convertDouble(String val){
		BigDecimal bd = new BigDecimal(val);
		return bd.doubleValue();
	}
	
	/**
	 * 转成Float
	 * @param val
	 * @return
	 */
	private static Float convertFloat(String val){
		BigDecimal bd = new BigDecimal(val);
		return bd.floatValue();
	}
	
	/**
	 * 转成Boolean
	 * @param val
	 * @return
	 */
	private static Boolean convertBoolean(String val){
		if ("true".equalsIgnoreCase(val) || "1".equals(val)) {
			return true;
		}
		return false;
	}

}
