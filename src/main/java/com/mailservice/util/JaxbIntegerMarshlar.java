package com.mailservice.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JaxbIntegerMarshlar extends XmlAdapter<String, Integer> {

	@Override
	public String marshal(Integer value) throws Exception {
		if (value == null) {
			return "";
		}

		return value.toString();
	}

	@Override
	public Integer unmarshal(String storedValue) throws Exception {
		if (storedValue.equalsIgnoreCase("null") || storedValue.equalsIgnoreCase("")) {
			return null;
		}
		return Integer.valueOf(storedValue);
	}

}