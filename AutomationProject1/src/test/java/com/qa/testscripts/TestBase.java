package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.NetflixPage;

public class TestBase {

	WebDriver driver;
	NetflixPage NetflixOR;
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void Setup(String Browser,String Url) {
		
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\New folder\\softwares\\chromedriver.exe");
			driver = new ChromeDriver();		
		}
		else if(Browser.equalsIgnoreCase("Gecko")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Desktop\\New folder\\softwares\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\user\\Desktop\\New folder\\softwares\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\Desktop\\New folder\\softwares\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		NetflixOR = new NetflixPage(driver);
		driver.get(Url);
		
	}
	
	
	
	@AfterClass
	public void Teardown() {
		driver.close();
	}
	
	
	public void CaptureScreenShot(WebDriver driver, String Testcase) throws IOException {
		TakesScreenshot Capture = (TakesScreenshot)driver;
		File Source = Capture.getScreenshotAs(OutputType.FILE);
		File Destination = new File(System.getProperty("user.dir")+"/Screenshots/"+Testcase +".png");
		FileUtils.copyFile(Source, Destination);
	}
	
	
}
