package com.gmail.voscob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;

public class GetContent implements Runnable {
	private Thread t;
	private String url;
	private int index;

	public GetContent(String url, int index) {
		t = new Thread(this, "th_" + index);
		this.url = url;
		this.index = index;
//		System.out.println(url);
		t.start();
	}

	@Override
	public void run() {
		System.out.println("start: " + t);
		URL website;

		BufferedReader in = null;
		try {
			website = new URL(url);
			URLConnection connection = website.openConnection();
			in = new BufferedReader(
					new InputStreamReader(
							connection.getInputStream()));
		} catch (MalformedURLException e) {
//			e.printStackTrace();
		} catch (IOException e) {
//			e.printStackTrace();
		}

		String inputLine;
		String textBody = "";
		String outoutLine = "";
		int newAdd = 0;
		Pattern pt = null;
		Matcher mt = null;
		int i = 1;
		int bodyStart = 0;
		int bodyFinish = 0;

		try {
			if (in == null) {
				Content.ar[index] = "null";
				System.out.println(t + "   =   : return!");
				return;
			}
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
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		for (int j = 0; j < lInt.size()-1; j++) {
			doc = Jsoup.parse(textBody.substring(lInt.get(j), lInt.get(j+1))).text();
			if (doc.length() > 100 && Character.isLowerCase(doc.charAt(0)) == false &&(doc.charAt(doc.length()-1) == '.' || doc.charAt(doc.length()-1) == '!')) {
				outoutLine = outoutLine + " " + doc;
			}
		}
		if (outoutLine.length() > 1500) {
			Content.ar[index] = outoutLine;
			System.out.println(t + "   =   : " + outoutLine);
		}
		else {
			Content.ar[index] = "null";
			System.out.println(t + "   =   : null!");
		}
	}
}
