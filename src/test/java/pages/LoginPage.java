package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.DriverManager;

public class LoginPage {
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    By usernameField = By.xpath("//input[@id=\"search\"]");
    By passwordField = By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon/span/div");
//    By loginButton = By.id("login");

    public void login(String username) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
        
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)); 
        driver.findElement(passwordField).click();;
        System.out.println(driver.getTitle());
        driver.getTitle();
//        driver.findElement(loginButton).click();
    }
}
