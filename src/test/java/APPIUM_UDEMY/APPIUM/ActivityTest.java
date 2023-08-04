package APPIUM_UDEMY.APPIUM;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class ActivityTest extends BaseTest {

	@Test
	public void AppiumTest() {
		// adb devices
		// adb shell dumpsys window | grep -E 'mCurrentFocus'  ------ Mac
		// adb shell dumpsys window | find "mCurrentFocus"  ------ Windows
		
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();

		String modalTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(modalTitle, "WiFi settings");
		
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Test Wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

	}

}
