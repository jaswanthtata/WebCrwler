package com.wipro.webcrawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {

	private final static String url = "http://www.wipro.com";
	
	public static void main(String[] args) {
		//This method expects a URL in a String format and call parseDocument and parseHtml methods
		Document document = parseDocumet(url);
		if(document != null) {
			parseHtml(document);
		} else {
			System.out.println("document is null");
		}

	}
	
	/**
	 * This method expects the url as a parameter, parse and return the document 
	 * @param url
	 * @return doc
	 */
	public static Document parseDocumet(String url){
		System.out.println("Crawling  through the url -> "+ url);
		Document document = null;
		//Fetching html Documment from thee url
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
	
	/**
	 * This method expects document as a parameter and parse it and call the print method to print the links 
	 * @param document
	 */
	public static void parseHtml(Document document) {
		//Fetching various tags data 
		Elements links = document.select("a[href]");
		Elements media = document.select("[src]");
		Elements imports = document.select("link[href]");

		//printing the fetched data
		print("Images and other static content ","abs:src",media);
		print("Imports  ","abs:href",imports);
		print("Links  ","abs:href",links);
	}
	
	/**
	 * This method will print the message and loop through the elements and print the links 
	 * @param message
	 * @param attrMsg
	 * @param element
	 */
	public static void print(String message,String attrMsg,Elements element) {
		System.out.println("\n"+message+" : "+ element.size());
		for (Element link : element) {
			System.out.println(link.tagName()+" : "+link.attr(attrMsg));
		}
	}

}
