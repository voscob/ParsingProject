package com.gmail.voscob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Links_Bing {
	public Links_Bing(){}
	public List<String> getLinks(String url) throws IOException {
		String inputLine;
		int[] start = new int[10];
		int[] finish = new int[10];
		List<String> links = new LinkedList<>();

		URL urlOpen = new URL(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(urlOpen.openStream()));
		Pattern pt = Pattern.compile("<h3><a href=");
		while ((inputLine = in.readLine()) != null) {
			Matcher mt = pt.matcher(inputLine);
			int end = 0;
			for (int i = 0; i < 10; i++) {
				if (mt.find(end)) {
					end = mt.end();
					start[i] = end + 1;
					if (inputLine.indexOf("\" ", start[i]) != -1) {
						finish[i] = inputLine.indexOf("\" ", start[i]);
						links.add(inputLine.substring(start[i], finish[i]));
					}
				}
			}
		}
		return links;
	}
}