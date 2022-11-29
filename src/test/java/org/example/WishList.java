package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class WishList {     //Страница раздела "Отложено" сайта
    private final static String BOOK_IN_WISHLIST_XPATH = "//span[@class = \"product-title\"]";

    private final WebDriver webDriver;

    public WishList(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentBookFromWishlist() {
        return webDriver.findElement(By.xpath(BOOK_IN_WISHLIST_XPATH)).getText();
    }
}
