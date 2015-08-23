package com.rest.adressbook.utils;

public class AddressbookUtils {
	static int id = 1234;
	public static String getUniqueId() {
		return (Integer.toString(id++));
	}
}
