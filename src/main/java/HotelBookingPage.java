import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelBookingPage {
    WebDriver driver;

    @BeforeTest
    public void intializeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/dipanjankundu/TestProject/app/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void searchHotel(){

        driver.navigate().to("https://www.cleartrip.com/");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);

        hotelBookingPage.shouldBeAbleToSearchForHotels();
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
