package pepperfry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListAutomation {
	
	public static WebDriver driver;
	List<WebElement> lst1, lst2;
	
//	For Invoking Driver
	public WebDriver createDriver() throws FileNotFoundException, IOException {
		driver = DriverSetup.getWebDriver();
		return driver;
	}
	
//	Opening the URL (www.pepperfry.com)
	public void navigateToURL() throws IOException {
		Properties prop = new Properties();
		FileInputStream readFile=new FileInputStream("C:\\Users\\91970\\Downloads\\ProductListAutomation\\2165320-ProductListAutomation\\src\\config.properties");
		prop.load(readFile);
		String websiteName = prop.getProperty("website");
		driver.get(websiteName);
//		Giving implicit wait for 60 seconds for the page to load completely
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
//	Validating the text “Online Furniture Shopping Store” in the title of the home page
	public void validateTitle()
	{
		if(driver.getTitle().contains("Online Furniture Shopping Store"))
		    //Pass
		    System.out.println("Page title contains Online Furniture Shopping Store");
		else
		    //Fail
		    System.out.println("Page title doesn't contains Online Furniture Shopping Store ");
	}
	
//	Selecting Furniture in the home page
	public void selectFurniture() {
		driver.findElement(By.xpath("//div[@id='menu_wrapper']/ul/li/a")).click();
	}
	
//	After selecting Furniture, click on Seating
	public void selectSeating() {
		driver.findElement(By.xpath("//*[@id=\'mCSB_1_container\']/ul/li[2]/a")).click();
	}
	
//	After selecting Seating, click on Benches
	public void selectBenches() {
		driver.findElement(By.xpath("//*[@id=\'mCSB_1_container\']/ul/li[3]/a")).click();
	}
	
//	Fetching all the bench details
	public void fetchBenchDetails() {
		lst1 = driver.findElements(By.xpath("//h5[@class='clip-maincat-ttl pf-margin-0 font-14']"));
		lst2 = driver.findElements(By.xpath("//p[@class='clip-catitem-strtngfrm pf-margin-0 font-12']"));
	}
	
//	Displaying the total Benches with respect to its category and count
	public void printBenchDetails() {
		System.out.println();
		System.out.println("No. of benches with respect to category:");
		for (int i = 0; i < lst1.size(); i++) {
			System.out.print(lst1.get(i).getText());
			System.out.print(" : ");
			// System.out.println(lst2.get(i).getText());
			System.out.println(lst2.get(i).getText().replaceAll(" ", "").replaceAll("[A-Za-z]", ""));
		}
	}
	
//	Checking whether “Industrial Benches” are more than one
	public void validateIndustrialBenchesCount() {
		System.out.println();
		System.out.print("Is Count of Industrial Benches greater than one? -->  ");
		for (int i = 0; i < lst1.size(); i++) {
			if (lst1.get(i).getText().equalsIgnoreCase("Industrial Benches")) {
				if (Integer.parseInt(lst2.get(i).getText().replaceAll(" ", "").replaceAll("[A-Za-z]", "")) > 1)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}

	}
	
//	To close the browser
	public void closeDriver() {
		driver.quit();
	}
}