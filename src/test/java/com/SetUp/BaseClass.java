package com.SetUp;

import java.io.File;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static  WebDriver driver;
	//public static String chromePath =  System.getProperty("user.dir")+"/chromedriver.exe";
	//DOne by Pranshu
	
	@SuppressWarnings("deprecation")
	public  static void waitForPageToLoad(int timeout)
	{
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		
	}
	
	public  static void wait(int timeout)
	{
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static String getProperty(String PropertyName)
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("config.xml"));
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("root");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					return element.getElementsByTagName(PropertyName).item(0).getTextContent();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "The property not Found";
	}
	
	@SuppressWarnings("deprecation")
	@BeforeClass(alwaysRun = true)
	public  void setUp() {
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory",
                System.getProperty("user.dir") + File.separator + "downloadFiles");
		ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
       WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", chromePath);
//        WebDriverManager.chromedriver().browserVersion("98.0.4758.102").setup();
//        WebDriverManager.chromedriver().driverVersion("98.0.4758.102").setup();
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass(alwaysRun = true)
	public void tearUp()
	{
		driver.quit();
	}
	
	public String decryptData(String encyptedPassword)
	{
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(encyptedPassword);
		String decryptedPassword = new String(decryptedPasswordBytes);
		return decryptedPassword;
	}


}
