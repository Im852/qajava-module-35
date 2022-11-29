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
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Iron Maiden\\IdeaProjects\\MyProject35\\MyProject35\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
    }

    @Given("url of website {string}")
    public void url_of_website(String url) {
    webDriver.get(url);
    }

    @When("website is open accept all cookie")
    public void website_is_open_accept_all_cookie() {
    webDriver.findElement(By.xpath("//button[contains(@class,\"cookie-policy__button\")]")).click();
    }

    @Then("search book {string}")
    public void search_book(String searchParam) {
        WebElement searchField = webDriver.findElement(By.xpath("//input[@id = \"search-field\"]"));
        searchField.sendKeys(searchParam);
        searchField.submit();
    }
    @Then("click wishlist button")
    public void click_wishlist_button() {
    webDriver.findElement(By.xpath("//a[contains(@class,\"icon-fave\")]/span[@class = \"header-sprite\"]")).click();
    }

    @Then("go to wishlist")
    public void go_to_wishlist() {
        webDriver.findElement(By.xpath("//span[text() = \"Отложено\"]")).click();
    }
    @Then("assert that book added to wishlist is {string}")
    public void assert_that_book_added_to_wishlist_is(String expectedBook) {
    final String actualBook = webDriver.findElement(By.xpath("//span[@class = \"product-title\"]")).getText();
    assertEquals(expectedBook,actualBook);
    }


    @When("website is open search book {string}")
    public void website_is_open_search_book(String searchParam) {
        WebElement searchField = webDriver.findElement(By.xpath("//input[@id = \"search-field\"]"));
        searchField.sendKeys(searchParam);
        searchField.submit();
    }
    @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String expectedMessage) {
        final String actualMessage = webDriver.findElement(By.xpath("//h1[text() = \"Мы ничего не нашли по вашему запросу! Что делать?\"]")).getText();
        assertEquals(expectedMessage,actualMessage);
        System.out.println("I've done it!");
    }
}
