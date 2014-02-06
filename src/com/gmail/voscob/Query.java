package com.gmail.voscob;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.wuman.jreadability.Readability;

public class Query {
	public Query(String str) throws IOException {
		String[] urlBing = new String[4];
		ResultQuery_Bing resQ_Bing = null;
		String queryKey = str.replace(' ', '+');
		
		for (int i = 0; i < 4; i++) {
			urlBing[i] = "http://www.bing.com/search?q="+queryKey+"&first="+i+"1";
		}
		
		resQ_Bing = new ResultQuery_Bing(urlBing);
		
		List<String> listLinks_Bing = resQ_Bing.getLinksList();
		List<String> listNames_Bing = resQ_Bing.getNamesList();
		List<String> listDescriptions_Bing = resQ_Bing.getDescriptionsList();
		
//		for (int i = 0; i < listLinks_Bing.size(); i++) {
			new Content_Bing(listLinks_Bing.get(0));
//			URL url = new URL("http://habrahabr.ru/company/mailru/blog/200394/");
//			Readability r = new Readability(url, 10000);
//			r.init();
//			
//			System.out.println(r.outerHtml());
//		}
		
//		for (int i = 0; i < listLinks_Bing.size(); i++) {
//			System.out.println("Site #" + i + ":");
//			System.out.println(listLinks_Bing.get(i));
//			System.out.println(listNames_Bing.get(i));
//			System.out.println(listDescriptions_Bing.get(i));
//			System.out.println();
//		}
	}
}