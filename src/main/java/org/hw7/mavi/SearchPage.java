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
public class SearchPage extends AbstractPage {

    private final String XPATH_catalogSearch = "(.//div[@class='catalogCounter'])[2]";

    @FindBy(xpath = XPATH_catalogSearch)
    private WebElement catalogSearch;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public By catalogSearchPath() {
        return By.xpath(XPATH_catalogSearch);
    }
}
