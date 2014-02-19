package com.gmail.voscob;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetContentJsoup implements Runnable{
	private Thread t;
	private String url;
	private String query;
	private int index;

	public GetContentJsoup (String url, int index, String query) {
		t = new Thread(this, "th_" + index);
		this.url = url;
		this.query = query;
		this.index = index;
	}

	@Override
	public void run() {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
//			e.printStackTrace();
		}
		Elements links = doc.getElementsByTag("p");
		int length;
		String str;
		String strOut = "";
		for (Element element : links) {
			str = element.text().trim();
			length = str.length();
			if (length > 100) {
				while (str.charAt(length - 1) == '\u00a0') {	//Удаляем неразрывный пробел
					length--;
				}
				str = str.substring(0, length);					//Переписываем строку без неразрывных пробелов
				str = str.trim();								//удаляем пробелы в начале и в конце строки

				if (str.charAt(str.length()-1) == '.' || str.charAt(str.length()-1) == '"') { //Сохраняем строки содержащие на конце точку или ковычку
					strOut += str;
				}
			}
		}
		if (strOut.length() > 1500) {
			Content.ar[index] = strOut;
			System.out.println(query + ": " + t + "   =   : " + strOut);
		}
		else {
			Content.ar[index] = "null";
//			System.out.println(query + ": " + t + "   =   : null!");
		}
	}
}