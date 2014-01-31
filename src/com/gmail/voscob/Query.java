package com.gmail.voscob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Query {
	public Query(String str) throws IOException {
		Links_Bing l_B = new Links_Bing();
		String queryKey = str.replace(' ', '+');
		List<String> bingURL = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			List<String> tempArray =
					l_B.getLinks("http://www.bing.com/search?q="+queryKey+"&first="+i+"1");
			for (int j = 0; j < tempArray.size(); j++) {
				bingURL.add(tempArray.get(j));
			}
		}
		
		Iterator<String> itr = bingURL.iterator();
		while (itr.hasNext()) {
//			System.out.println(itr.next().toString());
			
		}
	}
}