package org.hw7.mavi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

/**
 * Web UI Java. Homework 7
 *
 * @author Vitalii Luzhnov
 * @version 25.04.2022
 */
public abstract class AbstractTest {

    final static java.util.Properties prop = new java.util.Properties();

    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to(getURL()), "Страница недоступна");

        // закрыть сообщение о куках, если оно есть, нажатием ОК
        closeCookiesMessage();
    }

    @AfterAll
    static void close(){
        if(driver !=null) driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void logout() {
        if (new AccountMenu(getDriver()).isDisplayedLogoutBtn()) {
            new AccountMenu(getDriver()).clickLogoutBtn();
            new HeaderSide(getDriver()).clickHeaderAccBtn();
        }
    }

    public void closeCookiesMessage() {
        if (new CommonPages(getDriver()).isDisplayedCookiesInformBtn()) {
            new CommonPages(getDriver()).clickCookiesInformBtn();
        }
    }

    public void removeProductFromFavorites() {
        if (new ProductPage(getDriver()).isDisplayedCardFavIsActiveBtn()) {
            new ProductPage(getDriver()).clickCardFavIsActiveBtn();
        }
    }

    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/test/resources/propertiesForTest.properties")){
            prop.load(configFile);
        }
    }

    public static String getURL() throws IOException {
        loadProperties();
        return prop.getProperty("PATH_URL");
    }

    public static String getURLbryuki() throws IOException {
        loadProperties();
        return prop.getProperty("PATH_URL_BRYUKI");
    }

    public static String getURLfutbolki() throws IOException {
        loadProperties();
        return prop.getProperty("PATH_URL_FUTBOLKI");
    }

    public static String getSearchObject() throws IOException {
        loadProperties();
        return prop.getProperty("SEARCH_OBJECT");
    }

    public static StringBuilder getL() { return readFile("l"); }

    public static StringBuilder getP() { return readFile("p"); }

    private static StringBuilder readFile(String n) {
        StringBuilder rez = new StringBuilder();
        try(FileReader reader = new FileReader("src/test/resources/test_" + n + ".txt"))
        {
            int c;
            while((c=reader.read())!=-1) {
                rez.append((char) c);
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        return rez;
    }
}
