/**
 * Created by Jacob_MACMini on 30/04/2017.
 */
package com.mypage.amazon;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class AmzonSearch {

    public static void main(String url)
    {
        // Create a new instance of the browser
        WebDriver driver = new SafariDriver();

        //Launch the Amazon.com Website
        driver.get(url);
        //driver.get("http://amazon.com");
        // (alternate) driver.navigate().to(java.lang.String.valueOf("http://amazon.com"));

        // Print a Log In message to the screen
        System.out.println("Successfully opened amazon.com website.");

        //Find the search field on Amazon.com
        WebElement searchfield = driver.findElement(By.id("twotabsearchtextbox"));
        searchfield.click();

        // Print a Log In message to the screen
        System.out.println("Successfully found search field.");

        //Input search string
        searchfield.sendKeys("Nikon");

        //Submit query
        WebElement searchbutton = driver.findElement(By.id("nav-search-submit-text"));
        searchbutton.submit();

        //Wait until the results are displayed and the Sort field is present (or visible = using visibilityOfElementLocated)
        WebDriverWait waitResults = new WebDriverWait(driver, 10);
        WebElement sortfield = waitResults.until( ExpectedConditions.presenceOfElementLocated(By.id("sort")) );
        sortfield.click();

        //Print a Log In message to the screen
        System.out.println("Successfully found sort field.");

        //Sorting the search result from highest to lowest price
        Select sortoptions = new Select(driver.findElement(By.id("sort")));
        sortoptions.selectByIndex(3);

        //Wait until the results are sorted completely.
        WebDriverWait waitSortedResults = new WebDriverWait(driver, 10);
        //WebElement sortedResult = waitSortedResults.until( ExpectedConditions.presenceOfElementLocated(By.linkText("See all sorted results.")) );
        WebElement sortedResult = waitSortedResults.until( ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='result_1']/div/div/div/div[2]/div[1]/div[1]/a/h2")) );

        //Print a Log In message to the screen
        System.out.println("Successfully found text 'See all sorted results.'");

        //Select and open the second result item.
        WebElement secondresult = driver.findElement(By.xpath("//*[@id='result_1']/div/div/div/div[2]/div[1]/div[1]/a/h2"));
        System.out.println(secondresult.getText());
        secondresult.click();

        //Wait until the product details page is fully displayed.
        WebDriverWait waitPageLoaded = new WebDriverWait(driver, 10);
        WebElement detailspageopen = waitResults.until( ExpectedConditions.visibilityOfElementLocated(By.name("submit.add-to-cart")) );
        System.out.println("Product details page is now fully loaded.");

        //Find the text
        Assert.assertEquals(true, driver.getPageSource().contains("Nikon D3X"));
        System.out.println("Test 'Nikon D3X' is found in page source");

       //If "Assert" = to TRUE then the following actions will be done.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.close();
        System.out.println("Browser closed.");

    }

    }


