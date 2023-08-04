package APPIUM_UDEMY.APPIUM;

import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Miscillaneous extends BaseTest {

	@Test
	public void AppiumTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]"))
				.click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();

		DeviceRotation rotation = new DeviceRotation(0, 0, 90);
		driver.rotate(rotation);
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();

		String modalTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(modalTitle, "WiFi settings");

		driver.setClipboardText("Test Wifi");
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
