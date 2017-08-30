package QardDeck.com;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class check {
	@BeforeClass
	public void bc(){
		System.out.println("Before class");
	}
	@BeforeGroups
	public void bg(){
		System.out.println("Before group");
	}
	@BeforeSuite
	public void bs(){
		System.out.println("Before suite");
	}
	@BeforeTest
	public void configbt(){
		System.out.println("before test");
	}
	@BeforeMethod
	public void configbm(){
		System.out.println("before method");
	}
  @Test
  public void A() {
	  System.out.println(" test a");
  }
  @Test
  public void B(){
	  System.out.println("test b");
  }
  @AfterMethod
  public void configAM(){
	  System.out.println("afetr method");
  }
  @AfterTest
  public void configAT(){
	  System.out.println("after test");
  }
  @AfterClass
	public void ac(){
		System.out.println("after class");
	}
	@AfterGroups
	public void ag(){
		System.out.println("after group");
	}
	@AfterSuite
	public void as(){
		System.out.println("after suite");
	}
}
