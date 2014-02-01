package com.gmail.voscob;

import java.io.IOException;
import java.util.List;

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
		System.out.println(listLinks_Bing.size());
		System.out.println(listNames_Bing.size());
		System.out.println(listDescriptions_Bing.size());
		
		for (int i = 0; i < listLinks_Bing.size(); i++) {
			System.out.println("Site #" + i + ":");
			System.out.println(listLinks_Bing.get(i));
			System.out.println(listNames_Bing.get(i));
			System.out.println(listDescriptions_Bing.get(i));
			System.out.println();
		}
	}
}