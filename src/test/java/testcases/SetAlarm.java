package testcases;
import methods.Assignment.*;
import pageobject.Alram;
import pageobject.Contact;


import java.util.List;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SetAlarm extends TestMethods {
	static Logger log;
	@BeforeClass
	public static void main(String []args) {
		log = Logger.getLogger(AddContacts.class.getName()); //Logger variable gets initilize.
	}
	@Test(priority=1)
	public void deletePreviousAlarm() throws IOException {
		service = startServer();
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities("alarm"); 
		Alram alram = new Alram(driver);
		Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(Contact.homePage));
		alram.getMoreOption().click();
		try {
			if(Alram.getDeleteOption().isEnabled()){
				Alram.getDeleteAlram().click();
				log.info("deleted all the existing alarm");
			}else {
				log.info("No existing alarm");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getExcelData() throws InvalidFormatException, IOException{
		return FatchExcelSheet.excelData(System.getProperty("user.dir")+"\\programData.xlsx","Sheet3");	
	}
	@Test(dataProvider = "getExcelData",priority=2)
	public void addAlarm(String alarmtime,int numberofdays) {
		int i=0;
		Alram.getAddOpption().click();
		Utility.scrollToText(driver, alarmtime);//scrolling till particular alarm time
		
		List<MobileElement>  dayslist = Alram.getDaysOption();
		while(i<numberofdays) {
			dayslist.get(i).click(); //days been selecing
		}
		Alram.getAlarmSet().click();
		service.stop();
	}
}