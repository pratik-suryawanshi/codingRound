import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelBookingPage {

    WebDriver driver;

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;


    public HotelBookingPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void shouldBeAbleToSearchForHotels() {

        hotelLink.click();

        localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

    }

private void setDriverPath() {
       if (PlatformUtil.isMac()) {
          System.setProperty("webdriver.chrome.driver", "chromedriver");
      }
      if (PlatformUtil.isWindows()) {
          System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
     }
     if (PlatformUtil.isLinux()) {
         System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
     }
   }
