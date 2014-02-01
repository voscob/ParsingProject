package com.gmail.voscob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NameAndDescription_Bing {
	public NameAndDescription_Bing(String url) {
		URL urlOpen = null;
		BufferedReader in = null;
		try {
			urlOpen = new URL(url);
			in = new BufferedReader(new InputStreamReader(urlOpen.openStream()));
			System.out.println(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
