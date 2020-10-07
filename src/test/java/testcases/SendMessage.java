package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import methods.Assignment.FatchExcelSheet;
import methods.Assignment.TestMethods;
import methods.Assignment.Utility;

import pageobject.Contact;
import pageobject.Message;

public class SendMessage extends TestMethods{
	static Logger log;
	@BeforeClass
	public static void main(String []args) {
		log = Logger.getLogger(SendMessage.class.getName()); //Logger variable gets initilize.
	}
	
	@DataProvider
	public Object[][] getExcelData() throws InvalidFormatException, IOException{
		return FatchExcelSheet.excelData(System.getProperty("user.dir")+"\\programData.xlsx","Sheet2");	
	}
	@Test(dataProvider = "getExcelData")
	public void SendingMsg(String Name) throws IOException {
		// TODO Auto-generated
		
		service = startServer();
		log.info("server starting again");
		AndroidDriver<AndroidElement> driver = Capabilities("Message");
		log.info("driver gets the capabilities");
		Message msg=new Message(driver);
		Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(Message.homePage));//wait until all the page gets loaded
		Message.getCreateMsgOption().click();//creating msg
		Message.getAddRecipintOption().click();
		log.info("searching  for the recepient");
		Message.getNameObject().click();
		driver.getKeyboard().sendKeys(Name);
		driver.getKeyboard().sendKeys(Keys.ENTER);//sending name
		Message.getMsgEditObject().sendKeys("Hi there,HRY");
		log.info("msg typed");
		Message.getMsgSendObject().click();//msg send
		log.info("msg send");
		service.stop();
	}
}