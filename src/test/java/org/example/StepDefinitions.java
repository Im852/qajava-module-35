package org.example;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final MainPage mainPage;
    public static final PageOfResults pageOfResults;
    public static final WishList wishlist;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Iron Maiden\\IdeaProjects\\MyProject35\\MyProject35\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        mainPage = new MainPage(webDriver);
        pageOfResults = new PageOfResults(webDriver);
        wishlist = new WishList(webDriver);
    }

    @Given("url of website {string}")
    public void url_of_website(String url) {
        mainPage.goToSite();
    }

    @When("website is open accept all cookie")
    public void website_is_open_accept_all_cookie() {
        mainPage.acceptCookie();
    }

    @Then("search book {string}")
    public void search_book(String searchParam) {
        mainPage.searchBook(searchParam);
    }

    @Then("click wishlist button")
    public void click_wishlist_button() {
        pageOfResults.addToWishlist();
    }

    @Then("go to wishlist")
    public void go_to_wishlist() {
        pageOfResults.goToWishlist();
    }

    @Then("assert that book added to wishlist is {string}")
    public void assert_that_book_added_to_wishlist_is(String expectedBook) {
        final String actualBook = wishlist.getCurrentBookFromWishlist();
        assertEquals(expectedBook, actualBook);
    }


    @When("website is open search book {string}")
    public void website_is_open_search_book(String searchParam) {
        mainPage.searchBook(searchParam);
    }

    @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String expectedMessage) {
        final String actualMessage = pageOfResults.getBookNotFoundMessage();
        assertEquals(expectedMessage, actualMessage);
        System.out.println("I've done it!");
    }
}
