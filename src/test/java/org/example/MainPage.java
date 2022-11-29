package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {     //Главная страница сайта
    private static final String URL = "https://www.labirint.ru/";
    private static final String COOKIE_POLICY_BUTTON = "//button[contains(@class,\"cookie-policy__button\")]";
    private static final String SEARCH_FIELD_CLASS = "//input[@id = \"search-field\"]";

    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToSite() {
        webDriver.get(URL);
    }

    public void acceptCookie() {
        webDriver.findElement(By.xpath(COOKIE_POLICY_BUTTON)).click();
    }

    public void searchBook(String searchParam) {
        WebElement searchField = webDriver.findElement(By.xpath(SEARCH_FIELD_CLASS));
        searchField.sendKeys(searchParam);
        searchField.submit();
    }
}
