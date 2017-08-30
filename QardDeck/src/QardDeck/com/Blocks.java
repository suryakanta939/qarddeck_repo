package QardDeck.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.ptg.ExpPtg;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class Blocks {
	int a;
  @Test(enabled=false)
  public void textblock() {
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://wordpressmonks.com/works/qarddeck/web/user/register");
	  driver.manage().window().maximize();
	  /************************create a qard*************************************/
	  driver.findElement(By.xpath("//img[contains(@src,'qarddeck/web/images/plus')]")).click();
	  driver.findElement(By.xpath("//h3[text()='Create New Qard']")).click();
	  //select theme
	  System.out.println("select a theme ");
	  System.out.println("the themes are Candy Floss,Dew Drops,Test,Adobe");
	  String s1="//div[div[h4[text()='";
	  String s2="']]]";
	  Scanner scn=new Scanner(System.in);
	  String theme=scn.next();
	  driver.findElement(By.xpath(s1+theme+s2)).click();
	  //choose text color
	  driver.findElement(By.xpath("//button[@id='dropdownMenu3']")).click();
	  List<WebElement> typecolor=driver.findElements(By.xpath("//div[@class='dropdown open']/ul[@class='dropdown-menu']//a"));
	  int size=typecolor.size();
	  System.out.println("total size "+size);
	  System.out.println("enter the color u want to pick");
	  Scanner scn1=new Scanner(System.in);
	  a=scn1.nextInt();
	  for(int i=0;i<size;i++){
		  if(a==i){
		  typecolor.get(i).click();
		  }
		  break;
	  }
	 WebDriverWait wait=new WebDriverWait(driver,10);
	 wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.xpath("//div[@class='text-block current_blk']"))));
	  driver.findElement(By.xpath("//div[@class='text-block current_blk']")).click();
	  driver.findElement(By.xpath("//div[@class='text-block current_blk']")).sendKeys("check automate");
	  System.out.println("how many blocks do u want to create plz enter the no");
	  Scanner scn2=new Scanner(System.in);
	  int block=scn2.nextInt();
	  for(int i=1;i<=block;i++){
		  driver.findElement(By.xpath("//h5[@class='add-another']")).click();
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  }
	  List<WebElement> blocks=driver.findElements(By.xpath("//div[@class='text-block current_blk']"));
	  int blocksize=blocks.size();
	  for(int i=1;i<blocksize;i++){
		  WebDriverWait wait1=new WebDriverWait(driver,10);
			 wait1.until(ExpectedConditions.elementToBeClickable(blocks.get(i) ));
		  Actions act=new Actions(driver);
		  act.doubleClick(blocks.get(i)).perform();
		  System.out.println("write something in the block no "+i);
		  Scanner scn3=new Scanner(System.in);
		  String msg=scn3.next();
		  blocks.get(i).sendKeys(msg);
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  }
  }
  @Test
  public void createvideoblock() throws InterruptedException{
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://wordpressmonks.com/works/qarddeck/web/user/register");
	  driver.manage().window().maximize();
	  
	  /************************create a qard*************************************/
	  driver.findElement(By.xpath("//img[contains(@src,'qarddeck/web/images/plus')]")).click();
	  driver.findElement(By.xpath("//h3[text()='Create New Qard']")).click();
	  //select theme
	  System.out.println("select a theme ");
	  System.out.println("the themes are Candy Floss,Dew Drops,Test,Adobe");
	  String s1="//div[div[h4[text()='";
	  String s2="']]]";
	  Scanner scn=new Scanner(System.in);
	  String theme=scn.next();
	  driver.findElement(By.xpath(s1+theme+s2)).click();
	  String x1="html/body/div[";
	  String x2="]/div/a[1]";
	  for(int i=5;i<15;i++){
		  driver.findElement(By.xpath(x1+i+x2)).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  }
	  driver.findElement(By.xpath("//a[text()='Close']")).click();
	  //choose text color
	  driver.findElement(By.xpath("//button[@id='dropdownMenu3']")).click();
	  List<WebElement> typecolor=driver.findElements(By.xpath("//div[@class='dropdown open']/ul[@class='dropdown-menu']//a"));
	  int size=typecolor.size();
	  System.out.println("total size "+size);
	  System.out.println("enter the color u want to pick");
	  Scanner scn1=new Scanner(System.in);
	  a=scn1.nextInt();
	  for(int i=0;i<size;i++){
		  if(a==i){
		  typecolor.get(i).click();
		  }
		  break;
	  }
	          WebDriverWait wait=new WebDriverWait(driver,10);
	          wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.xpath("//div[@class='text-block current_blk']"))));
	          driver.findElement(By.xpath("//div[@class='text-block current_blk']")).click();
	          driver.findElement(By.xpath("//div[@class='text-block current_blk']")).click();
	          driver.findElement(By.xpath("//div[@class='text-block current_blk']")).sendKeys("check automate");
	          System.out.println("how many blocks do u want to create plz enter the no");
	          Scanner scn2=new Scanner(System.in);
	          int block=scn2.nextInt();
	          for(int i=0;i<block;i++){
	          driver.findElement(By.xpath("//h5[@class='add-another']")).click();
		      // driver.findElement(By.xpath("//h5[@class='add-another']")).click();
		      driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		      List<WebElement> blocks=driver.findElements(By.xpath("//div[@class='text-block current_blk']"));
		      Actions act=new Actions(driver);
		      act.doubleClick(blocks.get(i+1)).perform();
              //		  System.out.println("write something in the block no "+i);
              //		  Scanner scn3=new Scanner(System.in);
              //		  String msg=scn3.next();
              //		  blocks.get(i).sendKeys(msg);
		      /**************************click on video icon***************************************/
			  if(i==0)
			  {
		      WebDriverWait visible=new WebDriverWait(driver,10);
		      visible.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@src='/works/qarddeck/web/images/video_icon.png']"))));
		      driver.findElement(By.xpath("//img[@src='/works/qarddeck/web/images/video_icon.png']")).click();
		      //open a new tab
		      act.sendKeys(Keys.chord(Keys.CONTROL,"t")).perform();
		      driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		      String wid=driver.getWindowHandle();
		      driver.switchTo().window(wid);
		      driver.get("https://www.youtube.com");
		      /*********************get the trending link************************/
		      List<WebElement> trendlink=driver.findElements(By.xpath("//div[div[div[h2[a[contains(@class,'yt-uix-sessionlink branded')]//span[text()='Trending']]]]]//img"));
			  trendlink.get(i).click();
			  //  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  /***************************Scroll up*********************************/
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
			  jse.executeScript("window.scrollBy(0,-250)", "");
			  WebDriverWait waitshare=new WebDriverWait(driver,10);
			  waitshare.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("html/body/div[2]/div[4]/div/div[5]/div[2]/div[2]/div/div[2]/div[1]/div[3]/div[1]/button"))));
			  driver.findElement(By.xpath("html/body/div[2]/div[4]/div/div[5]/div[2]/div[2]/div/div[2]/div[1]/div[3]/div[1]/button")).click();
			  driver.findElement(By.xpath("//span[text()='Embed']")).click();
			  WebElement code=driver.findElement(By.xpath("//input[@title='Embed code']"));
			  code.sendKeys(Keys.chord(Keys.CONTROL,"c"));
			  driver.navigate().back();
			  act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
			  String pid=driver.getWindowHandle();
			  driver.switchTo().window(pid);
			  WebDriverWait element=new WebDriverWait(driver,10);
			  element.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='embed_code']"))));
			  /*****************enter the code***********************/
			  driver.findElement(By.xpath("//input[@id='embed_code']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
			  driver.findElement(By.xpath("//label[@for='cmn-toggle-57']")).click();
			  Thread.sleep(3000);
		  }
			  else if(i>0)
			  {
			  act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
			  String pid=driver.getWindowHandle();
			  driver.switchTo().window(pid);
			  List<WebElement> trendlink=driver.findElements(By.xpath("//div[div[div[h2[a[contains(@class,'yt-uix-sessionlink branded')]//span[text()='Trending']]]]]//img"));
			  trendlink.get(i).click();
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  driver.findElement(By.xpath("//span[normalize-space(text())='Share']")).click();
			  driver.findElement(By.xpath("//span[text()='Embed']")).click();
			  WebElement code=driver.findElement(By.xpath("//input[@title='Embed code']"));
			  code.sendKeys(Keys.chord(Keys.CONTROL,"c"));
			  driver.navigate().back();
			  act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
			  String pid1=driver.getWindowHandle();
			  driver.switchTo().window(pid1);
			  driver.findElement(By.xpath("//input[@id='embed_code']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
			  driver.findElement(By.xpath("//label[@for='cmn-toggle-57']")).click();
			  Thread.sleep(3000);
				  }
			  }
	  /*****************************color block***********************************/
	  List<WebElement> noblock=driver.findElements(By.xpath("//div[@class='text-block current_blk']"));
	  List<WebElement> blockcolor=new ArrayList<WebElement>(6);
	  for(int i=0;i<noblock.size();i++){
		  Actions act=new Actions(driver);
		  act.doubleClick(noblock.get(i)).perform();
		  driver.findElement(By.xpath("//button[@id='dropdownMenu4']")).click();
		  blockcolor=driver.findElements(By.xpath("//li[@class='color']"));
		  System.out.println("enter the no in between 0-4to make ur block "+i+"colorfull");
		  Scanner sca=new Scanner(System.in);
		  int color=sca.nextInt();
		  blockcolor.get(color).click();
		  
		  
	  }
	} 
} 