package pepperfry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

//	Creating  variables
	public static WebDriver driver;
	public static String browserName;

	
	public static WebDriver getWebDriver() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
//		Reading config.properties file
		FileInputStream readFile = new FileInputStream("C:\\Users\\91970\\Downloads\\ProductListAutomation\\2165320-ProductListAutomation\\src\\config.properties");
		prop.load(readFile);
//		Selecting the browser to be launched from properties file
		browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
//			opening chrome browser
			System.out.println("Chrome Browser is openning");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\91970\\Downloads\\ProductListAutomation\\2165320-ProductListAutomation\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
//			opening firefox browser
			System.out.println("Firefox Browser is openning");
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
		} 
		else if (browserName.equalsIgnoreCase("edge")) {
//			opening edge browser
			System.out.println("MS Edge Browser is opening");
			System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} 
		else { // invalid values
			System.out.println("Choose a valid Browser either 1 or 2 -----> Restart the program");
			System.exit(0);
		}

//		Maximizing the window
		driver.manage().window().maximize();
		return driver;
	}

}
