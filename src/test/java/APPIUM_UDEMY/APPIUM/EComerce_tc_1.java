package APPIUM_UDEMY.APPIUM;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EComerce_tc_1 extends BaseTest {

	@Test
	public void FillForm() throws InterruptedException {
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Muhammad Huzaifa");
		driver.hideKeyboard();

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		scrollToElementAction("Belarus");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Belarus']")).click();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		Thread.sleep(2000);

	}

}
