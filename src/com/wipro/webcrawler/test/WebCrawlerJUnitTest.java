package com.wipro.webcrawler.test;

import static org.junit.Assert.*;

import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wipro.webcrawler.WebCrawler;

public class WebCrawlerJUnitTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void javaCrawlerDocParser() {
		Document doc = WebCrawler.parseDocumet("http://www.wipro.com"); 
		assertTrue(" DocumentParser failed to retrieve html Document fromm the url ", doc != null );
	}
	
}
