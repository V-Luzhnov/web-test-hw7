package org.hw7.mavi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Web UI Java. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 25.04.2022
 */
public class HeaderSide extends AbstractPage {

    private final String ID_headerSearchInput = "header-search-input";
    private final String XPATH_searchBtn = "(.//button[@type='submit'])[1]";
    private final String XPATH_headerAccBtn = ".//span[@class='headerAccBtn']";
    private final String XPATH_basketBtn = ".//span[@class='headerBasketBtn']";
    private final String XPATH_orderBtn = ".//a[@class='basketCompactOrder']";
    private final String XPATH_favBtn = ".//span[@class='headerFavBtn']";
    private final String XPATH_outletBtn = ".//a[@class='navElLink navElLink_outlet']";

    @FindBy(id = ID_headerSearchInput)
    private WebElement headerSearchInput;

    @FindBy(xpath = XPATH_searchBtn)
    private WebElement searchBtn;

    @FindBy(xpath = XPATH_headerAccBtn)
    private WebElement headerAccBtn;

    @FindBy(xpath = XPATH_basketBtn)
    private WebElement basketBtn;

    @FindBy(xpath = XPATH_orderBtn)
    private WebElement orderBtn;

    @FindBy(xpath = XPATH_favBtn)
    private WebElement favBtn;

    @FindBy(xpath = XPATH_outletBtn)
    private WebElement outletBtn;

    public HeaderSide(WebDriver driver) {
        super(driver);
    }

    public void clearHeaderSearchInput() {
        this.headerSearchInput.click();
    }

    public void clickHeaderAccBtn() {
        this.headerAccBtn.click();
    }

    public void clickBasketBtn() {
        this.basketBtn.click();
    }

    public void clickOrderBtn() {
        this.orderBtn.click();
    }

    public void clickFavBtn() {
        this.favBtn.click();
    }

    public void clickOutletBtn() {
        this.outletBtn.click();
    }

    public void performSearch(String searchText) {
        clearHeaderSearchInput();
        Actions search = new Actions(getDriver());
        search
                .click(this.headerSearchInput)
                .sendKeys(this.headerSearchInput, searchText)
                .click(this.searchBtn)
                .build()
                .perform();
    }
}
