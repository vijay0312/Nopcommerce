package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import data.Reusable;
import elements.Allelements;
import elements.Demopage_Ele;
import elements.Download_Ele;
import elements.Homepage_Ele;
import elements.Loginpage_Ele;
import elements.Registerpage_Ele;

public class SmokeTest extends Basicclass {

	Allelements ele = new Allelements();
	Reusable rf = new Reusable();
	Download_Ele dw = new Download_Ele();
	Loginpage_Ele log = new Loginpage_Ele();
	Homepage_Ele home = new Homepage_Ele();
	Registerpage_Ele reg = new Registerpage_Ele();
	Demopage_Ele demo = new Demopage_Ele();
	Actions act = null;

	@Test(priority = 1)
	public void URL_Check() {
		String Verify_URL = rf.getText_ele(driver, "xpath", ele.Title_xpath);

		if (Verify_URL.equalsIgnoreCase("Free and open-source eCommerce platform")) {
			System.out.println("Free and open-source eCommerce platform website displayed.");
		} else {
			System.out.println("Failed to launch URL");
		}
	}

	@Test(priority = 2)
	public void Login_Page_Check() throws InterruptedException, IOException {
		WebElement Profile_Icon = driver.findElement(By.xpath("//*[@class='ico-user sprite-image']"));
		Actions act = new Actions(driver);
		act.moveToElement(Profile_Icon).perform();
		rf.click_ele(driver, "xpath", home.Login_xpath);
		String Welcome = rf.getText_ele(driver, "xpath", log.Login_page);

		if (Welcome.equalsIgnoreCase("Welcome, Please Sign In!")) {
			System.out.println("Login page is Displayed");
		} else {
			System.out.println("Login page is Not Displayed");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}
}
