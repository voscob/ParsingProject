package com.gmail.voscob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestMain2 {

	public static void main(String[] args) throws NullPointerException, IOException {
		
//		Document doc = Jsoup.connect("http://www.returnairgrilles.com/").get();		
//		Element getHtmlBody = doc;
//		System.out.println(getHtmlBody.html());
//		List<String> listP = new ArrayList<>();
//		String addNow = "";
		//
		
		URL website = new URL("http://www.returnairgrilles.com/");
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        String inputLine;
        Pattern pt = null;
		Matcher mt = null;
		int i = 1;

        while ((inputLine = in.readLine()) != null) {
//        	System.out.println(inputLine);
        	pt = Pattern.compile("<body");
			mt = pt.matcher(inputLine);
			while(mt.find()) {
				System.out.println(mt.end());
				System.out.println(i);
			}
			i++;
		
		
		
		
//		int end = 0;
//		mt.matches();
//			while(mt.find()) {
//				System.out.println(mt.end());
//				System.out.println(i);
//			addNow = getHtmlBody.substring(end, mt.end());
//			listP.add(addNow);
//			end = mt.end();
				
//			}
		}
        in.close();
        
//		System.out.println(listP.size());
		
		
		
		
		

	}
}
