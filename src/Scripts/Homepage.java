package Scripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Methods.ERPMtds;

public class Homepage 
{
  
	@BeforeMethod
	public void openERPapp()
	{
		ERPMtds.openbrowser();
		ERPMtds.launchapp();
		ERPMtds.login();
		
	}

	@AfterMethod
	public void closeERPapp()
	{
		ERPMtds.closebrowser();
	}
	
	@Test(priority=1,enabled=false)
	public void TC5Accessstockitem()
	{
        ERPMtds.driver.findElement(By.linkText("Stock Items")).click();
        String caption = ERPMtds.driver.findElement(By.id("ewPageCaption")).getText();
        Assert.assertEquals(caption, "Stock Items");
        
     }
	@Test(priority=2,enabled=false)
	public void TC6AccessCustomerspage()
	{
        ERPMtds.driver.findElement(By.linkText("Customers")).click();
        String caption = ERPMtds.driver.findElement(By.id("ewPageCaption")).getText();
        Assert.assertEquals(caption, "Customers");
        
     }
	@Test(priority=3,enabled=false)
	public void TC9Creatingstockitem() throws InterruptedException
	{
		ERPMtds.stockcreating();
	}
	@Test(priority=4,enabled=false)
	public void TC10creatingstockcategory() throws InterruptedException
	{
		ERPMtds.stockcategory();
	}
	@Test(priority=5,enabled=false)
	public void TC12searchstockitem()
	{
		ERPMtds.stockitemsearch();
	}
	@Test(priority=6,enabled=false)
	public void TC13advancestocksearch()
	{
		ERPMtds.advancestocksearch();
	}
	
	@Test(priority=7)
	public void TC14updatestock() throws InterruptedException
	{
		ERPMtds.updatestockitem();
	}
	
}
