package com.gmail.voscob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;

public class TestMain2 {

	public static void main(String[] args) throws NullPointerException, IOException {
//		URL website = new URL("http://www.returnairgrilles.com/");
		URL website = new URL("http://www.gsmpress.com.ua/rus/mobile-phones-Motorola-Moto-G-Dual-SIM.html");
		
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        String inputLine;
        String textBody = "";
        int newAdd = 0;
        Pattern pt = null;
		Matcher mt = null;
		int i = 1;
		int bodyStart = 0;
		int bodyFinish = 0;

        while ((inputLine = in.readLine()) != null) {
        	pt = Pattern.compile("<body");
			mt = pt.matcher(inputLine);
			while(mt.find()) {
				bodyStart = i;			
			}
			
			if (bodyStart != 0 && bodyFinish == 0) {
				textBody += inputLine;
			}
			
			pt = Pattern.compile("id=\"comm");
			mt = pt.matcher(inputLine);
			while(mt.find()) {
				bodyFinish = i;
			}
			
			pt = Pattern.compile("</body>");
			mt = pt.matcher(inputLine);
			while(mt.find()) {
				bodyFinish = i;
			}
			
			i++;
		}
        System.out.println("strat lint: " + bodyStart);
        System.out.println("strat lint: " + bodyFinish);
        System.out.println(textBody.length());
        
        List<Integer> lInt = new ArrayList<>();
        
        pt = Pattern.compile("</p>");
		mt = pt.matcher(textBody);
		while(mt.find()) {
			lInt.add(newAdd);
			newAdd = mt.end();
		}
		if (lInt.size() > 0) {
			lInt.remove(0);
		}
        
		newAdd = 0;
		pt = Pattern.compile("<br>");
		mt = pt.matcher(textBody);
		while(mt.find()) {
			lInt.add(newAdd);
			newAdd = mt.end();
		}
		
		pt = Pattern.compile("</li>");
		mt = pt.matcher(textBody);
		while(mt.find()) {
			
			newAdd = mt.end();
			lInt.add(newAdd);
		}

		Collections.sort(lInt);
		
		String doc = null;
		String outoutLine = "";
		for (int j = 0; j < lInt.size()-1; j++) {
			doc = Jsoup.parse(textBody.substring(lInt.get(j), lInt.get(j+1))).text();
			if (doc.length() > 50 && Character.isLowerCase(doc.charAt(0)) == false &&(doc.charAt(doc.length()-1) == '.' || doc.charAt(doc.length()-1) == '!')) {
				outoutLine = outoutLine + doc + " ";
			}
		}
		if (outoutLine.length() > 1500) {
			System.out.println(outoutLine);
		}
        
        in.close();
	}
}
