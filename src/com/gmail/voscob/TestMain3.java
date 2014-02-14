package com.gmail.voscob;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain3 {

	public static void main(String[] args) throws ConnectException, MalformedURLException, IOException, InterruptedException {
		
		
//		ExecutorService service = Executors.newCachedThreadPool();
//		for(int i = 0; i < 3; i++) {
//			service.submit(new Test3ThreadStop());
//		}
//		Thread.sleep(2000);
//		service.shutdownNow();
		List<Thread> threads = new ArrayList<Thread>();
		List<Test3ThreadStop> objects = new ArrayList<Test3ThreadStop>();
		
		for (int i = 0; i < 3; i++) {
			objects.add(new Test3ThreadStop());
		}
		
		for (int i = 0; i < 3; i++) {
		    threads.add(new Thread((Runnable) objects.get(i)));
		}

		for (Thread thread: threads) {
		    thread.start();
		}
		
		Thread.sleep(2000);
		objects.get(1).stop();
		System.out.println("stop");
		Thread.sleep(6000);
		objects.get(1).myresume();
		System.out.println("myresume");
		
		for (Thread thread: threads) {
		    thread.join();
		}
		
//		for (int i = 0; i < 10; i++) {
//			Thread ttt = new Thread(new Test3ThreadStop());	
//			System.out.println("из мейна до запуска");
//			ttt.start();
//			
//			
////			new GetContent("http://www.returnairgrilles.com/", 0, "test");
//		}
		
		System.out.println("продолжение");
	}
}