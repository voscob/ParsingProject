package com.gmail.voscob;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;

public class TestMain3 {

	public static void main(String[] args) throws ConnectException, MalformedURLException, IOException {
//		for (int i = 0; i < 10; i++) {
			new GetContent("http://www.returnairgrilles.com/", 0);
//		}
	}
}