package com.testing;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utility.Module;



public class AutoScripts {
	public static WebDriver driver;
	static JavascriptExecutor js;
	@Test(enabled=true)
	public static void LoginToXero_01(String browserName) throws InterruptedException, IOException{
		
		driver=Module.launchBrowser(browserName);
		driver=Module.Login_toXero(driver);
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Xero"))
			DriverFile.logger.log(Status.INFO,"Xero page is verified");
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Xero page is not verified",ExtentColor.RED));
			DriverFile.status=false;
			
		}
		String homeTiltle=driver.getTitle();
		System.out.println(homeTiltle);
		Thread.sleep(6000);
		if(homeTiltle.contains("Xero | Dashboard | tekarch"))
			DriverFile.logger.log(Status.INFO,"home page verified");
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("home page is not verified",ExtentColor.RED));
			String destination=Module.CaptureScreen(driver,Thread.currentThread().getStackTrace()[1].getMethodName());
			DriverFile.logger.log(Status.FAIL,"screen shots at:"+DriverFile.logger.addScreenCaptureFromPath(destination));
		}
			Module.closeBrowser(driver);
		DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
		
	}
	@Test(enabled=true)
	public static void LoginErrorMessage_02(String browserName) throws InterruptedException, IOException{
		String expString="Your email or password is incorrect";
		driver=Module.launchBrowser(browserName);
		driver.get("https://login.xero.com/");
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Xero"))
			DriverFile.logger.log(Status.INFO,"Xero page is verified");
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Xero page is not verified",ExtentColor.RED));
			DriverFile.status=false;
			
		}
		//
		driver.findElement(By.id("email")).sendKeys("vani.shadaksharaiah@gmail.com");
		driver.findElement(By.id("password")).sendKeys("23253646");
		driver.findElement(By.id("submitButton")).click();
		String actualText=driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText();
		
		if(actualText.equalsIgnoreCase(expString)){
			DriverFile.logger.log(Status.INFO,"error message verified");
		}
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("error message is not verified",ExtentColor.RED));
			
		}
		Module.closeBrowser(driver);
		DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
		
		
		
	}
	@Test(enabled=true)
	public static void LoginErrorMessage_03(String browserName) throws InterruptedException, IOException{
		String expString="Your email or password is incorrect";
		driver=Module.launchBrowser(browserName);
		driver.get("https://login.xero.com/");
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Xero"))
			DriverFile.logger.log(Status.INFO,"Xero page is verified");
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Xero page is not verified",ExtentColor.RED));
			DriverFile.status=false;
			
		}
		//
		driver.findElement(By.id("email")).sendKeys("user@gmail.com");
		driver.findElement(By.id("password")).sendKeys("23253646");
		driver.findElement(By.id("submitButton")).click();
		String actualText=driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText();
		System.out.println(actualText);
		System.out.println(expString);
		if(actualText.equalsIgnoreCase(expString)){
			DriverFile.logger.log(Status.INFO,"error message verified");
		}
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("error message is not verified",ExtentColor.RED));
			
		}
		Module.closeBrowser(driver);
		DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
		
		
		
	}
	@Test(enabled=true)
	public static void LoginForgotPassword_04(String browserName) throws InterruptedException, IOException{
		
		String expString="A link to reset your password has been sent to:";
		driver=Module.launchBrowser(browserName);
		driver.get("https://login.xero.com/");
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Xero"))
			DriverFile.logger.log(Status.INFO,"Xero page is verified");
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Xero page is not verified",ExtentColor.RED));
			DriverFile.status=false;
			
		}
		//
		driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/a")).click();
		Thread.sleep(4000);
		WebElement username=driver.findElement(By.id("UserName"));
		username.sendKeys("vani.shadaksharaiah@gmail.com");
		//String expString="A link to reset your password has been sent to:"+driver.findElement(By.id("UserName")).getText();
		driver.findElement(By.xpath(".//*[@id='submitButton']/a/span")).click();
		Thread.sleep(4000);
		String actualText=driver.findElement(By.xpath(".//*[@id='contentTop']/div/p[1]")).getText();
		System.out.println(expString);
		System.out.println(actualText);
		if(actualText.contains(expString)){
			DriverFile.logger.log(Status.INFO,"error message verified");
		}
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("error message is not verified",ExtentColor.RED));
			
		}
		Module.closeBrowser(driver);
		DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
		
		
		
	}
	
public static void SignUpTest_01(String browserName) throws InterruptedException, IOException{
		
		String expString="check your inbox";
		driver=Module.launchBrowser(browserName);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://www.xero.com/us/");
		String applicationTitle=driver.getTitle();
		System.out.println(applicationTitle);
		if(applicationTitle.contains("Xero US"))
			DriverFile.logger.log(Status.INFO,"Xero page is verified");
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Xero page is not verified",ExtentColor.RED));
			DriverFile.status=false;
			
		}
		//
		String expPageTitle="30 day free trial";
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click();
		Thread.sleep(4000);
		String pageTitle=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText();
		
		if(expPageTitle.contains(pageTitle))
			DriverFile.logger.log(Status.INFO,"Xero page is verified");
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Xero page is not verified",ExtentColor.RED));
			DriverFile.status=false;
			
		}
		//String expString="A link to reset your password has been sent to:"+driver.findElement(By.id("UserName")).getText();
		driver.findElement(By.name("FirstName")).sendKeys("Anna");
		driver.findElement(By.name("LastName")).sendKeys("John");
		driver.findElement(By.name("EmailAddress")).sendKeys("User@xyz.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*((JavascriptExecutor)
				driver).executeScript(window.scrollBy(2000,0));*/
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.name("PhoneNumber")).sendKeys("12325346325");
		

		//Thread.sleep(2000);
		Select locationCode=new Select(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[6]/label/span/select")));
		locationCode.selectByVisibleText("Afghanistan");
		
		WebElement chkboxTermsandCondition=driver.findElement(By.name("TermsAccepted"));
		chkboxTermsandCondition.click();
		//driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button")).click();
				
		Thread.sleep(4000);
	
		DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Aptacha Cannot be automated",ExtentColor.RED));
			
		
		Module.closeBrowser(driver);
		DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
		
		
		
	}
public static void SignUpErrorTest_02(String browserName) throws InterruptedException, IOException{
		
		
		driver=Module.launchBrowser(browserName);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://www.xero.com/us/");
		String applicationTitle=driver.getTitle();
		System.out.println(applicationTitle);
		if(applicationTitle.contains("Xero US"))
			DriverFile.logger.log(Status.INFO,"Xero page is verified");
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Xero page is not verified",ExtentColor.RED));
			DriverFile.status=false;
			
		}
		//
		String expPageTitle="30 day free trial";
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click();
		Thread.sleep(4000);
		String pageTitle=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText();
		
		if(expPageTitle.contains(pageTitle))
			DriverFile.logger.log(Status.INFO,"Xero page is verified");
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Xero page is not verified",ExtentColor.RED));
			DriverFile.status=false;
			
		}
		//String expString="A link to reset your password has been sent to:"+driver.findElement(By.id("UserName")).getText();
		driver.findElement(By.name("FirstName")).sendKeys("");
		driver.findElement(By.name("LastName")).sendKeys("");
		driver.findElement(By.name("EmailAddress")).sendKeys("");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*((JavascriptExecutor)
				driver).executeScript(window.scrollBy(2000,0));*/
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.name("PhoneNumber")).sendKeys("");
		

		//Thread.sleep(2000);
		
		
		
		WebElement ele=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button"));
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].removeAttribute(\"disabled\");",ele);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		wait1.until(ExpectedConditions.elementToBeClickable(ele));

		ele.click();
		
		String firstNameerr=driver.findElement(By.xpath(".//*[@id='signup-form-error-message-1']")).getText();
		String lastNameerr=driver.findElement(By.xpath(".//*[@id='signup-form-error-message-2']")).getText();
		String emailIDerr=driver.findElement(By.xpath(".//*[@id='signup-form-error-message-3']")).getText();
		String phoneNumerr=driver.findElement(By.xpath(".//*[@id='signup-form-error-message-4']")).getText();
		String expFirstNameerr="First name can't be empty";
		String expLastNameerr="Last name can't be empty";
		String expEmailIDerr="Email address can't be empty";
		String expPhoneNumerr="Phone number can't be empty";
		
		Thread.sleep(4000);
		if(firstNameerr.contains(expFirstNameerr)){
			DriverFile.logger.log(Status.INFO,"error message verified");
		}
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("error message is not verified",ExtentColor.RED));
			
		}
		if(lastNameerr.contains(expLastNameerr)){
			DriverFile.logger.log(Status.INFO,"error message verified");
		}
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("error message is not verified",ExtentColor.RED));
			
		}
		if(emailIDerr.contains(expEmailIDerr)){
			DriverFile.logger.log(Status.INFO,"error message verified");
		}
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("error message is not verified",ExtentColor.RED));
			
		}
		if(phoneNumerr.contains(expPhoneNumerr)){
			DriverFile.logger.log(Status.INFO,"error message verified");
		}
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("error message is not verified",ExtentColor.RED));
			
		}
		driver.findElement(By.name("EmailAddress")).sendKeys("ddefrwgrg");
		ele=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button"));
		Thread.sleep(2000);
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].removeAttribute(\"disabled\");",ele);
		wait1 = new WebDriverWait(driver, 40);
		wait1.until(ExpectedConditions.elementToBeClickable(ele));
       
		ele.click();
		String invaliId=driver.findElement(By.xpath(".//*[@id='signup-form-error-message-3']")).getText();
		String expInvalidEmailId="Email address is invalid";
		
		if(invaliId.contains(expInvalidEmailId)){
			DriverFile.logger.log(Status.INFO,"error message verified");
		}
		else{
			DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("error message is not verified",ExtentColor.RED));
			
		}
		
		Module.closeBrowser(driver);
		DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
		
		
	}

public static void SignUpTest_03A(String browserName) throws InterruptedException, IOException{
	
	
	driver=Module.launchBrowser(browserName);
	driver.get("https://www.xero.com/us/");
	String applicationTitle=driver.getTitle();
	System.out.println(applicationTitle);
	if(applicationTitle.contains("Xero US"))
		DriverFile.logger.log(Status.INFO,"Xero page is verified");
	else{
		DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Xero page is not verified",ExtentColor.RED));
		DriverFile.status=false;
		
	}
	//
	String expPageTitle="30 day free trial";
	driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click();
	Thread.sleep(4000);
	String pageTitle=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText();
	
	if(expPageTitle.contains(pageTitle))
		DriverFile.logger.log(Status.INFO,"SignUp page is verified");
	else{
		DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("SignUp page is not verified",ExtentColor.RED));
		DriverFile.status=false;
		
	}
	 js= (JavascriptExecutor) driver;

	js.executeScript("window.scrollBy(0,500)");
	
	driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[1]")).click();
	//Thread.sleep(8000);
	Thread.sleep(4000);
	js = (JavascriptExecutor) driver;

	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(4000);
	String termsPage=driver.findElement(By.xpath("html/body/main/div[2]/div/div/div[1]/h2")).getText();
	System.out.println(termsPage);
	if(termsPage.contains("terms of Use"))
		DriverFile.logger.log(Status.INFO,"Terms Use page is verified");
	else{
		DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Terms Use page is not verified",ExtentColor.RED));
		DriverFile.status=false;
		
	}
	Module.closeBrowser(driver);
	DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
	
	
	
}
public static void SignUpTest_03B(String browserName) throws InterruptedException, IOException{
	
	
	driver=Module.launchBrowser(browserName);
	
	driver.get("https://www.xero.com/us/");
	String applicationTitle=driver.getTitle();
	System.out.println(applicationTitle);
	if(applicationTitle.contains("Xero US"))
		DriverFile.logger.log(Status.INFO,"Xero page is verified");
	else{
		DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Xero page is not verified",ExtentColor.RED));
		DriverFile.status=false;
		
	}
	//
	String expPageTitle="30 day free trial";
	driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click();
	Thread.sleep(4000);
	String pageTitle=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText();
	
	if(expPageTitle.contains(pageTitle))
		DriverFile.logger.log(Status.INFO,"Signup page is verified");
	else{
		DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Signup page is not verified",ExtentColor.RED));
		DriverFile.status=false;
		
	}
	

	js.executeScript("window.scrollBy(0,500)");
	
	driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[2]")).click();
	Thread.sleep(10000);
	
	//Thread.sleep(5000);                           
	String privacyPage=driver.findElement(By.xpath("html/body/main/div[2]/div/div/div[1]/h2")).getText();
	System.out.println(privacyPage);
	if(privacyPage.contains("Privacy Policy"))
		DriverFile.logger.log(Status.INFO,"Privacy Policy page is verified");
	else{
		DriverFile.logger.log(Status.FAIL,MarkupHelper.createLabel("Privacy page is not verified",ExtentColor.RED));
		DriverFile.status=false;
		
	}
	Module.closeBrowser(driver);
	DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
	
	
	
}
	
	
	

}
