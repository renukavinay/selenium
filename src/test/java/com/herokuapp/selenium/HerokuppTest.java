package com.herokuapp.selenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class HerokuppTest {

	private WebDriver driver;
	private String baseUrl;
	static Logger log = Logger.getLogger(HerokuppTest.class);

	@Test
	public void herokuappTest() {
		log.info("In test method");
		String pageTitle = "The Internet";
		Assert.assertEquals(pageTitle, driver.getTitle());
		WebElement welcomeText = null;
		try {
			welcomeText = driver.findElement(By.xpath("//*[@id='content']//h1[text()='Welcome to the Internet']"));
		} catch (NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}
		Assert.assertTrue(welcomeText != null);
	}

	@Test
	public void brokenImages() {
		log.info("In Broken Image method");
		
	}

	@BeforeMethod
	public void beforeMethod() {
		PropertyConfigurator.configure("log4j.properties");
		baseUrl = "http://the-internet.herokuapp.com/";
		driver = new FirefoxDriver();
		driver.get(baseUrl);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
