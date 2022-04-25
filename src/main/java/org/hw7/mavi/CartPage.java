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
public class CartPage extends AbstractPage {

    private final String XPATH_basketList = ".//div[@class='basketList']";

    @FindBy(xpath = XPATH_basketList)
    private WebElement basketList;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public By basketListPath() {
        return By.xpath(XPATH_basketList);
    }

    public boolean isDisplayedBasketList() {
        return isDisplayed(basketListPath());
    }
}
