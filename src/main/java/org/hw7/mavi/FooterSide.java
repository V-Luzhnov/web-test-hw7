package org.hw7.mavi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Web UI Java. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 25.04.2022
 */
public class FooterSide extends AbstractPage {

    private final String XPATH_paymentShippingBtn = ".//a[text() = 'Оплата и доставка']";
    private final String XPATH_exchangeReturnBtn = ".//a[text() = 'Обмен и возврат']";
    private final String XPATH_sizeTableBtn = ".//a[text() = 'Таблица размеров']";
    private final String XPATH_privacyBtn = ".//a[text() = 'Защита информации']";
    private final String XPATH_fittingBtn = ".//a[text() = 'Примерка']";

    @FindBy(xpath = XPATH_paymentShippingBtn)
    private WebElement paymentShippingBtn;

    @FindBy(xpath = XPATH_exchangeReturnBtn)
    private WebElement exchangeReturnBtn;

    @FindBy(xpath = XPATH_sizeTableBtn)
    private WebElement sizeTableBtn;

    @FindBy(xpath = XPATH_privacyBtn)
    private WebElement privacyBtn;

    @FindBy(xpath = XPATH_fittingBtn)
    private WebElement fittingBtn;

    public FooterSide(WebDriver driver) {
        super(driver);
    }

    public void clickPaymentShippingBtn() {
        this.paymentShippingBtn.click();
    }

    public void clickExchangeReturnBtn() {
        this.exchangeReturnBtn.click();
    }

    public void clickSizeTableBtn() {
        this.sizeTableBtn.click();
    }

    public void clickPrivacyBtn() {
        this.privacyBtn.click();
    }

    public void clickFittingBtn() {
        this.fittingBtn.click();
    }
}
