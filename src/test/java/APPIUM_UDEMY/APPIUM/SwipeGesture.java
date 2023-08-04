package APPIUM_UDEMY.APPIUM;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeGesture extends BaseTest {

	@Test
	public void AppiumTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Photos']")).click();

		WebElement image1 = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(image1.getAttribute("focusable"), "true");

		swipeAction(image1, "left");

		Assert.assertEquals(
				driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),
				"false");

		Thread.sleep(2000);
	}

}
