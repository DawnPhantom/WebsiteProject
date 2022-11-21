package com.bookstore.utils;

public class CommonUtils
{
	public static int parseInt(String str)
	{
		return parseInt(str, 0);
	}

	public static int parseInt(String str, int defaultNum)
	{
		try
		{
			return Integer.parseInt(str);
		}catch(Exception ignored)
		{
			return defaultNum;
		}
	}
}
