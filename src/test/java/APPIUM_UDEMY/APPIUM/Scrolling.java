package APPIUM_UDEMY.APPIUM;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Scrolling extends BaseTest {

	@Test
	public void AppiumTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
//		scrollToElementAction("WebView");
		scrollToEndAction();
		Thread.sleep(2000);
	}

}
