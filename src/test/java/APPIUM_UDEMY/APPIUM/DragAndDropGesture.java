package APPIUM_UDEMY.APPIUM;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragAndDropGesture extends BaseTest {

	@Test
	public void AppiumTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

		dragAndDropAction(source);

		Assert.assertEquals(driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText(), "Dropped!");

		Thread.sleep(2000);
	}

}
