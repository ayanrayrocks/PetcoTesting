package testCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.DateUtil;
import utility.ExtentReport;
import utility.ReadFile;

public class PectoFiSec {

	
	public static WebDriver driver;
	public static Properties prop;
	public  ExtentTest logger;
	public  ExtentReports report=ExtentReport.getReportInstance(); 
	 
	//@BeforeSuite
	public void OpenApplication() throws InterruptedException {
		boolean ch = true;
		if(ch==true) {
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
         driver = new ChromeDriver(options);  
		}else {			
		     EdgeOptions options = new EdgeOptions();			 
			 System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\msedgedriver.exe");
	         driver = new EdgeDriver(options);
			 
		}
		
		 driver.manage().window().maximize();		 
		 driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
		 
		 try {
		 driver.get("https://www.petco.com/shop/en/petcostore");
		 reportPass("Url opened Successfully");
		 }catch(Exception e) {
			 reportFail(e.getMessage());
		 }
		 
		 if (prop == null) {
				prop = new Properties();
			
				try {
					FileInputStream file = new FileInputStream(System.getProperty("user.dir")
							+ "\\src\\test\\resources\\objectreprository\\projectConfig.properties");
					prop.load(file);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		 
	         }
		 		
		    WebDriverWait wait=new WebDriverWait(driver, 10);
			WebElement element;
			try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("popUpKey"))));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	
	
	@Test(priority=1)
	public void DogBedBrand() throws InterruptedException, IOException {
		
		logger = report.createTest("Dog Beds Brand");
		boolean ch = true;
		if(ch==true) {
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
         driver = new ChromeDriver(options);  
		}else {			
		     EdgeOptions options = new EdgeOptions();			 
			 System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\msedgedriver.exe");
	         driver = new EdgeDriver(options);
			 
		}
		
		 driver.manage().window().maximize();		 
		 driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
		 
		 try {
		 driver.get("https://www.petco.com/shop/en/petcostore");
		 reportPass("Url opened Successfully");
		 }catch(Exception e) {
			 reportFail(e.getMessage());
		 }
		 
		 if (prop == null) {
				prop = new Properties();
			
				try {
					FileInputStream file = new FileInputStream(System.getProperty("user.dir")
							+ "\\src\\test\\resources\\objectreprository\\projectConfig.properties");
					prop.load(file);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		 
	         }
		 		
		    WebDriverWait wait=new WebDriverWait(driver, 10);
			WebElement element;
			try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("popUpKey"))));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
		//click on the popup
		if(driver.findElements(By.xpath(prop.getProperty("popUpKey"))).size()==1) {
			 System.out.println(driver.findElements(By.xpath(prop.getProperty("popUpKey"))).size());
			 driver.findElement(By.xpath(prop.getProperty("popUpKey"))).click();
		 }
		
		//close the offer ad
		//driver.findElement(By.xpath(prop.getProperty("headerKey"))).click();
				
				 
	  //Click on hambergur button
		try {
		 driver.findElement(By.xpath(prop.getProperty("hambergurButtonKey"))).click();
		 reportPass("Hambergur Button clicked Succesfully");   
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
         		 
		Actions action = new Actions(driver); 
	  //Click on Dog section
		try {
		 WebElement we = driver.findElement(By.xpath(prop.getProperty("dogButton")));		 
		 action.moveToElement(we).build().perform();
		 reportPass("Dog button succesfully clicked "); 
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		 
	   //Click on Beds
		try {
		 WebElement we1 = driver.findElement(By.xpath(prop.getProperty("bedButton")));
         action.click(we1).perform();
         reportPass("Bed button clicked succesfully"); 
		}catch(Exception e){
			reportFail(e.getMessage());
		}
        //explicit wait
         WebDriverWait w = new WebDriverWait(driver,7);
         
        // presenceOfElementLocated condition
         w.until(ExpectedConditions.presenceOfElementLocated (By.xpath(prop.getProperty("collapsedBedKey"))));
         
        //Expand the Brand
         try {
         driver.findElement(By.xpath(prop.getProperty("brandKey"))).click();
         reportPass("Brand button clicked succesfully");
         }catch(Exception e) {
        	 reportFail(e.getMessage());
         }
         
        //Select harmony as a brand
         try {
         driver.findElement(By.xpath(prop.getProperty("harmonyBrand"))).click();
         reportPass("Harmony brand is selected succesfully");
         }catch(Exception e) {
        	 reportFail(e.getMessage());
         }
         
        // presenceOfElementLocated condition
		  w.until(ExpectedConditions.presenceOfElementLocated (By.xpath(prop.getProperty("loadingLogo"))));
			
        //Storing the product name        
         List<WebElement> productname= driver.findElements(By.xpath(prop.getProperty("productName")));
         int totalproduct = productname.size();
         List<String> actualProductname = new LinkedList<String>();
         for(int i=0;i<totalproduct;i++) {
        	// System.out.println(productname.get(i).getText());
        	 String A = productname.get(i).getText();
        	 String arr[] = A.split(" ",2);
        	 actualProductname.add(arr[0]);
         }
         
        //Read the expected brand name from excel
         String expectedProductName = null;
         try {
         expectedProductName = ReadFile.getCellData("BrandName",0,0);
         System.out.println(expectedProductName);
         reportPass("Succesfully read the expected brand name from Excel");
         }catch (Exception e) {
        	 reportFail(e.getMessage());
		}
         Iterator<String> prodName = actualProductname.iterator();
         try {
         while(prodName.hasNext()) {
        	   // System.out.println(prodName.next());
        	    Assert.assertEquals(expectedProductName, prodName.next()); 
        	}
         reportPass("Succesfully check the expected and actual brand name in the page");
         }catch(Exception e){
        	 reportFail(e.getMessage());
         }
                 
	}
	
	@Test(priority=2)
	public void DogDryFood() throws InterruptedException {
		logger = report.createTest("Dog Dry Food");
		
		//navigate to Home page
 		driver.navigate().to(prop.getProperty("homePage"));
		
		//Click on Hambergur button
		try {
			 driver.findElement(By.xpath(prop.getProperty("hambergurButtonKey"))).click();
			 reportPass("Hambergur Button clicked Succesfully");   
			}catch(Exception e) {
				reportFail(e.getMessage());
			}
         
		 Actions action = new Actions(driver);
		 
		 //Click on dog section
		 try {
		 WebElement we = driver.findElement(By.xpath(prop.getProperty("dogButton")));
		 action.moveToElement(we).build().perform();
		 reportPass("Sucessfully cliked on the Dog button");  
		 }catch (Exception e) {
			 reportFail(e.getMessage());
		}
		 
		 //Click on DryFood
		 try {
         WebElement we1 = driver.findElement(By.xpath(prop.getProperty("dryFood")));
         action.click(we1).perform();
         reportPass("Sucessfully cliked on the DryFood button");
		 }catch(Exception e){
			 reportFail(e.getMessage());
		 }
		 
         //explicit wait
         WebDriverWait w = new WebDriverWait(driver,7);
         
         // presenceOfElementLocated condition
         w.until(ExpectedConditions.presenceOfElementLocated (By.xpath(prop.getProperty("collapsedFoodKey"))));
		  
		 //click on Price section
         try {
		  driver.findElement(By.xpath("//a[contains(text(),'Price')]")).click();
		  reportPass("Sucessfully cliked on the Price Button");
         }catch(Exception e) {
        	 reportFail(e.getMessage());
         }
		  		  
		 //click on $10-$25 price
         try {
		  driver.findElement(By.xpath(prop.getProperty("priceLimit"))).click();
		  reportPass("Sucessfully cliked on the Price limit of $10 - $25 Button");
         }catch (Exception e) {
        	 reportFail(e.getMessage());
		}
		  
		 //presenceOfElementLocated condition
		  w.until(ExpectedConditions.presenceOfElementLocated (By.xpath(prop.getProperty("loadingLogo"))));
		  
		 //Storing the no. of product on first page
		  int f=0;
		  try {
		  List<WebElement> productimages= driver.findElements(By.xpath(prop.getProperty("productsImage")));
		   f = productimages.size();
		   reportPass("Sucessfully Count the no. of products in first page");
		  }catch(Exception e) {
			  reportFail(e.getMessage()); 
		  }
		  //Scrolling
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,5300)"); 
		     
	      //Storing the no. pages
			int lastno = 0;
			try {
			List<WebElement> noOfpages= driver.findElements(By.xpath(prop.getProperty("noOfPagesKey")));
			List<String> n = new LinkedList<String>();
			
			for(int i=0;i<noOfpages.size();i++) {
				n.add(noOfpages.get(i).getText());
			}			
			 lastno = Integer.parseInt(n.get(noOfpages.size()-1));
			System.out.println("No. of Pages: "+lastno);
			reportPass("Sucessfully Count the no. of Pages");
			}catch(Exception e) {
			   reportFail(e.getMessage());
			}
			int actualno=0;
		    int j=0;
		    
		 //Go to next page and storing the no. product 
			while(j<lastno-1) {
				
					 driver.findElement(By.xpath(prop.getProperty("nextPageButton"))).click();
					 Thread.sleep(3000);
					 List<WebElement> productimages2= driver.findElements(By.xpath(prop.getProperty("productsImage")));
					 actualno =actualno + productimages2.size();
					 JavascriptExecutor js1 = (JavascriptExecutor) driver;
					 js1.executeScript("window.scrollBy(0,4300)");
					 //System.out.println(actualno);
				j++;
			}
		
		//Actual no. of product	
		 int actualproduct= f+actualno;
		 System.out.println("Actual Product : " +actualproduct);
		 
		//expected no. of product
		 int expectedproduct=0;
		 try {
		 String noofproduct= driver.findElement(By.xpath(prop.getProperty("expectedProduct"))).getText(); 
		 String[] splitStr = noofproduct.split("\\s+");		 
		  expectedproduct=Integer.parseInt(splitStr[4]); 
		 System.out.println("Expected Products : "+expectedproduct);
		 reportPass("Sucessfully Count the expected no. of product");
		 }catch(Exception e) {
			 reportFail(e.getMessage());
		 }
		 
       //Checking expected and actual
		 try {
		 Assert.assertEquals(actualproduct, expectedproduct);
		 reportPass("Sucessfully Check the expected is same as actual ");
		 }catch(Exception e) {
			 reportFail(e.getMessage()); 
		 }
		 
		 if(actualproduct==expectedproduct) {
			 System.out.println("Actual is equal to same no. of expected product");
		 }else {
			 System.out.println("Actual is not equal to expected no. of product");
		 }
		 
	  //navigate to Home page
	 	 driver.navigate().to(prop.getProperty("homePage"));
	}
	
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "//screenshots//" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "//screenshots//" + DateUtil.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//report fail if test case got fail
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
		
	}

	//report pass if test cases got pass
	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
		
	}
	
	@AfterTest
	public void endReport() {
		report.flush();
		
	}
	@AfterSuite
	public void closeApplication() {
		driver.quit();
	}
}
