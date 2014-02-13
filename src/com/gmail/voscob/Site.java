package com.gmail.voscob;

public class Site {
	private String link;
	private String name;
	private String description;
	private String content;

	public Site(String link, String name, String description, String content) {
		this.link = link;
		this.name = name;
		this.description = description;
		this.content = content;
	}
	
	public Object getColumnIndex(int c) {
		switch (c) {
		case 0:
			return link;
		case 1:
			return name;
		case 2:
			return description;
		case 3:
			return content;
		}
		return null;
		
	}

	public Site() {}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}