package com.amazon.qa.scenario;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.Base;
import com.amazon.qa.util.Util;

public class ResultsPage extends Base {
	JavascriptExecutor jse;
	@FindBy(xpath="//span[text()='64 GB']//preceding-sibling::div//i")
	WebElement OpSys;
	
	@FindBy(xpath="//span[text()='Sort by:']")
	WebElement sortByDropdown;
	
	@FindBy(xpath="//span[text()='Memory Storage Capacity']")
	WebElement cposLabel;
	
	@FindBy(xpath="//a[text()='Price: High to Low']")
	WebElement highToLowFilter;

	public ResultsPage() {
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectOperationSystemAndFilter() {
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cposLabel);
		OpSys.click();
		sortByDropdown.click();
		highToLowFilter.click();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIMEOUT));
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void displayResult() throws Exception {
		List<WebElement> links = driver.findElements(By.xpath("//h2/a"));

		for (int i = 0; i < links.size(); i++) {
			int j = i + 1;
			boolean val = isElementPresent(By.xpath("//div[" + j + "]/div[1]/div[1]/span[1]/div[1]/div[1]/div[2]//div[1]/div[1]/a[1]/span[1]/span[2]/span[2]"));
			System.out.println("Product name is : " + j + " " + links.get(i).getText());
			System.out.println("Link for product is : " + links.get(i).getAttribute("href"));
			if (val) {
				WebElement ele = driver.findElement(By.xpath("//div[" + j + "]/div[1]/div[1]/span[1]/div[1]/div[1]/div[2]//div[1]/div[1]/a[1]/span[1]/span[2]/span[2]"));
				System.out.println("Price of the product is : " + ele.getAttribute("innerText"));
				System.out.println();
			} else {
				System.out.println("Price of the product is not displayed");
				System.out.println();
			}
		}
	}

}
