package docker;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirefoxTest {

	RemoteWebDriver driver;
	
	 @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		 FirefoxOptions fop=new FirefoxOptions();
		 //DesiredCapabilities dc=DesiredCapabilities.firefox();
		 System.setProperty("java.net.preferIPv4Stack" , "true");
	      
	        URL url=new URL("http://host.docker.internal:4545/wd/hub");
	        
	        driver=new RemoteWebDriver(url,fop);
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        System.out.println(driver.toString());
	        driver.get("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");

	  }

 @Test
 public void f() {
	 System.out.println("title of page: "+driver.findElement(By.id("logInPanelHeading")).getText());

 }
@Test
public void f2() {
	driver.findElement(By.id("txtUsername")).sendKeys("opensourcecms");
    driver.findElement(By.id("txtPassword")).sendKeys("opensourcecms");
    driver.findElement(By.id("btnLogin")).click();
    String url= driver.getCurrentUrl();
    System.out.println("Current page url is : "+url);
}
@Test
public void f3() throws InterruptedException{
	driver.findElement(By.xpath("//*[@id=\"option-menu\"]/li[3]/a")).click();
    
    if(driver.findElement(By.id("frmLogin")).isDisplayed()) {
        System.out.println("Logged out successfully");
        
    }
    else {
        System.out.println("logout unsuccessfull");
    }
	 
}
 @AfterTest
 public void afterTest(){
	  driver.quit();
 }
}
