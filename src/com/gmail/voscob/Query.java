package com.gmail.voscob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Query {
	String str = null;
	public Query(String str) throws IOException, InterruptedException {
		String[] urlBing = new String[4];
		ResultQuery_Bing resQ_Bing = null;
		Content cont = null;
		this.str = str;
		String queryKey = str.replace(' ', '+');
		
		for (int i = 0; i < 4; i++) {
			urlBing[i] = "http://www.bing.com/search?q="+queryKey+"&first="+i+"1";
		}
		
		resQ_Bing = new ResultQuery_Bing(urlBing);
		
		List<String> listLinks_Bing = resQ_Bing.getLinksList();
		List<String> listNames_Bing = resQ_Bing.getNamesList();
		List<String> listDescriptions_Bing = resQ_Bing.getDescriptionsList();
		
		cont = new Content(listLinks_Bing, str);
		List<String> listContent_Bing = cont.getContentList();
		System.out.println("finish");
		
		List<Site> listSites = new ArrayList<>();
		Site site = null;
		for (int i = 0; i < listLinks_Bing.size(); i++) {
			site = new Site(listLinks_Bing.get(i), listNames_Bing.get(i), listDescriptions_Bing.get(i), listContent_Bing.get(i));
			listSites.add(site);
		}
		
		new XMLEnc(listSites, str);
	}
}