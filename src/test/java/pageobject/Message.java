package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Message {
	
	public Message(AndroidDriver<AndroidElement> dr2) {
		PageFactory.initElements(new AppiumFieldDecorator(dr2), this);
	}
	//by objects for wait
	public static By homePage = By.id("com.samsung.android.messaging:id/fab");
	
	@AndroidFindBy(id="com.samsung.android.messaging:id/fab")
	public static MobileElement createMsgOption;
	public static MobileElement getCreateMsgOption() {
		return createMsgOption;
		
	}
	@AndroidFindBy(className="android.widget.ImageView")
	public static MobileElement addRecipintOption;
	public static MobileElement getAddRecipintOption() {
		return addRecipintOption;
	}
	@AndroidFindBy(xpath="//android.widget.EditText [@text='Search Contacts or enter number']")
	public static MobileElement recipientName;
	public static MobileElement getRecipientName() {
		return recipientName;
	}
	@AndroidFindBy(className="android.view.ViewGroup")
	public static MobileElement nameObject;
	public static MobileElement getNameObject() {
		return nameObject;
	}
	@AndroidFindBy(id="com.samsung.android.messaging:id/message_edit_text")
	public static MobileElement msgEditObject;
	public static MobileElement getMsgEditObject() {
		return msgEditObject;
	}
	@AndroidFindBy(id="com.samsung.android.messaging:id/selected_send_button1")
	public static MobileElement msgSendObject;
	public static MobileElement getMsgSendObject() {
		return msgSendObject;
	}
}