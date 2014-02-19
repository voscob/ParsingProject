package com.gmail.voscob;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

public class TestMain3 {

	public static void main(String[] args) throws ConnectException, MalformedURLException, IOException, InterruptedException {
		
		
//		List<Thread> threads = new ArrayList<Thread>();
//		List<Test3ThreadStop> objects = new ArrayList<Test3ThreadStop>();
//		
//		for (int i = 0; i < 3; i++) {
//			objects.add(new Test3ThreadStop());
//		}
//		
//		for (int i = 0; i < 3; i++) {
//		    threads.add(new Thread((Runnable) objects.get(i)));
//		}
//
//		for (Thread thread: threads) {
//		    thread.start();
//		}
//		
//		Thread.sleep(2000);
//		objects.get(1).stop();
//		System.out.println("stop");
//		Thread.sleep(6000);
		
//		for (Thread thread: threads) {
//		    thread.join();
//		}
		
//		System.out.println("окончание main");
		
		
		
		String str = "The goal of Candy Crush Saga is to match three or more candies in a row to make them disappear. ";
		if (str.charAt(str.length()-1) == '\u00a0') {
			System.out.println("if");
		}
		
//		System.out.println(str);
//		System.out.println(str.length());
//		System.out.println(str.trim());
//		System.out.println(str.trim().length());
//		String str2 = "The goal of Candy Crush Saga is to match three or more candies in a row to make them disappear. ";
//		System.out.println(str2);
//		System.out.println(str2.length());
//		System.out.println(str2.trim());
//		System.out.println(str2.trim().length());
		
		
		
//		char ch = str.charAt(7);
//		
//		if (ch == ' ') {
//			System.out.println("if");
//		}
		
		
		
		
		
	}
}