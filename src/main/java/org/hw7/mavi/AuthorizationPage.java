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
public class AuthorizationPage extends AbstractPage {

    private final String XPATH_login = ".//input[@name='USER_LOGIN']";
    private final String XPATH_password = ".//input[@name='USER_PASSWORD']";
    private final String XPATH_loginBtn = ".//button[@class='popup-login__btn-login']";

    @FindBy(xpath = XPATH_login)
    private WebElement login;

    @FindBy(xpath = XPATH_password)
    private WebElement password;

    @FindBy(xpath = XPATH_loginBtn)
    private WebElement loginBtn;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public void clearLogin() {
        this.login.clear();
    }

    public void clearPassword() {
        this.password.clear();
    }

    public void loginIn(StringBuilder login, StringBuilder password) {
        clearLogin();
        clearPassword();
        Actions loginIn = new Actions(getDriver());
        loginIn
                .click(this.login)
                .sendKeys(login)
                .click(this.password)
                .sendKeys(password)
                .click(this.loginBtn)
                .build()
                .perform();
    }
}
