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
public class ProductPage extends AbstractPage {

    private final String XPATH_sizeBtn = "(.//div[@class='cardSize']//*[contains(@type,'radio') and not(@disabled)])[1]";
    private final String XPATH_addToCardBtn = "(.//button[@type='submit'])[2]";
    private final String XPATH_cardFavIsActiveBtn = ".//div[@class='cardFav is-active']";
    private final String XPATH_cardFavBtn = ".//div[@class='cardFav']";

    @FindBy(xpath = XPATH_sizeBtn)
    private WebElement sizeBtn;

    @FindBy(xpath = XPATH_addToCardBtn)
    private WebElement addToCardBtn;

    @FindBy(xpath = XPATH_cardFavIsActiveBtn)
    private WebElement cardFavIsActiveBtn;

    @FindBy(xpath = XPATH_cardFavBtn)
    private WebElement cardFavBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickSizeBtn() {
        this.sizeBtn.click();
    }

    public void clickAddToCardBtn() {
        this.addToCardBtn.click();
    }

    public void clickCardFavBtn() {
        this.cardFavBtn.click();
    }

    public void clickCardFavIsActiveBtn() {
        this.cardFavIsActiveBtn.click();
    }

    public By cardFavIsActiveBtnPath() {
        return By.xpath(XPATH_cardFavIsActiveBtn);
    }

    public boolean isDisplayedCardFavIsActiveBtn() {
        return isDisplayed(cardFavIsActiveBtnPath());
    }
}
