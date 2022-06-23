package Methods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest 
{
  @BeforeTest
  public void Beforetest() 
  {
	  System.out.println("Testng Started");
  }
  @AfterTest
  public void Aftertest()
  {
	  System.out.println("After test");
  }
  @Test
  public void test()
  {
	  System.out.println("During test");
  }
  @BeforeMethod
  public void Beforemethod() 
  {
	  System.out.println("Before method");
  }
  @AfterMethod
  public void Aftermethod()
  {
	  System.out.println("After method");
  }
  @BeforeClass
  public void Beforeclass() 
  {
	  System.out.println("Before class");
  }
  @AfterClass
  public void Afterclass()
  {
	  System.out.println("After class");
  }
  
  @BeforeSuite
  public void Beforesuite()
  {
	  System.out.println("I am beforesuite");
  }
  @AfterSuite
  public void Aftersuite()
  {
	  System.out.println("I am Aftersuite");
  }
  
 }
  

