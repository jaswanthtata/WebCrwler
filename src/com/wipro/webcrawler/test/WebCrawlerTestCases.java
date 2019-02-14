package com.wipro.webcrawler.test;

import static org.junit.Assert.assertTrue;

import org.jsoup.nodes.Document;
import org.junit.Test;

import com.wipro.webcrawler.WebCrawler;

public class WebCrawlerTestCases {
	
	@Test
	public void webCrawlerTest() {
		Document doc = WebCrawler.parseDocumet("www.wiprodigital.com");
		assertTrue(" DocumentParser failed to retrieve html Document fromm the url ", doc != null );
	}
	
}
