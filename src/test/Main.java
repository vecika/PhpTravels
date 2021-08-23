package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.cases.CheckForFlightsTest;
import test.cases.LoginTest;


/**
 * Main class that runs tests
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        //set up driver for Chrome
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // Login test
        LoginTest loginTest = new LoginTest();
        loginTest.RunLoginTest(driver);

        // CheckForFlights test
//        CheckForFlightsTest checkForFlightsTest = new CheckForFlightsTest();
//        checkForFlightsTest.RunTest(driver);


    }
}
