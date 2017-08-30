package QardDeck.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.grid.internal.listeners.Prioritizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Signup {
	WebDriver driver;
	@BeforeTest 
	public void configbeforetest(){
		System.setProperty("webdriver.chrome.driver","D:\\SELENIUM WEBDRIVER SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
		  
	}
	@BeforeMethod
	public void configbeforemethod(){
		 driver.get("http://wordpressmonks.com/works/qarddeck/web/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//button[text()='Sign In/Sign Up']")).click();
			//  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  WebDriverWait wait=new WebDriverWait(driver,10);
			  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-target='#myModalemail']"))));
			  driver.findElement(By.xpath("//button[@data-target='#myModalemail']")).click();
	}
	
  @Test(dataProvider="getdata",priority=2)
  public void checkSignin(String un,String fn,String ln,String email,String pwd,String repwd) 
  { 
	  //fill the un ,fn ,ln,email,pwd,repwd
	  if(un==null && fn==null && ln==null && email==null && pwd==null && repwd==null){
		  //driver.close();
		  System.out.println("null values");
	  }
	  else{
	  driver.findElement(By.xpath("//input[@name='User[username]']")).sendKeys(un);
	  driver.findElement(By.xpath("//input[@name='UserProfile[firstname]']")).sendKeys(fn);
	  driver.findElement(By.xpath("//input[@name='UserProfile[lastname]']")).sendKeys(ln);
	  driver.findElement(By.xpath("//input[@name='User[email]']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@name='User[password]']")).sendKeys(pwd);
	  driver.findElement(By.xpath("//input[@name='User[verify_password]']")).sendKeys(repwd);
	  driver.findElement(By.xpath("//button[text()='So you want in do you - Sign up']")).click();
	//  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   //driver.close();
	  }
	  
  }
  @ Test(priority=1)
  public void editsignup(){
	  /*************login user*****************/
	  WebDriverWait wait1=new WebDriverWait(driver,10);
	  wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='LoginForm[username]']"))));
	  driver.findElement(By.xpath("//input[@name='LoginForm[username]']")).sendKeys("abc1");
	  
	  WebDriverWait wait2=new WebDriverWait(driver,10);
	  wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='LoginForm[password]']"))));
	  driver.findElement(By.xpath("//input[@name='LoginForm[password]']")).sendKeys("reset123");
	  
	  driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	  WebDriverWait waitele=new WebDriverWait(driver,10);
	  waitele.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Edit']"))));
	  driver.findElement(By.xpath("//button[text()='Edit']")).click();
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  /*****************Read the datas*************************/
	  String firstname=driver.findElement(By.xpath("//input[@name='UserProfile[firstname]']")).getAttribute("value");
	  if(firstname.equals("fn")){
		  System.out.println("the data is in plce");
	  }else{
		  System.out.println("the data is wrong");
	  }
	  String lastname=driver.findElement(By.xpath("//input[@name='UserProfile[lastname]']")).getAttribute("value");
	  if(lastname.equals("ln1")){
		  System.out.println("the data is in plce");
	  }else{
		  System.out.println("the data is wrong");
	  }
	  driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
  }
  @Test(priority=3)
  public void editdata(){
	  WebDriverWait wait1=new WebDriverWait(driver,10);
	  wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='LoginForm[username]']"))));
	  driver.findElement(By.xpath("//input[@name='LoginForm[username]']")).sendKeys("abc1");
	  
	  WebDriverWait wait2=new WebDriverWait(driver,10);
	  wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='LoginForm[password]']"))));
	  driver.findElement(By.xpath("//input[@name='LoginForm[password]']")).sendKeys("reset123");
	  
	  driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	  WebDriverWait waitele=new WebDriverWait(driver,10);
	  waitele.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Edit']"))));
	  driver.findElement(By.xpath("//button[text()='Edit']")).click();
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  
	  driver.findElement(By.id("userprofile-short_description")).sendKeys("ejrfnkjnne");
	  
	  driver.findElement(By.id("userprofile-display_email")).sendKeys("wfn@gmail.com");
	  
	  driver.findElement(By.xpath("//label[@for='cmn-toggle-4']")).click();
	  driver.findElement(By.xpath("//button[text()='Update']")).click();
	  String mail=driver.findElement(By.xpath("//li[i[@class='fa fa-envelope']]")).getText();
	  System.out.println(mail);
	  if(mail.equals("wfn@gmail.com")){
		  System.out.println("mail is dispalying correctly");
	  }
  }
  @AfterMethod
  public void configAfterTest(){
	  try{
		  driver.findElement(By.xpath("//button[text()='Logout']")).click();
		  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	  }
	  catch(Throwable t){
		  WebDriverWait wait3=new WebDriverWait(driver,5);
		  wait3.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//button[text()='Back to Social Login']"))));
		  driver.findElement(By.xpath("//button[text()='Back to Social Login']")).click();
		  
	  }
	 
  }
  @AfterTest
  public void configAfetrtest(){
	  driver.quit();
  }
  @DataProvider
  public Object[][]  getdata()throws IllegalFormatException, IOException, EncryptedDocumentException, InvalidFormatException 
  {
  	
  	  FileInputStream fis=new FileInputStream("C:\\Users\\ad\\Desktop\\testdata.xlsx");
  	 Workbook wb= WorkbookFactory.create(fis);
  	Sheet sh= wb.getSheet("signin");
  	int rn=sh.getLastRowNum();
  	System.out.println("total row "+rn);
 	Object[][] obj=new Object[rn+1][6];
  	for(int i=1;i<rn+1;i++){
  		Row rw=sh.getRow(i);
  		for(int j=0;j<6;j++){
  			Cell cell=rw.getCell(j);
  			cell.setCellType(Cell.CELL_TYPE_STRING);   //This is for any type value from excel
  				 String data=rw.getCell(j).getStringCellValue();
  				  obj[i][j]=data;
  			}
  		
  		
  	}
  	return obj;
  }
}
