package APPIUM_UDEMY.APPIUM;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class APPIUM_BASICS extends BaseTest {

	@Test
	public void AppiumTest() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"))
				.click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();

		String modalTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(modalTitle, "WiFi settings");
		
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Test Wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

	}

}
