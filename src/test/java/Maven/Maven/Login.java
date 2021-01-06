package Maven.Maven;

//Java
import java.util.concurrent.TimeUnit;

//selenium
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//testng
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;


public class Login {
  
	//Gobal Declaration
	  public WebDriver driver;
	  
	  @BeforeTest
	  public void beforeTest() 
	  {
		  System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		  System.out.println("Chrome is opend");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  //Lauch the talentx
		  driver.get("https://talentx.kgisl.com/");
	  }
	  
	  @Test(priority=0)	
	  public void loginxtrack() throws InterruptedException 
	  {
		  WebElement username=driver.findElement(By.id("Username"));
		  username.sendKeys("smhussain.r");
		  driver.findElement(By.id("Password")).sendKeys("Rvt@1234567");;
		  WebElement login=driver.findElement(By.xpath("//*[@id='frmLogin']/fieldset/div[2]/button/span"));
		  login.click();
		  System.out.println("Sheik loged In");
		  
		  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		  WebElement acc=driver.findElement(By.xpath("//*[@id=\'navbar-container\']/div[2]/ul/li/a/i"));
		  acc.click();
		  
		  WebElement logout=driver.findElement(By.xpath("//*[@id=\'navbar-container\']/div[2]/ul/li/ul/li[6]/a"));
		  logout.click();
		
		  System.out.println("Sheik loged Out");
		  System.out.println("positive test case executed");
		  Thread.sleep(1000);
		  
		  
	  }
	  
	  @Test(priority=1)	
	  public void invalidloginxtrack() 
	  {
		  WebElement username=driver.findElement(By.id("Username"));
		  username.sendKeys("smhussain.r");
		  driver.findElement(By.id("Password")).sendKeys("Rvt@123");;
		  WebElement login=driver.findElement(By.xpath("//*[@id='frmLogin']/fieldset/div[2]/button/span"));
		  login.click();
		  //System.out.println("Invalid User Name and Password");
		  System.out.println("Negative test case executed");  
		  
	  }
	  
	   
	  @AfterTest
	  public void afterTest() 
	  {
		  driver.quit();
	  }

}
