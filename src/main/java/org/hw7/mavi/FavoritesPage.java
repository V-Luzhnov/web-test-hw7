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
public class FavoritesPage extends AbstractPage {

    private final String XPATH_catalogList = ".//div[@class='catalogList']";

    @FindBy(xpath = XPATH_catalogList)
    private WebElement catalogList;

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public By catalogListPath() {
        return By.xpath(XPATH_catalogList);
    }

    public boolean isDisplayedCatalogList() {
        return isDisplayed(catalogListPath());
    }
}
