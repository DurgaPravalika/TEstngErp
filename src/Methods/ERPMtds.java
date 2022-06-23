package Methods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ERPMtds 
{
	public static WebDriver driver;	
	public static String url = "http://webapp.qedgetech.com/login.php";
	

	public static void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void launchapp()
	{
		driver.get(url);	

	}
	
	public static void login()
	{
		driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("master");
        driver.findElement(By.id("btnsubmit")).click(); 
        
       String name=driver.findElement(By.id("ewPageCaption")).getText();
        if(name.equals("Dashboard"))
        {
        	System.out.println("Admin login is displayed");
        
        }
        else
        {
        	System.out.println("Admin login is not displayed");
        }
       
	}
	public static void invaliddata(String uname,String pswd) throws InterruptedException
	{
		driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(uname);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(pswd);
        driver.findElement(By.id("btnsubmit")).click();
        
        
      String errmsg=driver.findElement(By.xpath("//div[contains(text(),'Incorrect')]")).getText();
      System.out.println("Alert msg is"+errmsg);
      if(errmsg.contains("Incorrect"))
      {
    	  System.out.println("Invalid crendials, testcase is passed");
      }
      else
      {
    	 System.out.println("Testcase is failed");
      }
      
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
      
	}
	public static void reset()
	{
		driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("master");
        driver.findElement(By.id("btnreset")).click();
        String name=driver.findElement(By.id("username")).getAttribute("value");
        String pwd=driver.findElement(By.id("password")).getAttribute("value");
        if(name.isEmpty()&&pwd.isEmpty())
        {
     	   System.out.println("Reset done successfully");
        }
        else
        {
     	   System.out.println("Reset done unsuccessfully ");
        }

	 }
	public static void stockcreating() throws InterruptedException
	{
		  driver.findElement(By.linkText("Stock Items")).click();
	      
	      driver.findElement(By.xpath("//*[@class='btn btn-default ewAddEdit ewAdd btn-sm']")).click();
	      
	      Select cat=new Select(driver.findElement(By.id("x_Category")));
	      cat.selectByIndex(1);      
	   
	      Select suppnum=new Select(driver.findElement(By.id("x_Supplier_Number")));
	      suppnum.selectByVisibleText("First Supplier");
	      
	      driver.findElement(By.id("x_Stock_Name")).sendKeys("Samsungphones");
	      
	      Select unit=new Select(driver.findElement(By.id("x_Unit_Of_Measurement")));
	      unit.selectByVisibleText("Acceleration");
	     	      
	      driver.findElement(By.name("x_Purchasing_Price")).sendKeys("20000");
	      
	      driver.findElement(By.name("x_Selling_Price")).sendKeys("25000");
	      
	      driver.findElement(By.name("x_Notes")).sendKeys("First class products");
	      
	      driver.findElement(By.id("btnAction")).click();
	      
	      String s=driver.getWindowHandle();
	      System.out.println("current window is "+s);
	      
	      String msg=driver.findElement(By.xpath("//div[contains(text(),'new record')]")).getText();
	      System.out.println("Alert msg is "+msg);
	      Thread.sleep(2000);
	      driver.findElement(By.xpath(("//*[@class='ajs-button btn btn-primary']"))).click();
	      
	      
	      String Msg=driver.findElement(By.xpath(("//*[@class='alert alert-success ewSuccess']"))).getText();
	      System.out.println("Alert message is "+Msg);
	      
	      driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	 
	}
	public static void stockcategory() throws InterruptedException
	{
		    Actions act=new Actions(driver);
	        WebElement stockitems=driver.findElement(By.id("mi_a_stock_items"));
	        act.moveToElement(stockitems).build().perform();
	        
	        
	        Actions act1=new Actions(driver);
	        WebElement cat=driver.findElement(By.id("mi_a_stock_categories"));
	        act1.moveToElement(cat);
	        cat.click();
	        
	        driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-plus ewIcon']")).click();
	        
	        driver.findElement(By.name("x_Category_Name")).sendKeys("phones");
	        driver.findElement(By.id("btnAction")).click();
	        
	        String msg=driver.findElement(By.xpath("//div[text()='Add new record?']")).getText();
	        System.out.println("message is "+msg );
	        
	        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
	        
	        String Alertmsg=driver.findElement(By.xpath("//*[@class='alert alert-success ewSuccess']")).getText();
	        System.out.println("Alertmsg is "+Alertmsg);
	        
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
	        
	}
	public static void stockitemsearch()
	{
        driver.findElement(By.linkText("Stock Items")).click();
        
        driver.findElement(By.xpath(("//*[@class='btn btn-default ewSearchToggle']"))).click();
        driver.findElement(By.name(("psearch"))).sendKeys("mobiles");
        driver.findElement(By.id("btnsubmit")).click();
        
        WebElement stocktable;
        //stocktable=driver.findElement(By.id("elh_a_stock_items_Stock_Name"));
        stocktable=driver.findElement(By.id("gmp_a_stock_items"));

        List<WebElement> rows,cols;
        rows=driver.findElements(By.tagName("tr"));
        int rowsize=rows.size();
        System.out.println("size of row is" +rowsize);
        cols = rows.get(5).findElements(By.tagName("td"));
		int colsize=cols.size();
		System.out.println("size of coloumns is" +colsize);
        for(int i=1;i<rows.size();i++)
		{
			cols = rows.get(i).findElements(By.tagName("td"));
			
			for(WebElement element : cols)
			{
				String data = element.getText();
				System.out.print(data+"   ");
			}
			System.out.println();
		}
        
	}
	public static void advancestocksearch()
	{
		driver.findElement(By.linkText("Stock Items")).click();
        driver.findElement(By.xpath("//*[@class='icon-advanced-search ewIcon']")).click();
        
        Select cat=new Select(driver.findElement(By.id("z_Category")));
        cat.selectByValue("=");
        Select catvalue=new Select(driver.findElement(By.id("x_Category")));
        catvalue.selectByVisibleText("mobiles");
        
        Select price=new Select(driver.findElement(By.id("z_Purchasing_Price")));
        price.selectByValue("<");
        driver.findElement(By.name("x_Purchasing_Price")).sendKeys("20000");
        
        driver.findElement(By.id("btnAction")).click();
        
        WebElement stocktable=driver.findElement(By.id("fa_stock_itemslist"));
        //driver.findElement(By.id("gmp_a_stock_items"));
        
        List<WebElement> rows,cols;
        rows=driver.findElements(By.tagName("tr"));
        int rowsize=rows.size();
        System.out.println("No.of Rows is" +rowsize);
        cols = rows.get(3).findElements(By.tagName("td"));
		int colsize=cols.size();
		System.out.println("size of coloumns is" +colsize);
        
       for(int i=1;i<rows.size();i++)
        {
        	cols = rows.get(i).findElements(By.tagName("td"));
        	
        	for(WebElement element : cols)
        	{
        		String data=element.getText();
        		System.out.print(data+"   ");
        	}
        	
            System.out.println();
        	
        }
	}
	
	public static void updatestockitem() throws InterruptedException
	{
        driver.findElement(By.linkText("Stock Items")).click();
        
        driver.findElement(By.xpath(("//*[@class='btn btn-default ewSearchToggle']"))).click();
        driver.findElement(By.name(("psearch"))).sendKeys("samsungphones");
        driver.findElement(By.id("btnsubmit")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@data-caption='Edit'])[1]")).click();
       
        driver.findElement(By.name("x_Quantity")).clear();
        driver.findElement(By.name("x_Quantity")).sendKeys("70");
        
        driver.findElement(By.id("btnAction")).click();
        
        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='ajs-button btn btn-primary']")).click();
        
	}

	public static void logout()
	{
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/ul[1]/li[11]/a")).click();

	}
	
	
	public static void closebrowser()
	{
		driver.close();		
	}
	

	


}