package com.gmail.voscob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Content {
	private List<String> contentList = null;
	static String[] ar = new String[40];
	
	public Content(List<String> url) throws IOException, InterruptedException {
		for (int i = 0; i < url.size(); i++) {
			new GetContent(url.get(i), i);
		}
		Thread.sleep(20000);
		contentList = new ArrayList<String>(Arrays.asList(ar));
	}
	
	public List<String> getContentList() {
		return contentList;
	}
}