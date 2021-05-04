package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utilities.MovieNamesData;

public class TC_Netflix_01 extends TestBase{

	
	@Test(priority=1 )
	public void Login() throws InterruptedException {
		
	//1. Enter EmailId
	NetflixOR.getEmailIdTextFeild().sendKeys("prajwal.adhithya.20@gmail.com");	
	
	//2. Enter Password
	NetflixOR.getPasswordTextFeild().sendKeys("praju@20");
	
	//3. Click Login
	NetflixOR.getSignInBtn().click();
	Thread.sleep(5000);
	
	//4. Select the profile
	NetflixOR.getProfileBtn().click();
	Thread.sleep(5000);
		
	}
	
	
	@Test(priority=2,dataProvider = "MovieName")
	public void AddMovieToMyList(String SearchMovie) throws InterruptedException, IOException{
		
		
	try {
		//1. Search the movie
		NetflixOR.getSearchBtn().click();
		Thread.sleep(5000);
		NetflixOR.getSearchBox().clear();
		NetflixOR.getSearchBox().sendKeys(SearchMovie);
		Thread.sleep(5000);
		
		//2.Check the Movie is available, if available add the movie to MyList.
		List<WebElement> AllMovies = NetflixOR.getSelectMovie();
		
		for( WebElement ele:AllMovies ) 
		{
			 String MovieName = ele.getText();
			 Boolean Condtion1 = MovieName.equalsIgnoreCase(SearchMovie);
			 if(Condtion1) {
		
				//Select the Movie
				ele.click();
				Thread.sleep(5000);
				
				//Click on add to MyList
				NetflixOR.getAddtoList().click();
				Thread.sleep(5000);
				
				//Close the movie
				NetflixOR.getCloseBtn().click();
				Thread.sleep(5000);
				
				//Go to Home Section
				NetflixOR.gethome().click();
				Thread.sleep(5000);
				
				//Go to MyList Section
				NetflixOR.getlist().click();
				Thread.sleep(5000);
				
				List<WebElement> MyListMovies = NetflixOR.getSelectMovie();
				
				for(WebElement Movie : MyListMovies) 
				{
					String Name = Movie.getText();
					Boolean Conditon2 = Name.equalsIgnoreCase(SearchMovie);
					if(Conditon2)
					{
						Reporter.log(SearchMovie +" added to my list",true );
						driver.navigate().back();
						break;
						
					}
					else {
						Assert.assertFalse(Conditon2);
						Reporter.log(SearchMovie +" not added to my list",true );
						CaptureScreenShot(driver, "AddMovieToMyList");
						break;
					}
					
				}
			 }
			 else {
				 Assert.assertTrue(Condtion1);
				 Reporter.log(SearchMovie+" Movie not available",true);
				 CaptureScreenShot(driver, "AddMovieToMyList");
				 break;
			 }
		 }
		}
		catch(StaleElementReferenceException e) 
		{
			//Handle the Stale Elements
		}
	}
	
	
	
	@DataProvider(name = "MovieName")
	public Object[][] getData() throws IOException {
		
		String XPath = "F:\\workspace\\AutomationProject1\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String Xsheet = "Sheet1";
		int RowNum = MovieNamesData.getRowCount(XPath, Xsheet);
		int ColNum = MovieNamesData.getCellCount(XPath, Xsheet, RowNum);
		String[][] data = new String[RowNum][ColNum];
		for(int i=1;i<=RowNum;i++)
		{
			for(int j=0;j<ColNum;j++)
			{
				data[i-1][j]= MovieNamesData.getCellData(XPath, Xsheet, i, j);
			}
		}
		
		return data;
		
	}
}
