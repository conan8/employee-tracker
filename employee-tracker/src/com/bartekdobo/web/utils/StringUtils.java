package com.bartekdobo.web.utils;

public class StringUtils {
	
	public static String createFullName(String firstname, String lastname) {
		String fullName = new StringBuilder()
										.append(firstname)
										.append(" ")
										.append(lastname)
										.toString();
		return fullName;
	}

}