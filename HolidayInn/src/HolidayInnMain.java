import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HolidayInnMain {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/ryon/Downloads/geckodriver");
		HolidayInnDriver driver = new HolidayInnDriver();
		driver.get("https://www.ihg.com/holidayinn/destinations/us/en/united-states-hotels");
		List<WebElement> states = driver.findElements(By.xpath("//li[@class='listingItem']/a"));
		for(int stateCount = 0; stateCount < states.size(); stateCount++){
			
		}//End state for
		
	
	}//End main
}//End class
