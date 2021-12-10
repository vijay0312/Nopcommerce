package data;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable {

	public static WebElement ele_properties(WebDriver driver, String locator, String element) {
		WebElement ele = null;
		switch (locator) {
		case "id":
			ele = driver.findElement(By.id(element));
			break;
		case "name":
			ele = driver.findElement(By.name(element));
			break;
		case "xpath":
			ele = driver.findElement(By.xpath(element));
			break;
		case "css":
			ele = driver.findElement(By.cssSelector(element));
			break;
		}
		return ele;
	}

	public void click_ele(WebDriver driver, String locator, String element) {
		if (locator != null) {
			Reusable.wait_for_the_element(driver, locator, element);
			if (Reusable.ele_properties(driver, locator, element).isEnabled()) {
				Reusable.ele_properties(driver, locator, element).click();
			} else {
				System.out.println("Click WebElement is not Enabled");
			}
		} else {
			System.out.println("Click WebElement is not present or null");
		}
	}

	public void sendkeys_ele(WebDriver driver, String locator, String element, String send_value) {
		if (locator != null) {
			Reusable.wait_for_the_element(driver, locator, element);
			if (Reusable.ele_properties(driver, locator, element).isEnabled()) {
				Reusable.ele_properties(driver, locator, element).clear();
				Reusable.ele_properties(driver, locator, element).sendKeys(send_value);
			} else {
				System.out.println("Click WebElement is not Enabled");
			}
		} else {
			System.out.println("Click WebElement is not present or null");
		}
	}

	public String getText_ele(WebDriver driver, String locator, String element) {
		String get_text = null;
		if (locator != null) {
			Reusable.wait_for_the_element(driver, locator, element);
			get_text = Reusable.ele_properties(driver, locator, element).getText();

		} else {
			System.out.println("Click WebElement is not present or null");
		}
		return get_text;
	}

	public static void wait_for_the_element(WebDriver driver, String locator, String element) {
		switch (locator) {
		case "xpath":
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case "id":
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case "css":
			try {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case "name":
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		}
	}

	public static void Login() {

	}
}