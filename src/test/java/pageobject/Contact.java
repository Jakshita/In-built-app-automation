package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Contact {

	public Contact(AndroidDriver<AndroidElement> dr1){
		PageFactory.initElements(new AppiumFieldDecorator(dr1), this);
	}
	
	//by objects for wait
	public static By homePage = By.id("com.samsung.android.app.contacts:id/contact_list_floating_action_button");
		
	@AndroidFindBy(id="com.samsung.android.app.contacts:id/contact_list_floating_action_button")
	public static MobileElement addingOption;
	public static MobileElement getAddingOption() {
		return addingOption;
		
	}
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Name']")
	public static MobileElement editName;
	public static MobileElement getEditName() {
		return editName;
		
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Work info")
	public static MobileElement workInfoObject;
	public static MobileElement getWorkInfoObject() {
		return workInfoObject;
		
	}
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Job title']")
	public static MobileElement editWorkInfoObject;
	public static MobileElement getEditWorkInfoObject() {
		return editWorkInfoObject;
		
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Phone']")
	public static MobileElement numberObject;
	public static MobileElement getNumberObject() {
		return numberObject;
		
	}
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Phone']")
	public static MobileElement editNumberObject;
	public static MobileElement getEditNumberObject() {
		return editNumberObject;
		
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Email']")
	public static MobileElement emailObject;
	public static MobileElement getEmailObject() {
		return emailObject;
		
	}
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email']")
	public static MobileElement editEmailObject;
	public static MobileElement getEditEmailObject() {
		return editEmailObject;
		
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Save']")
	public static MobileElement saveObject;
	public static MobileElement getSaveObject() {
		return saveObject;	
	}
}







