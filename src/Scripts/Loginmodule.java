package Scripts;

import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Methods.ERPMtds;

public class Loginmodule 
{
	@BeforeMethod
	public void openERPapp()
	{
		ERPMtds.openbrowser();
		ERPMtds.launchapp();
		
	}

	@AfterMethod
	public void closeERPapp()
	{
		ERPMtds.closebrowser();
	}
	
	@Test(priority=1)
	public void TC1login()
	{
		ERPMtds.login();
	}
	
    @Test(priority=3,enabled=false)
	public void TC2logout()
	{
    	ERPMtds.login();
		ERPMtds.logout();
	}
    
    @Test(priority=2)
    public void TC3invalid() throws InterruptedException
    {
    	ERPMtds.invaliddata("abk", "xyz");
    }
    @Test(priority=4)
    public void TC4Reset()
    {
    	//ERPMtds.reset();
       
       ERPMtds.driver.findElement(By.id("btnreset")).click();
       String name=ERPMtds.driver.findElement(By.id("username")).getAttribute("value");
       String pwd=ERPMtds.driver.findElement(By.id("password")).getAttribute("value");
       Assert.assertTrue(name.isEmpty()&&pwd.isEmpty());
      
    }
}
