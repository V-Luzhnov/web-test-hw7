package org.mavi;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;

/**
 * Web UI Java. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 25.04.2022
 */
public class MaviTest extends AbstractTest {

    @Test
    @Tag("Positive")
    @DisplayName("Успешная авторизация")
    @Description("Данные для автоизации хранятся в тектовых файлах в resources")
    @Link("https://ru.mavi.com")
    @Severity(SeverityLevel.CRITICAL)
    public void authorizationTestPositive() {

        new HeaderSide(getDriver()).clickHeaderAccBtn();

        //Если авторизован, то выйти и снова открыть страницу автоизации
        logout();

        Assertions.assertTrue(getDriver().getTitle().contains("Авторизация"), "Страница входа недоступна");

        new AuthorizationPage(getDriver()).loginIn(getL(), getP());

        Assertions.assertEquals("Личные данные",
                getDriver().findElement(new AccountMenu(getDriver()).prTitlePath()).getText());

        MyUtils.makeScreenshot(getDriver(),"mavi-test-AuthorizationPage.png");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Успешный поиск товара")
    @Link("https://ru.mavi.com")
    @Severity(SeverityLevel.NORMAL)
    public void searchTestPositive() throws IOException {

        new HeaderSide(getDriver()).performSearch(getSearchObject());

        Assertions.assertEquals("Результаты поиска: " + getSearchObject(),
                getDriver().findElement(new SearchPage(getDriver()).catalogSearchPath()).getText());

        try {
            getDriver().findElement(By.xpath(".//*[text()='Результаты поиска: " + getSearchObject() + "']"));
        } catch (NoSuchElementException e){
            MyUtils.makeScreenshot(getDriver(),
                    "failure-mavi-test-SearchPage-" + System.currentTimeMillis() + ".png");
        }
    }

    @Test
    @Tag("Positive")
    @DisplayName("Успешное добавление товара в корзину")
    @Link("https://ru.mavi.com")
    @Severity(SeverityLevel.CRITICAL)
    public void addToCartTestPositive() throws InterruptedException, IOException {

        getDriver().navigate().to(getURL() + getURLbryuki());

        new ProductPage(getDriver()).clickSizeBtn();
        new ProductPage(getDriver()).clickAddToCardBtn();

        getDriver().navigate().to(getURL() + getURLfutbolki());

        new ProductPage(getDriver()).clickSizeBtn();
        new ProductPage(getDriver()).clickAddToCardBtn();

        Thread.sleep(5000);

        new HeaderSide(getDriver()).clickBasketBtn();
        new HeaderSide(getDriver()).clickOrderBtn();

        Assertions.assertTrue(new CartPage(getDriver()).isDisplayedBasketList());

        MyUtils.makeScreenshot(getDriver(),"mavi-test-CartPage.png");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Успешное добавление товара в избранное")
    @Link("https://ru.mavi.com")
    @Severity(SeverityLevel.NORMAL)
    public void addToFavoritesTestPositive() throws IOException, InterruptedException {

        getDriver().navigate().to(getURL() + getURLbryuki());

        // закрыть сообщение о куках, если оно есть, нажатием ОК
        closeCookiesMessage();

        //если товар в избранном, то убрать его из избраного
        removeProductFromFavorites();

        new ProductPage(getDriver()).clickCardFavBtn();

        getDriver().navigate().to(getURL() + getURLfutbolki());

        // закрыть сообщение о куках, если оно есть, нажатием ОК
        closeCookiesMessage();

        //если товар в избранном, то убрать его из избраного
        removeProductFromFavorites();

        new ProductPage(getDriver()).clickCardFavBtn();

        Thread.sleep(1000);

        new HeaderSide(getDriver()).clickFavBtn();

        Assertions.assertTrue(new FavoritesPage(getDriver()).isDisplayedCatalogList());

        MyUtils.makeScreenshot(getDriver(),"mavi-test-FavoritesPage.png");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Успешный переход на страницу Распродажа")
    @Link("https://ru.mavi.com")
    @Severity(SeverityLevel.MINOR)
    public void saleTestPositive() {

        new HeaderSide(getDriver()).clickOutletBtn();

        Assertions.assertEquals("Распродажа",
                getDriver().findElement(new SalePage(getDriver()).pageTitlePath()).getText());

        try {
            getDriver().findElement(new SalePage(getDriver()).pageTitlePath());
        } catch (NoSuchElementException e){
            MyUtils.makeScreenshot(getDriver(),
                    "failure-mavi-test-SalePage" + System.currentTimeMillis() + ".png");
        }
    }

    @Test
    @Tag("Positive")
    @DisplayName("Проверка открытия страниц раздела Покупатели в подвале")
    @Link("https://ru.mavi.com")
    @Severity(SeverityLevel.MINOR)
    public void footerBuyersTestPositive() {

        new FooterSide(getDriver()).clickPaymentShippingBtn();
        Assertions.assertEquals("Оплата",
                getDriver().findElement(new CommonPages(getDriver()).pageTitlePath()).getText());

        MyUtils.makeScreenshot(getDriver(),"mavi-test-PaymentShipping.png");

        new FooterSide(getDriver()).clickExchangeReturnBtn();
        Assertions.assertEquals("Возврат товара",
                getDriver().findElement(new CommonPages(getDriver()).pageTitlePath()).getText());

        MyUtils.makeScreenshot(getDriver(),"mavi-test-ExchangeReturn.png");

        new FooterSide(getDriver()).clickSizeTableBtn();
        Assertions.assertEquals("Таблица размеров",
                getDriver().findElement(new CommonPages(getDriver()).pageTitlePath()).getText());

        MyUtils.makeScreenshot(getDriver(),"mavi-test-SizeTable.png");

        new FooterSide(getDriver()).clickPrivacyBtn();
        Assertions.assertEquals("Положение о порядке продаж товаров дистанционным способом в интернет-магазине MAVI",
                getDriver().findElement(new CommonPages(getDriver()).pageTitlePath()).getText());

        MyUtils.makeScreenshot(getDriver(),"mavi-test-Privacy.png");

        new FooterSide(getDriver()).clickFittingBtn();
        Assertions.assertEquals("Примерка",
                getDriver().findElement(new CommonPages(getDriver()).pageTitlePath()).getText());

        MyUtils.makeScreenshot(getDriver(),"mavi-test-Fitting.png");
    }
}
