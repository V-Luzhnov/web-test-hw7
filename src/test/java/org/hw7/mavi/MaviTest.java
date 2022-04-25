package org.hw7.mavi;

import org.junit.jupiter.api.*;

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
    public void authorizationTestPositive() {

        new HeaderSide(getDriver()).clickHeaderAccBtn();

        //Если авторизован, то выйти и снова открыть страницу автоизации
        logout();

        Assertions.assertTrue(getDriver().getTitle().contains("Авторизация"), "Страница входа недоступна");

        new AuthorizationPage(getDriver()).loginIn(getL(), getP());

        Assertions.assertEquals("Личные данные",
                getDriver().findElement(new AccountMenu(getDriver()).prTitlePath()).getText());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Успешный поиск товара")
    public void searchTestPositive() throws IOException {

        new HeaderSide(getDriver()).performSearch(getSearchObject());

        Assertions.assertEquals("Результаты поиска: " + getSearchObject(),
                getDriver().findElement(new SearchPage(getDriver()).catalogSearchPath()).getText());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Успешное добавление товара в корзину")
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
    }

    @Test
    @Tag("Positive")
    @DisplayName("Успешное добавление товара в избранное")
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
    }

    @Test
    @Tag("Positive")
    @DisplayName("Успешный переход на страницу Распродажа")
    public void saleTestPositive() {

        new HeaderSide(getDriver()).clickOutletBtn();

        Assertions.assertEquals("Распродажа",
                getDriver().findElement(new SalePage(getDriver()).pageTitlePath()).getText());
    }

    @Test
    @Tag("Positive")
    @DisplayName("Проверка открытия страниц раздела Покупатели в подвале")
    public void footerBuyersTestPositive() {

        new FooterSide(getDriver()).clickPaymentShippingBtn();
        Assertions.assertEquals("Оплата",
                getDriver().findElement(new CommonPages(getDriver()).pageTitlePath()).getText());

        new FooterSide(getDriver()).clickExchangeReturnBtn();
        Assertions.assertEquals("Возврат товара",
                getDriver().findElement(new CommonPages(getDriver()).pageTitlePath()).getText());

        new FooterSide(getDriver()).clickSizeTableBtn();
        Assertions.assertEquals("Таблица размеров",
                getDriver().findElement(new CommonPages(getDriver()).pageTitlePath()).getText());

        new FooterSide(getDriver()).clickPrivacyBtn();
        Assertions.assertEquals("Положение о порядке продаж товаров дистанционным способом в интернет-магазине MAVI",
                getDriver().findElement(new CommonPages(getDriver()).pageTitlePath()).getText());

        new FooterSide(getDriver()).clickFittingBtn();
        Assertions.assertEquals("Примерка",
                getDriver().findElement(new CommonPages(getDriver()).pageTitlePath()).getText());
    }
}
