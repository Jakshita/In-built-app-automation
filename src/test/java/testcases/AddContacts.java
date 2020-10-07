package testcases;
import methods.Assignment.*;
import pageobject.Contact;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import methods.Assignment.*;

import org.testng.Reporter;
import org.testng.annotations.*;
public class AddContacts extends TestMethods {
	static Logger log;
	@BeforeSuite
	public void killAllNodes() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");//to kill the appium server if already running in the local machine
		Reporter.log("Killed all the running server");
	}
	@BeforeClass
	public static void main(String []args) {
		log = Logger.getLogger(AddContacts.class.getName()); //Logger variable gets initilize.
	}
	@DataProvider
	public Object[][] getExcelData() throws InvalidFormatException, IOException{
		return FatchExcelSheet.excelData(System.getProperty("user.dir")+"\\programData.xlsx","Sheet1");	
	}
	@Test(dataProvider = "getExcelData")
	public void ContactAdding(String Name,String workinfo,String phone,String email) throws IOException {
		// TODO Auto-generated method stub
		
		service = startServer();
		
		AndroidDriver<AndroidElement> driver = Capabilities("contact");
		log.info("get the capabilities in the driver");
		//invoking contact pageobject class
		Contact add = new Contact(driver);
		Utility.getWaitDriver(driver).until(ExpectedConditions.presenceOfElementLocated(Contact.homePage));//wait until all the page gets loaded
		Contact.getAddingOption().click();//tapping on the add optiona
		Contact.getEditNumberObject().sendKeys(Name);//sending name of the contact to be added
		driver.hideKeyboard();
		Contact.getWorkInfoObject().click();//taping on tye workinfo
		Contact.getEditWorkInfoObject().sendKeys(workinfo);//sending workinfo
		driver.hideKeyboard();
		Contact.getNumberObject().click();//tapping on number
		Contact.getEditNumberObject().sendKeys(phone);//sending number
		driver.hideKeyboard();
		Contact.getEmailObject().click();//tapping  on email
		Contact.getEditEmailObject().sendKeys(email);//sending email id
		driver.hideKeyboard();
		Contact.getSaveObject().click();
		service.stop();
	}
}