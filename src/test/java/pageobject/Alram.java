package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Alram {

	public Alram(AndroidDriver<AndroidElement> dr3){
		PageFactory.initElements(new AppiumFieldDecorator(dr3), this);
	}
	//by objects for wait
	public static By homePage = By.className("android.widget.ImageView");
	
	@AndroidFindBy(className="android.widget.ImageView")
	public static MobileElement moreOption;
	public MobileElement getMoreOption() {
		return moreOption;
		
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text]='Delete']")
	public static MobileElement deleteOption;
	public static MobileElement getDeleteOption() {
		return deleteOption;
	}
	@AndroidFindBy(id="com.sec.android.app.clockpackage:id/icon")
	public static MobileElement deleteAlram;
	public static MobileElement getDeleteAlram() {
		return deleteAlram;
	}
	@AndroidFindBy(id="com.sec.android.app.clockpackage:id/add_text")
	public static MobileElement addOpption;
	public static MobileElement getAddOpption() {
		return addOpption;
	}
	@FindBy(className = "com.sec.android.app.clockpackage:id/repeat_btn_group") 
	private static List<MobileElement> daysOption; 
	public static List<MobileElement> getDaysOption() {
		return daysOption;
	}
	@AndroidFindBy(className="android.widget.TextView - Save")
	public static MobileElement alarmSet;
	public static MobileElement getAlarmSet() {
		return alarmSet;
	}
}

































