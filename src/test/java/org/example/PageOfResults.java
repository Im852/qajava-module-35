package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageOfResults {    //Страница сайта с результатами поиска
    private static final String WISHLIST_BUTTON = "//a[contains(@class,\"icon-fave\")]/span[@class = \"header-sprite\"]";
    public static final String TRANSITION_TO_WISHLIST = "//span[text() = \"Отложено\"]";
    public static final String ERROR_MESSAGE_XPATH = "//h1[text() = \"Мы ничего не нашли по вашему запросу! Что делать?\"]";

    private final WebDriver webDriver;

    public PageOfResults(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void addToWishlist() {
        webDriver.findElement(By.xpath(WISHLIST_BUTTON)).click();
    }

    public void goToWishlist() {
        webDriver.findElement(By.xpath(TRANSITION_TO_WISHLIST)).click();
    }

    public String getBookNotFoundMessage() {
        return webDriver.findElement(By.xpath(ERROR_MESSAGE_XPATH)).getText();
    }
}

