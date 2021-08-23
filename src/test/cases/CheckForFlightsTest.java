package test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * TEST CASE -> Login
 * 1. User opens Google Chrome Browser
 * 2. User maximises browser
 * 3. User Clicks on Flights
 * 4. User enters Flying From
 * 5. User enters To Destination
 * 6. User Clicks Search
 *
 * <p>
 * PASS condition -> Retrieved flights data
 * FAIL condition -> No retrieved flights data
 */

public class CheckForFlightsTest {

    public void RunTest(WebDriver driver) throws InterruptedException {

        // 1.
        //open URL and maximise window
        driver.get("https://www.phptravels.net/");
        // 2.
        driver.manage().window().maximize();

        // 3.
        // User Clicks on Flights
        driver.findElements(By.id("hotels-tab")).get(1).click();

        // 4.
        // User enters Flying From
        WebElement flyingFrom = driver.findElement(By.xpath("//*[@id=\"autocomplete\"]"));
        Thread.sleep(1000);
        flyingFrom.sendKeys("IST" , Keys.TAB);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[1]/div/div[1]/div/div/div/div/div[1]")).click();

        // 5.
        // User enters To Destination
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"autocomplete2\"]")).sendKeys("YXC");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[1]/div/div[2]/div/div/div/div/div[1]")).click();


        // 6.
        // User Clicks Search
        driver.findElement(By.id("flights-search")).click();

        // wait for result as in flights found element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement totalFlights = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[2]/div/ul/li/a"))));

        // 6.
        // Show log for test failed or passed
        System.out.println(totalFlights.getText().split("\\s+")[2].equals("0") ? "Test Failed -> No flights found" : "Test Passed -> Flights found");

        // And finally close browser
        driver.quit();

    }

}
