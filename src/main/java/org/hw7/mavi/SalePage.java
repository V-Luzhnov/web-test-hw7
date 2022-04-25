package org.hw7.mavi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Web UI Java. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 25.04.2022
 */
public class SalePage extends AbstractPage {

    private final String XPATH_pageTitle = ".//h1[@class='pageTitle']";

    @FindBy(xpath = XPATH_pageTitle)
    private WebElement pageTitle;

    public SalePage(WebDriver driver) {
        super(driver);
    }

    public By pageTitlePath() {
        return By.xpath(XPATH_pageTitle);
    }
}
