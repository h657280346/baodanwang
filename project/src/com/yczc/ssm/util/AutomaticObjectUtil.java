package com.yczc.ssm.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.yczc.ssm.pojo.Contest;

public class AutomaticObjectUtil {

	/**
	 * 自动装配pojo对象
	 * 
	 * @param map
	 * @param c
	 * @return
	 */
	public static Object newInstance(Map<String, Object> map, Class<?> c) {
		Object obj = null;
		try {
			obj = c.newInstance();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Field field = null;
				try {
					field = c.getDeclaredField(entry.getKey());
					// 非static类型
					if (!Modifier.isStatic(field.getModifiers())) {
						field.setAccessible(true);
						String fiedName = field.getName();
						Class<?> type = field.getType();
						// 构造setter方法名
						String mtdName = "set" + fiedName.substring(0, 1).toUpperCase() + fiedName.substring(1);
						Method mtd = null;
						try {
							mtd = c.getDeclaredMethod(mtdName, type);
							// 执行set方法
							if (entry.getValue() instanceof String && entry.getValue().equals("")) {
								entry.setValue(null);
							}
							mtd.invoke(obj, entry.getValue());
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				} catch (NoSuchFieldException e) {
					continue;
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return obj;
	}

	public static Map<String, Object> objectToMap(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			// 非static类型
			if (!Modifier.isStatic(field.getModifiers())){
				try {
					if(field.get(obj)!=null&&!field.get(obj).equals("")){	
						map.put(field.getName(), field.get(obj));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
	/**
	 * 获取pojo对象所有实例变量名
	 * 
	 * @param c
	 * @return
	 */
	public static Map<String, Object> getFieldsName(Class<?> c) {
		Map<String, Object> fieldMap = null;
		Field[] fields = c.getDeclaredFields();
		if (fields.length == 0) {
			return null;
		} else {
			fieldMap = new HashMap<String, Object>();
			for (Field field : fields) {
				// 非static类型
				if (!Modifier.isStatic(field.getModifiers()))
					fieldMap.put(field.getName(), field.getType());
			}
		}
		return fieldMap;
	}
}
