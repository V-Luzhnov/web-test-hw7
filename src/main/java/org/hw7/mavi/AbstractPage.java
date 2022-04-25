package org.hw7.mavi;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Web UI Java. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 25.04.2022
 */
public abstract class AbstractPage {

    private final WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    protected boolean isDisplayed(By by) {
        try {
            return getDriver().findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
