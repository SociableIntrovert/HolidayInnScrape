import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HolidayInnMain {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/ryon/Downloads/geckodriver");
		HolidayInnDriver driver = new HolidayInnDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("https://www.ihg.com/holidayinn/destinations/us/en/united-states-hotels");
		List<WebElement> states = driver.findElements(By.xpath("//li[@class='listingItem']/a"));
		for(int stateCount = 0; stateCount < states.size(); stateCount++){
			List<WebElement> statesRefreshed = driver.findElements(By.xpath("//li[@class='listingItem']/a"));
			driver.get(statesRefreshed.get(stateCount).getAttribute("href"));
			List<WebElement> cities = driver.findElements(By.xpath("//li[@class='listingItem']/a"));
			for(int cityCount = 0; cityCount < cities.size(); cityCount++){
				List<WebElement> citiesRefreshed = driver.findElements(By.xpath("//li[@class='listingItem']/a"));
				driver.get(citiesRefreshed.get(cityCount).getAttribute("href"));
				try{
					WebElement moreHotels = wait.until(ExpectedConditions.elementToBeClickable(By.id("show-hotels")));
					moreHotels.click();
					WebElement lessHotels = wait.until(ExpectedConditions.elementToBeClickable(By.id("hide-hotels")));
				}catch(Exception e){
					System.out.println("No extra locations");
				}
				List<WebElement> locations = driver.findElements(By.className("top_hotelname"));
				for(int locationsCount = 0; locationsCount < locations.size(); locationsCount++){
					List<WebElement> locationsRefreshed = driver.findElements(By.className("row top_hotelname sl_whiteout"));
					driver.get(locationsRefreshed.get(locationsCount).getAttribute("href"));
					System.out.println(driver.findElement(By.className("hi-hd-quick-info-address-heading")).getText());
					
				}//End locations for
				driver.navigate().back();
			}//End city for
			driver.navigate().back();
		}//End state for
		
	
	}//End main
}//End class
