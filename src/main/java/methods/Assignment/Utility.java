package methods.Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utility {
	
	public static String getProperty(String s) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\mainMethods\\global.properties");
		Properties properties = new Properties();
		properties.load(file);
		return properties.getProperty(s);
	}
	public static void scrollToText(AndroidDriver driver,String s){
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+s+"\").instance(0))");
	}
	public static WebDriverWait getWaitDriver(AndroidDriver<AndroidElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		return wait;
	}
}
