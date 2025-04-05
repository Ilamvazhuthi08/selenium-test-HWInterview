package project1Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyContactUsClickable {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium_Projects\\\\Ilam_project1\\\\drivers\\\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        try {
            // Replace with your target URL
            driver.get("https://www.airnavradar.com/@19.31762,82.42126,z6");

            driver.manage().window().maximize();
            
            // Wait for popup to appear (update selector based on actual popup)
            WebElement popupButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button > p"))
            );

            // Click the button inside the popup
            popupButton.click();
            System.out.println("✅ Popup button clicked.");

            // Locate the "About Us" menu item (adjust selector as needed)
            WebElement aboutUsMenu = driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[9]/div[1]/span"));
            
            // Hover over the "About Us" menu
            actions.moveToElement(aboutUsMenu).perform();

            // Wait for the "Contact Us" link to be visible/clickable under the hover menu
            WebElement contactUsLink = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("/html/body/header/div/nav/ul/li[9]/div[2]/ul/li[15]/a")));

            System.out.println("✅ 'Contact Us' link is visible and clickable.");

            // Click the link
            contactUsLink.click();

            // Wait for navigation and verify the page (via URL, title, or heading)
            wait.until(ExpectedConditions.urlContains("Contact Us"));  // Adjust as needed

            // Optional: Print the final page title or URL
            System.out.println("✅ Navigated to Contact Us page: " + driver.getCurrentUrl());

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}