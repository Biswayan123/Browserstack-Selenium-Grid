package com.amazon.qa.scenario;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.Base;

public class HomePage extends Base {
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	
	public HomePage() {
		PageFactory.initElements(driver, this);	
	}
	
	public ResultsPage searchForProduct(String productName) {
		searchBar.sendKeys(productName);
		searchBar.submit();
        
        return new ResultsPage();
    }

}
