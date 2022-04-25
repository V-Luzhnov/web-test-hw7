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
public class AccountMenu extends AbstractPage {

    private final String XPATH_logoutBtn = ".//a[@href='/?logout=yes']";
    private final String XPATH_prTitle = ".//div[@class='prTitle']";

    @FindBy(xpath = XPATH_logoutBtn)
    private WebElement logoutBtn;

    @FindBy(xpath = XPATH_prTitle)
    private WebElement prTitle;

    public AccountMenu(WebDriver driver) {
        super(driver);
    }

    public By logoutBtnPath() {
        return By.xpath(XPATH_logoutBtn);
    }

    public By prTitlePath() {
        return By.xpath(XPATH_prTitle);
    }

    public boolean isDisplayedLogoutBtn() {
        return isDisplayed(logoutBtnPath());
    }

    public void clickLogoutBtn() {
        this.logoutBtn.click();
    }
}
