package com.bookstore.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils
{
	/**
	 * 把Map的值注入到bean中
	 * @param value 需要注入的数据
	 * @param bean  注入的bean对象
	 */
	public  static <T> T injectIntoBean(Map value, T bean)
	{
		try
		{
			BeanUtils.populate(bean,value);
		} catch (IllegalAccessException | InvocationTargetException e)
		{
//			throw new RuntimeException(e);
			e.printStackTrace();
		}
		return bean;
	}
}
