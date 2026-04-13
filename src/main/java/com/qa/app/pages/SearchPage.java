package com.qa.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qa.app.constants.AppConstants.*;
import com.qa.app.utils.ElementUtil;

public class SearchPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private final By resultsProduct = By.cssSelector("div.product-thumb");
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public int getResultsProductCount() {
		int searchCount = 
				eleUtil.waitForAllElementsVisible(resultsProduct, MEDIUM_DEFAULT_TIMEOUT).size();
		System.out.println("total number of search products: "+searchCount);
		return searchCount;
	}

	
}
