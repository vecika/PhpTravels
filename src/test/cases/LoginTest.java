package test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {

    /**
     * TEST CASE -> Login
     * 1. User opens Google Chrome Browser
     * 2. User maximises browser
     * 3. User Clicks on Login
     * 4. User enters username and password
     * 5. User Clicks login
     * <p>
     * PASS condition -> user successfully logs in
     * FAIL condition -> user is not able to log in
     */
    public void RunLoginTest(WebDriver driver) {

        // 1.
        //open URL and maximise window
        driver.get("https://www.phptravels.net/");
        // 2.
        driver.manage().window().maximize();

        // 3.
        // find Login button
        // would be great if elements had ID
        driver.findElement(By.linkText("Login")).click();

        // 4.
        // send keys for email and password inputs
        // shame again for ids
        driver.findElement(By.name("email")).sendKeys("user@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demouser");

        // 5.
        // click on login button
        // since the button has no ids or anything specific, it's found by xpath
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/button")).click();

        // check if dashboard is gonna show up after click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean isDashboardLoaded = wait.until(ExpectedConditions.urlContains("dashboard"));

        // 6.
        // Show log for test failed or passed
        System.out.println(isDashboardLoaded ? "Test Passed -> User successfully Logged in" : "Test Failed -> User failed login");

        // And finally close browser
        driver.quit();

    }

}
