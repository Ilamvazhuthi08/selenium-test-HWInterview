package project1Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project1Selenium {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\Ilam_project1\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		
	}

}
