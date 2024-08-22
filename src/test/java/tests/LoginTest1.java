package tests;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.DriverManager;
import pages.LoginPage;
import utils.EmailUtil;
import utils.ScreenshotUtil;

public class LoginTest1 {
	
	 LoginPage loginPage;

	    @BeforeMethod
	    public void setUp() {
	        DriverManager.getDriver().get("https://youtube.com");
	        loginPage = new LoginPage();
	    }

	    @Test
	    public void testValidLogin() {
	        loginPage.login("KGF");
	        Assert.assertTrue(DriverManager.getDriver().getTitle().contains("YouTube"));
	    }

	    @AfterMethod
	    public void tearDown(ITestResult result) {
	        if (ITestResult.FAILURE == result.getStatus()) {
	            ScreenshotUtil.captureScreenshot(result.getName());
	            EmailUtil.sendEmail("hanumanth@usrinfotech.com", 
	                "Test Failed: " + result.getName(),
	                "Please find the attached screenshot of the failed test.",
	                "screenshots/" + result.getName() + ".png");
	        }
	        DriverManager.quitDriver();
	    }
	}