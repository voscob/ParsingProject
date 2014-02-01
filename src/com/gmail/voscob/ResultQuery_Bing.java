package com.gmail.voscob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ResultQuery_Bing {
	private List<String> linksList = null;
	private List<String> namesList = null;
	private List<String> descriptionsList = null;
	
	public ResultQuery_Bing(String[] url) throws IOException {
		Document doc = null;
		Elements links = null;
		Element names = null;
		Element descriptions = null;
		linksList = new ArrayList<>();
		namesList = new ArrayList<>();
		descriptionsList = new ArrayList<>();
		
		for (int i = 0; i < url.length; i++) {
			//Заполняем лист ссылок
			doc = Jsoup.connect(url[i]).get();
			for (int j = 0; j < 10; j++) {
				links = doc.select("div.sa_cc").get(j).getElementsByTag("a");
				linksList.add(links.attr("href"));
			}
			//Заполняем лист названий сайтов
			for (int j = 0; j < 10; j++) {
				names = doc.select("div.sb_tlst").get(j);
				namesList.add(names.text());
			}
			//Заполняем описание сайтов
			for (int j = 0; j < 10; j++) {
				descriptions = doc.select("div.sb_tlst").get(j).nextElementSibling().nextElementSibling();
				descriptionsList.add(descriptions.text());
			}
		}
	}

	public List<String> getLinksList() {
		return linksList;
	}
	
	public List<String> getNamesList() {
		return namesList;
	}
	
	public List<String> getDescriptionsList() {
		return descriptionsList;
	}
}