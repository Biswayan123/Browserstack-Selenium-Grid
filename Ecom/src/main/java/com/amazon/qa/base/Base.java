package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.qa.util.Util;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;

	public Base(){
		try {
			prop = new Properties();
			//path to config.properties
			FileInputStream ip = new FileInputStream("C:\\Users\\bchattopadhy\\eclipse-workspace\\Ecom\\src\\main\\java\\com\\amazon\\qa\\config\\configuration.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bchattopadhy\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		if (browserName.equals("firefox")) {
		    System.setProperty("webdriver.gecko.driver", "C:\\Users\\bchattopadhy\\eclipse-workspace\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
	}

}

