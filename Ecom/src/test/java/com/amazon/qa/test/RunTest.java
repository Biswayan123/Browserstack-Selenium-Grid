package com.amazon.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.Base;
import com.amazon.qa.scenario.HomePage;
import com.amazon.qa.scenario.ResultsPage;

public class RunTest extends Base {
	
	HomePage homePage;
	ResultsPage resultsPage;
	
	public RunTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void testcase() throws Exception {
		
		resultsPage = homePage.searchForProduct("iPhone 15");
		resultsPage.selectOperationSystemAndFilter();
		resultsPage.displayResult();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
