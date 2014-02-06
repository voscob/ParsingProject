package com.gmail.voscob;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Content_Bing {
	public Content_Bing(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
//		Element content = doc.getElementById("content");
//		System.out.println(content.text());
		Element bodies = doc.body();
		System.out.println(bodies.html());
//	    for(Element body : bodies )
//	    {
//	    	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
//	        System.out.println(body.getAllElements().text());
//	    }
	}
}
