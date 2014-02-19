package com.gmail.voscob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Content {
	private List<String> contentList = null;
	static String[] ar = new String[40];
	
	public Content(List<String> url, String query) throws IOException, InterruptedException {
		List<Thread> threads = new ArrayList<Thread>();

		for (int i = 0; i < url.size(); i++) {
		    threads.add(new Thread(new GetContentJsoup(url.get(i), i, query)));
		}

		for (Thread thread: threads) {
		    thread.start();
		}
		
		for (Thread thread: threads) {
		    thread.join();
		}
	}
	
	public List<String> getContentList() {
		return contentList;
	}
}