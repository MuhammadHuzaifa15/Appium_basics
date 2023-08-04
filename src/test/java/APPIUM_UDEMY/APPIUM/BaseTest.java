package APPIUM_UDEMY.APPIUM;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AppiumDriverLocalService service;
	public AndroidDriver driver;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		int port = 4723;
		String ipAddress = "127.0.0.1";
		String deviceName = "Pixel_3a_API_34";
		String appiumFilePath = "C:\\Users\\User\\AppData\\Roaming\\nvm\\v18.16.1\\node_modules\\appium\\build\\lib\\main.js";

		URL url = new URL("http://" + ipAddress + ":" + port);
		File appiumFileBath = new File(appiumFilePath);

		// Initialize Appium Service
		service = new AppiumServiceBuilder().withAppiumJS(appiumFileBath).withIPAddress(ipAddress).usingPort(port)
				.build();

		// Starting Appium Service
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp("C:\\Users\\User\\eclipse-workspace\\APPIUM\\src\\test\\java\\Resources\\ApiDemos-debug.apk");

		// Loading Testing Application on device
		driver = new AndroidDriver(url, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void longPressAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
	}

	public void scrollToElementAction(String element) {
		driver.findElements(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + element + "\"));"));
	}

	public void scrollToEndAction() {
		boolean scrollable;
		do {
			scrollable = (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (scrollable);
	}

	public void swipeAction(WebElement element, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", direction, "percent", 0.75));
	}

	public void dragAndDropAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", 620, "endY", 560));
	}

	@AfterClass
	public void stop() {

		// Quitting Testing Application on device
		driver.quit();

		// Stopping Appium Service
		service.stop();
	}
}
