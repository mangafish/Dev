package com.gravitant.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Driver;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.cert.X509Certificate;

import javax.swing.JOptionPane;

import au.com.bytecode.opencsv.CSVReader;

import com.gravitant.test.RunTests;
import com.gravitant.utils.CSV_Reader;

public class Util extends CSV_Reader{
	Logger LOGS =  null;
	RunTests runTest = new RunTests();
	public  WebDriver driver;
	public String filePath = null;
	public String testEnginePath  = null;
	public String testConfigFilePath  = null;
	public String testsToRunFilePath  = null;
	public String fileNameToSearch = null;
	public String objectMapFilePath = null;
	public String testDataFilePath = null;
	public String locator_Type = null;
    public String locator_Value = null;
    public String testDataFileObjectName = null;
    public String[] objectInfo = null;
    public String action = null;
    public String pageName = null;
    public String currentResultsFolderPath = null;
    public String currentResultFilePath = null;
    public String componentAndTestCase = null;
    public String componentAndTestData = null;
    public String componentName = null;
    public String currentTestName = null;
    public String currentFilePath = null;
    public String currentFileName = null;
    public String currentTestStepName = null;
    public String currentPageName = null;
    public String currentTestObjectName = null;
    public String objectMapFileName = null;
    public String testDataFile = null;
    public String testDataFileName = null;
    public String testData = null;
    public String currenDate = null;
    public String currentTime = null;
    public boolean errorFlag = false;
    protected String automatedTestsFolderPath = null;
    protected int globalWaitTime = 0;
    private String ipAddress = null;
    private String portNumber = null;
    private String dbName = null;
    private String dbUsername = null;
    private String dbPassword = null;
    private String environment = null;
    private String browserType = null;
    private String closeBrowser = null;
    private boolean isErrorMessageDisplayed = false;
    int currentTestStepNumber = 0;
    int currentTestStepRow;
    int totalTestNumber = 0;
    int failedStepCounter = 0;
    int failedTestsCounter = 0;
    int screenshotCounter = 0;
    int listItemRow = 0;
    		
	public Util() throws IOException {
		super();
	}
	public void setLogger(){
		LOGS = Logger.getLogger(RunTests.class);
	}
	/**Method gets the location of the exe jar file
	 * @return String - path to the automated tests directory 
	 */
	public String getTestEnginePath(){
		File jarFile = new File(RunTests.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String jarFilePath = jarFile.getAbsolutePath();
		String jarRootDirectoryPath = jarFilePath.replace(jarFile.getName(), "");
		String testConfigDirectory = jarRootDirectoryPath.substring(0, jarRootDirectoryPath.indexOf("TestProject_4.0"));
		this.setTestEnginePath(testConfigDirectory);
		return jarFilePath;
        /*this.setTestEnginePath(jarFilePath);
        return jarFilePath;*/
	}
	public void setTestEnginePath(String path){
		testEnginePath  = path;
	}
	/**Method sets the path to the automated tests directory 
	 * @return null
	 */
	public void setTestDirectoryPath(String path){
		automatedTestsFolderPath  = path;
	}
	public void setGlobalWaitTime(int time){
		globalWaitTime = time;
	}
	public String getComponentAndTestCaseName(String currentLine){
		if(currentLine.contains(",")){
			String[] splitCurrentLine = currentLine.split(",");
			componentAndTestCase = splitCurrentLine[0];
		}else{
			componentAndTestCase = currentLine;
		}
		return componentAndTestCase;
	}
	public String getComponentName(String currentLine){
		String componentAndTestCase = this.getComponentAndTestCaseName(currentLine);
		String[] splitComponentAndTestCase = componentAndTestCase.split("/");
		this.componentName = splitComponentAndTestCase[0];
		return componentName;
	}
	public String getTestCaseName(String currentLine){
		String componentAndTestCase = this.getComponentAndTestCaseName(currentLine);
		String[] splitComponentAndTestCase = componentAndTestCase.split("/");
		this.currentTestName = splitComponentAndTestCase[1];
		return currentTestName;
	}
	public String getTestDataFileName(String currentLine){
		String[] splitCurrentLine = currentLine.split("data=");
		String componentAndTestData = splitCurrentLine[1];
		String[] splitComponentAndTestData = componentAndTestData.split("/");
		String testDataFileName = splitComponentAndTestData[1];
		this.setTestDataFileName(testDataFileName);
		return testDataFileName;
	}
	public void setTestDataFileName(String testDataFileName){
		this.testDataFileName = testDataFileName;
	}
	public String findFile(String parentDirectory, String fileToFind){
		fileToFind = fileToFind.toLowerCase();
		String filePath = null;
		File root = new File(parentDirectory);
		setFileNameToSearch(fileToFind);
		if(root.isDirectory()) {
			filePath = search(root);
		}else {
			LOGS.info(root.getAbsoluteFile() + " is NOT a directory");
		}
		return filePath;
	}
	public List<String> findFiles(String parentDirectory, String stringInFileName){
		List<String> filesToFind = new ArrayList<String>();
		  File dir = new File(parentDirectory);
		  for(File file : dir.listFiles()) {
		    if (file.getName().contains(stringInFileName)) {
		    	filesToFind.add(file.getAbsolutePath());
		    }
		  }
		  return filesToFind;
	}
	private String search(File file){
		String fileToSearch = getFileNameToSearch().trim();
		if(file.isDirectory()){
			for(File temp : file.listFiles()){
				if(temp.isDirectory()){
					search(temp);
				}else{
					if(temp.getName().trim().toLowerCase().equals(fileToSearch)) {	
						this.filePath = temp.getAbsolutePath();
				    }
				}
			}
		}
		return filePath;
	}
	 public void setFileNameToSearch(String fileNameToSearch) {
			this.fileNameToSearch = fileNameToSearch;
	}
	public String getFileNameToSearch() {
		return fileNameToSearch.toLowerCase();
	}
	
	public String findDirectory(String directoryToFind){
		String directoryPath = null;
		File root = new File(this.automatedTestsFolderPath);
        File[] list = root.listFiles();
        for (File f : list) {
            if (f.isDirectory() && f!=null){
            	File[] filesInFolder = f.listFiles();
            	if(Arrays.toString(filesInFolder).contains(directoryToFind)){
            		directoryPath =f.getAbsolutePath() + "\\" + directoryToFind;
            	}
            }
        }
		return directoryPath;
	}
	
	public void setTestConfigFilePath(String testConfigPath){
		testConfigFilePath  = testConfigPath;
	}
	/**Method gets the value for the specified test property from 
	 * Test_Config.txt
	 * @return String property value
	 * @throws IOException
	 */
	public String getTestConfigProperty(String property) throws IOException{
		String testConfigFilePath = this.findFile(this.testEnginePath, "Test_Config.txt");
		BufferedReader readTestConfigFile = new BufferedReader(new FileReader(testConfigFilePath));
		String currentline = null;
		String propertyValue = null;
	    while((currentline = readTestConfigFile.readLine()) != null) {
	    	if(currentline.toLowerCase().contains(property.toLowerCase())){
	    		String[] split = currentline.split("=");
	    		propertyValue = split[1];
	    		break;
	    	}
	    }
		//System.out.println(propertyValue);
	    readTestConfigFile.close();
	    this.setTestConfigProperty(property, propertyValue);
		return propertyValue;
	}
	public void setTestConfigProperty(String property, String propertyValue) throws IOException{
		switch (property){
			case "environment":
				this.environment = 	propertyValue;
				break;
			case "browserType":
				this.browserType = 	propertyValue;
				break;
			case "automatedTestsFolderPath":
				this.automatedTestsFolderPath = propertyValue;
				break;
			case "globalWaitTime":
				this.globalWaitTime = Integer.parseInt(propertyValue);
				break;
			case "closeBrowser":
				this.closeBrowser = propertyValue;
				break;
			case "ipAddress":
				this.ipAddress = propertyValue;
				break;
			case "portNumber":
				this.portNumber = propertyValue;
				break;
			case "dbName":
				this.dbName = propertyValue;
				break;
			case "dbUsername":
				this.dbUsername = propertyValue;
				break;
			case "dbPassword":
				this.dbPassword = propertyValue;
				break;
		}
	}
	/**Method gets the list of all tests specified in
	 * Tests_To_Run.txt
	 * @return ArrayList of tests to run
	 * @throws IOException
	 */
	public List<String> getTestsToRun() throws IOException{
		String testsToRunPath = this.findFile(this.testEnginePath, "TestsToRun.txt");
		BufferedReader readTestsToRunFile = new BufferedReader(new FileReader(testsToRunPath));
		String currentline = null;
		List<String> testsToRun = new ArrayList<>();
	    while((currentline = readTestsToRunFile.readLine()) != null) {
	    	//System.out.println(currentline);
	    	testsToRun.add(currentline);
	    }
	    readTestsToRunFile.close();
		return testsToRun;
	}
	/**
	 * Method verifies the test case listed in Tests_To_Run.txt exists in
	 * the Test_Cases folder.
	 * @param testName
	 * @return boolean
	 */
	public boolean verifyTestCaseExists(String testName){
		boolean testCaseExists = false;
		String testCasePath = this.findFile(this.automatedTestsFolderPath + "\\Test_Cases", testName + ".csv");
		if(!testCasePath.equals(null) && testCasePath.contains(testName)){
       		testCaseExists = true;
       	}else{
       		testCaseExists = false;
       	}
		return testCaseExists;
	}
	public boolean verifyFileExists(String directoryName, String fileName){
		boolean fileExists = false;
		String filePath = this.findFile(this.automatedTestsFolderPath + "\\" + directoryName, fileName + ".csv");
		if(!filePath.equals(null) && filePath.contains(fileName)){
			fileExists = true;
       	}else{
       		fileExists = false;
       		this.setErrorFlag(true);
       		LOGS.info("File: " + fileName +  " does not exist in " + directoryName + " folder");
       	}
		return fileExists;
	}
	public int getRowCount(List<?> testCaseContent) throws IOException{
		int numberOfRows = 0;
		for (Object object : testCaseContent){
			numberOfRows++;
		 }
		return numberOfRows;
	}
	
	public String setCurrentTestName(String currentTest){
		currentTestName = currentTest;
		return currentTestName;
	}
	public String setCurrentResultFolderPath(String folderPath){
		currentResultsFolderPath = folderPath;
		return currentResultsFolderPath;
	}
	public String setCurrentResultFilePath(String filePath){
		currentResultFilePath = filePath;
		return currentResultFilePath;
	}
	public String setCurrentResultFileName(String fileName){
		currentFileName = fileName;
		return currentFileName;
	}
	public String setCurrentTestStep(String testStepName){
		currentTestStepName = testStepName;
		return currentTestStepName;
	}
	public int setCurrentTestStepNumber(int stepNumber){
		currentTestStepNumber = stepNumber;
		return currentTestStepNumber;
	}
	public String setCurrentPageName(String pageName){
		currentPageName = pageName;
		return currentPageName;
	}
	public String setCurrentTestObjectName(String objectName){
		currentTestObjectName = objectName;
		return currentTestObjectName;
	}
	public void setTotalTestNumber(){
		totalTestNumber++;
	}
	public void setCurrentDate(String currentDate){
		this.currenDate = currentDate;
	}
	public void setCurrentTime(String currentTime){
		this.currentTime = currentTime;
	}
	
	/**
	 * Method returns path to the test case in Tests_Cases folder
	 * @param testName
	 * @return String path to test case.
	 */
	public String getTestCasePath(String testCaseName){
		String testCasePath = this.findFile(this.automatedTestsFolderPath + "\\" + componentName, testCaseName + ".csv");
		return testCasePath;
	}
	/**
	 * Method reads the 'Page' column in the test case CSV file and
	 * returns the filename in Object_Map folder where the object's properties are stored.
	 * @param page ame
	 * @return object map filename
	 * @throws IOException 
	 */
	public String getObjectMapFilePath(String pageName) throws IOException{
		objectMapFilePath = this.findFile(this.automatedTestsFolderPath + "\\Test_Objects", pageName + ".csv");
		return objectMapFilePath;
	}
	
	public String findObjectMapFile(ArrayList<String> objectMapFileNames, File[] objectMapsList ){
		String objectMapFileName = null;
		for(int j=0; j<objectMapFileNames.size(); j++){
			objectMapFileName = objectMapFileNames.get(j) + ".csv";
			//System.out.println(objectMapFileName);
			for(int k=0;k<objectMapsList.length;k++){
				//System.out.println(objectMapsList[k].getName());
				if(objectMapsList[k].getName().equals(objectMapFileName)){
					//System.out.println(objectMapFileName);
					break;
				}
			}
		}
		return objectMapFileName;
	}
	
	public String[] getObjectInfo(String pageName, String objectName) throws Exception{
		objectMapFileName = this.getObjectMapFilePath(pageName);
		String[] objectInfo = null;
		CSVReader objectMapFileReader = new CSVReader(new FileReader(objectMapFileName));
        String [] objectRow = null;
        while((objectRow = objectMapFileReader.readNext()) != null){
        	if(!objectRow[0].equals("Object_Name") && objectRow[0].equals(objectName)){
        		objectInfo = objectRow;
        		break;
        	}else{
        		objectInfo = null;
        	}
        }
        objectMapFileReader .close();
		return objectInfo;
	}
	
	public String getObjectLocatorType(String[] objectInfo){
		//System.out.println(Arrays.toString(objectInfo));
		String locator_Type = null;
		if(Arrays.toString(objectInfo).equals("") || Arrays.toString(objectInfo).contentEquals("null")){
			locator_Type = null;
		}else{
			locator_Type = objectInfo[1];
		}
		return locator_Type;
	}
	
	public String getObjectLocatorValue(String[] objectInfo){
		String locator_Value = null;
		if(Arrays.toString(objectInfo).equals("") || Arrays.toString(objectInfo).contentEquals("null")){
			locator_Value = null;
		}else{
			locator_Value = objectInfo[2];
		}
		return locator_Value;
	}
	
	public boolean findIfDataTest(List<String[]> testCaseContent){
		boolean isDataTest = false;
		String[] testStepRow = null;
		for(int k=0;  k<testCaseContent.size(); k++){
    		testStepRow = testCaseContent.get(k);
    		if(testStepRow[4].equals("begin_dataTest")){
    			isDataTest = true;
    			break;
    		}
    	}
		return isDataTest;
	}
	public int getRowNumber(List<String[]> testCaseContent, String value){
		int rowNumber =0;
		String[] testStepRow = null;
		for(int k=0;  k<testCaseContent.size(); k++){
    		testStepRow = testCaseContent.get(k);
    		if(testStepRow[4].equals(value)){
    			rowNumber = k;
    			break;
    		}
    	}
		return rowNumber;
	}
	/**
	 * Method reads the 'Page' column in the test case CSV file and
	 * returns the filename in Test_Data folder where the page's test data is stored.
	 * @param page name
	 * @return test data file path
	 * @throws IOException 
	 */
	public String getTestDataFilePath(String pageName) throws IOException{
		this.testDataFilePath = this.findFile(this.automatedTestsFolderPath + "\\" + this.componentName, pageName + ".csv");
		return testDataFilePath;
	}
	
	/*public void setTestDataFilePath(String path){
		automatedTestsFolderPath  = path;
	}*/
	public String getTestData(String objectName) throws Exception{
		String testData = null;
		if(objectName.length()<1){
			this.testData = testData;
		}else{
			if(this.verifyFileExists(componentName, testDataFileName)==true){
		    	CSVReader testDataFileReader = new CSVReader(new FileReader(this.getTestDataFilePath(testDataFileName)));
		        String[] testDataRow = null;
		        while((testDataRow = testDataFileReader.readNext())!= null){
		        	this.testDataFileObjectName = testDataRow[0];
		        	if(!testDataFileObjectName.equals("Object_Name") && testDataFileObjectName.equals(objectName)){
		       			this.testData = testDataRow[1];
		       			if(testData!=null && testData.substring(0,1).equals("\"")){
		       				this.testData = testData.replaceAll("\""," ").trim();
			        		//System.out.println(testData);
			        	}
		    			break;
		        	}else{this.testData = testData;}
		        }
		        testDataFileReader.close();
			}
		}
		return this.testData;
	}
	public String getTestData(String pageName, String objectName, int dataTestIteration) throws Exception{
		testDataFileName = this.getTestDataFilePath(pageName);
    	CSVReader testDataFileReader = new CSVReader(new FileReader(testDataFileName));
        String[] testDataRow = null;
        while((testDataRow = testDataFileReader.readNext()) != null){
        	//System.out.println("Data test item number: " + testDataRow[dataTestIteration]);
        	testDataFileObjectName = testDataRow[0];
        	if(!testDataFileObjectName.equals("Object_Name") && testDataFileObjectName.equals(objectName) && !testDataRow[dataTestIteration].equals("null")){
       			testData = testDataRow[dataTestIteration];
    			break;
        	}
        }
        testDataFileReader.close();
		return testData;
	}
	public ArrayList<String> getDataTestData(String pageName, String objectName) throws Exception{
		ArrayList<String> dataTestData =  new ArrayList<String>();
		//System.out.println(dataTestData);
		testDataFileName = this.getTestDataFilePath(pageName);
    	CSVReader testDataFileReader = new CSVReader(new FileReader(testDataFileName));
        String[] testDataRow = null;
        while((testDataRow = testDataFileReader.readNext()) != null){
        	testDataFileObjectName = testDataRow[0];
        	if(!testDataFileObjectName.equals("Object_Name") && testDataFileObjectName.equals(objectName)){
        		for(int i=1;i<testDataRow.length;i++){
        			//System.out.println(testDataRow[i]);
        			dataTestData.add(testDataRow[i]); 
        		}
    			break;
        	}
        }
        testDataFileReader.close();
		return dataTestData;
	}
	public void executeAction(String pageName, String objectName, String action) throws Exception{
		if(objectName.contains("[") && isErrorMessageDisplayed==true){
			String[] objectNames = objectName.replace("[", "").replace("]", "").split(",");
			String[] actions = action.replace("[", "").replace("]", "").split(",");
			for(int i=0;i<=objectNames.length-1;i++){
				testData = this.getTestData(objectNames[i]);
				objectInfo = this.getObjectInfo(pageName, objectNames[i]);
				locator_Type = this.getObjectLocatorType(objectInfo); 
				locator_Value = this.getObjectLocatorValue(objectInfo);
				this.getAction(objectNames[i], actions[i], testData);
			}
	    }else{
	    	testData = this.getTestData(objectName);
	    	objectInfo = this.getObjectInfo(pageName, objectName);
			locator_Type = this.getObjectLocatorType(objectInfo);
			locator_Value = this.getObjectLocatorValue(objectInfo);
	    	this.getAction(objectName, action, testData);
	    }
	}
	public void getAction(String objectName, String action, String testData) throws Exception{
		switch(action.toLowerCase()){
				case "clickbutton":
					LOGS.info("> Clicking button: " + objectName + " on " + this.currentPageName);
					clickButton(locator_Type, locator_Value);
					break;
				case "clickbuttonwithtext":
					LOGS.info("> Clicking button: " + objectName + " on " + this.currentPageName);
					clickButtonWithText(testData);
					break;
				case "typeinput":
					LOGS.info("> Entering text in: " + objectName + " on " + this.currentPageName);
					enterText(locator_Type, locator_Value, testData);
					break;
				case "re-typeinput":
					LOGS.info("> Entering text in: " + objectName + " on " + this.currentPageName);
					reEnterText(locator_Type, locator_Value);
					break;
				case "clicklink":
					LOGS.info("> Clicking link: " + objectName + " on " + this.currentPageName);
					clickLink(locator_Type, locator_Value);
					break;
				case "selectlistitem":
					LOGS.info("> Selecting combo item: " + "\"" + testData + "\"" + " in " + objectName);
					selectListBoxItem(locator_Type, locator_Value, testData);
					break;
				case "selectradiobuttonitem":
					LOGS.info("> Selecting radio item: " + testData + " in " + objectName);
					//selectRadioButtonItem(locator_Type, locator_Value, testData);
					clickRadioButtonItem(locator_Type, locator_Value, testData);
	  				break;
				case "switchtopopup":
					LOGS.info("> Switching to popup" );
					switchToPopup();
					break;
				case "closepopup":
					LOGS.info("> Closing popup" );
					closePopup();
					break;
				case "switchtomainwindow":
					LOGS.info("> Closing popup" );
					switchToMainWindow();
					break;
				case "getmainwindowhandle":
					LOGS.info("> Getting main window handle");
					getMainWindowHandle();
					break;
				case "verifytextpresent":
					LOGS.info("> Verifying text displays: " + testData);
					verifyTextPresent(locator_Type, locator_Value, testData);
					break;
				case "verifytextnotpresent":
					LOGS.info("> Verifying text DOES NOT display: " + testData);
					verifyTextNotPresent(locator_Type, locator_Value, testData);
					break;
				case "wait":
					LOGS.info("> Waiting for: " + testData + " seconds");
					waitForObject(testData);
					break;
				case "scrolldown":
					LOGS.info("> Scrolling down");
					scrollDown();
					break;
				case "savescreenshot":
					LOGS.info("> Capturing screenshot of: "  + this.currentPageName);
					captureScreen(pageName);
					break;
				case "getcelldata":
					LOGS.info("> Getting cell data");
					getCellData(locator_Type, locator_Value);
					break;
				case "clickmenuitem":
					LOGS.info("> Clicking menu item: " + objectName + " on " + this.currentPageName);
					clickMenuItem(locator_Type, locator_Value);
					break;
				case "clicklistmenuitem":
					LOGS.info("> Clicking menu item: " + objectName + " on " + this.currentPageName);
					clickListMenuItem(locator_Type, locator_Value, testData);
					break;
				case "savefile":
					LOGS.info("> Saving file");
					saveFile();
					break;
				case "checkcheckbox":
					LOGS.info("> Checking check box on " + this.currentPageName);
					checkCheckBox(locator_Type, locator_Value);
					break;
				case "uncheckcheckbox":
					LOGS.info("> Un-checking check box on " + this.currentPageName);
					unCheckCheckBox(locator_Type, locator_Value);
					break;
				case "getactivationcode":
					LOGS.info("> Getting value from Database");
					getActivationCode(locator_Type, locator_Value,testData);
					break;
				case "getdbvalue":
					LOGS.info("> Getting value from Database");
					getDbValue(testData);
					break;
				case "getdbvalues":
					LOGS.info("> Getting value from Database");
					getDbValues(testData);
					break;
				case "pastevaluefromclipboard":
					LOGS.info("> Pasting value from clipboard");
					pasteValueFromClipboard(locator_Type, locator_Value);
					break;
				case "gottohomepagefromlink":
					LOGS.info("> Clicking Home link");
					gotToHomePageFromLink();
					break;
				case "gottohomepagefromlogo":
					LOGS.info("> Clicking Logo");
					gotToHomePageFromLogo();
					break;
				case "opensupportpopup":
					LOGS.info("> Clicking Logo");
					openSupportPopup();
					break;
				case "gotoprofilepage":
					LOGS.info("> Clicking Logo");
					goToProfilePage();
					break;
				case "openhelppopup":
					LOGS.info("> Clicking Logo");
					openHelpPopup();
					break;
				case "logout":
					LOGS.info("> Clicking Logo");
					logout();
					break;
				case "checkiferrormessagedisplays":
					LOGS.info("> Checking if error message displays on " + this.currentPageName);
					checkIfErrorMessageDisplays(locator_Type, locator_Value,testData);
					break;
				case "changepassword":
					LOGS.info("> Clicking Logo");
					changePassword(testData);
					break;
			}
	}

	public void waitForObject(String time) throws Exception{
		int seconds = Integer.parseInt(time);
		Thread.sleep(seconds *1000);
	}
	
	public boolean waitForObject(String objectName, String objectLocatorType, String locatorValue) throws IOException{
		WebDriverWait wait = new WebDriverWait(driver, this.globalWaitTime);
		boolean objectExists = false;
		try{
			  wait.until(ExpectedConditions.presenceOfElementLocated(findObject(objectLocatorType, locatorValue)));
			  objectExists = true;
		}catch(StaleElementReferenceException ser){
			System.out.println("Attempting to recover from StaleElementReferenceException");
	        return waitForObject(objectName, objectLocatorType, locatorValue);
			//objectExists = false;
		}catch(NoSuchElementException nse){
			nse.printStackTrace();
			objectExists = false;
		}catch(Exception e){
			e.printStackTrace();
			this.setErrorFlag(true);
	    	LOGS.info(objectName  + " is not displayed or has changed position");
	    	LOGS.info(e.getMessage());
			this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, objectName + " is not displayed or has changed position."));
			this.captureScreen(this.currentTestName);
	    	this.msgbox("Cannot find: " + objectName + "\n Timeout limit reached.");
		}
		return objectExists;
	}
	public boolean waitForObject(WebElement object) throws IOException{
		WebDriverWait wait = new WebDriverWait(driver, this.globalWaitTime);
		boolean objectExists = false;
		try{
			  wait.until(ExpectedConditions.visibilityOf(object));
			  objectExists = true;
		}catch(StaleElementReferenceException ser){
			System.out.println("Attempting to recover from StaleElementReferenceException");
	        return  waitForObject(object);
			//objectExists = false;
		}catch(NoSuchElementException nse){
			nse.printStackTrace();
			objectExists = false;
		}catch(Exception e){
			e.printStackTrace();
			this.setErrorFlag(true);
	    	LOGS.info(object  + " is not displayed or has changed position");
	    	LOGS.info(e.getMessage());
			this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, object + " is not displayed or has changed position."));
			this.captureScreen(this.currentTestName);
	    	this.msgbox("Cannot find: " + object + "\n Timeout limit reached.");
		}
		return objectExists;
	}
	public void waitForSelectBoxOption() throws IOException, InterruptedException{
		int sleepTime = 2000;
		boolean objectExists = false;
		while(sleepTime<this.globalWaitTime){
			Thread.sleep(sleepTime);
			sleepTime = sleepTime*2;
		}
	}
	public boolean setErrorFlag(boolean errorFlag){
		return this.errorFlag = errorFlag;
	}
	public boolean getErrorFlag(){
 		return this.errorFlag;
	}
	public void clickButton(String objectLocatorType, String locatorValue) throws IOException{
		if(waitForObject("Button", objectLocatorType, locatorValue) == true){
			WebElement button = driver.findElement(findObject(objectLocatorType, locatorValue));
			((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", button);
		}
	}
	public void clickButtonWithText(String buttonText) throws IOException, InterruptedException{
		Thread.sleep(3000);
		String trimBtnText = buttonText.trim().replaceAll("[\\p{C}\\p{Z}]", "");
		List<WebElement> labels = driver.findElements(By.tagName("label")); 
		for(WebElement label:labels){
			String labelText  = label.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "");
			//System.out.println(label.getText().trim().replaceAll("[\\p{C}\\p{Z}]", ""));
			if(labelText.equals(trimBtnText)){
				if(waitForObject(label)==true){
					((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", label);
					break;
				}
		  }  
		} 
	}
	public void clickLinkWithText(String objectLocatorType, String locatorValue, String buttonText) throws IOException{
		List<WebElement> links = driver.findElements(By.tagName("a")); 
		for(WebElement link:links){
			//System.out.println(label.getText());
			if(link.getText().equals(buttonText)){
				((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", link);
		  } 
		} 
	}
	public void gotToHomePageFromLink() throws IOException, InterruptedException{
		Thread.sleep(2000);
		List<WebElement> links = driver.findElements(By.tagName("a")); 
		for(WebElement link:links){
			//String linkText = link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "");
			//System.out.println(link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", ""));
			if(link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "").equals("Home")){
				((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", link);
				break;
		  } 
		} 
	}
	public void gotToHomePageFromLogo() throws IOException, InterruptedException{
		Thread.sleep(2000);
		List<WebElement> images = driver.findElements(By.xpath("//a/img"));  
		for(WebElement image:images){
			if(waitForObject(image)==true){
				if(image.getAttribute("src").contains("logo")){
					((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", image);
					break;
				}
			}
		} 
	}
	public void openSupportPopup() throws IOException, InterruptedException{
		Thread.sleep(2000);
		List<WebElement> links = driver.findElements(By.tagName("a")); 
		for(WebElement link:links){
			String linkText = link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "");
			//System.out.println(link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", ""));
			if(link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "").equals("Support")){
				((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", link);
				break;
		  } 
		} 
	}
	public void openHelpPopup() throws IOException, InterruptedException{
		Thread.sleep(2000);
		List<WebElement> links = driver.findElements(By.tagName("a")); 
		for(WebElement link:links){
			String linkText = link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "");
			//System.out.println(link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", ""));
			if(link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "").equals("Help")){
				((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", link);
				break;
		  } 
		} 
	}
	public void goToProfilePage() throws IOException, InterruptedException{
		Thread.sleep(2000);
		List<WebElement> links = driver.findElements(By.tagName("a")); 
		for(WebElement link:links){
			//String linkText = link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "");
			//System.out.println(link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", ""));
			if(link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "").equals("Profile")){
				((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", link);
				break;
		  } 
		} 
	}
	public void logout() throws IOException, InterruptedException{
		Thread.sleep(2000);
		List<WebElement> links = driver.findElements(By.tagName("a")); 
		for(WebElement link:links){
			//String linkText = link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "");
			//System.out.println(link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", ""));
			if(link.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "").equals("Logout")){
				((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", link);
				break;
		  } 
		} 
	}
	public static class DummyTrustmanager implements X509TrustManager {
		  public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException{
		    // do nothing
		  }
		  public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException{
		    // do nothing
		  }
		  public X509Certificate[] getAcceptedIssuers(){
		    return new java.security.cert.X509Certificate[0];
		  }
	}
	public static class MySSLSocketFactory extends SSLSocketFactory{
		  private SSLSocketFactory socketFactory;
		  public MySSLSocketFactory(){
		    try {
		      SSLContext ctx = SSLContext.getInstance("TLS");
		      ctx.init(null, new TrustManager[]{ new DummyTrustmanager()}, new SecureRandom());
		      socketFactory = ctx.getSocketFactory();
		      System.out.println("Socket created");
		    } catch ( Exception ex ){ 
		    	ex.printStackTrace(System.err);  
		    }
		  }
		  public static SocketFactory getDefault(){
			System.out.println("[acquiring the default socket factory]");
		    return new MySSLSocketFactory();
		  }
		  @Override
		  public String[] getDefaultCipherSuites(){
		    return socketFactory.getDefaultCipherSuites();
		  }
		  @Override
		  public String[] getSupportedCipherSuites(){
		    return socketFactory.getSupportedCipherSuites();
		  }
		  @Override
		  public Socket createSocket(Socket socket, String string, int i, boolean bln) throws IOException{
			  System.out.println("[creating a custom socket (method 2)]");
		    return socketFactory.createSocket(socket, string, i, bln);
		  }
		  @Override
		  public Socket createSocket(String string, int i) throws IOException, UnknownHostException{
			  System.out.println("[creating a custom socket (method 3)]");
		    return socketFactory.createSocket(string, i);
		  }
		  @Override
		  public Socket createSocket(String string, int i, InetAddress ia, int i1) throws IOException, UnknownHostException{
			  System.out.println("[creating a custom socket (method 4)]");
		    return socketFactory.createSocket(string, i, ia, i1);
		  }
		  @Override
		  public Socket createSocket(InetAddress ia, int i) throws IOException{
			  System.out.println("[creating a custom socket (method 5)]");
		    return socketFactory.createSocket(ia, i);
		  }
		  @Override
		  public Socket createSocket(InetAddress ia, int i, InetAddress ia1, int i1) throws IOException{
			  System.out.println("[creating a custom socket (method 6)]");
		    return socketFactory.createSocket(ia, i, ia1, i1);
		  }
		}
	public void changePassword(String testData)throws NamingException, NoSuchAlgorithmException, KeyManagementException, IOException, InterruptedException{
		String cleanTestData = testData.replaceAll("[()]","");
		String[] data = cleanTestData.split(",");
		String adminPassword = data[0];
		String userId = data[1];
		String oldPassword = data[2];
		String newPassword = data[3];
		String url = this.environment.substring(8);
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		prop.put(Context.PROVIDER_URL, "ldaps://" + url + ":636/");
		prop.put(Context.REFERRAL, "follow");
		prop.put(Context.SECURITY_PROTOCOL, "ssl");
		prop.put(Context.SECURITY_AUTHENTICATION, "simple");
		prop.put(Context.SECURITY_PRINCIPAL, "cn=root");
		prop.put(Context.SECURITY_CREDENTIALS, adminPassword);
		prop.put("java.naming.ldap.factory.socket", MySSLSocketFactory.class.getName());
		try{
		  SearchControls searchControls = new SearchControls();
		  searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
	      InitialDirContext initialContext = new InitialDirContext(prop); // Create the initial directory context
	      DirContext contx = (DirContext)initialContext;
	         
	      if(userId.contains("cm-mm-admin") || newPassword.length()<1){
	    	  LOGS.warn("Sorry, cannot change password for Market Maker and/or new password cannot be empty");
	      }else{
	    	  ModificationItem[] mods = new ModificationItem[2];
		      mods[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE, new BasicAttribute("userPassword", oldPassword));
		      mods[1] = new ModificationItem(DirContext.ADD_ATTRIBUTE, new BasicAttribute("userPassword", newPassword));

		      String theUserName="uid=" + userId + ", OU=users, DC=qa10, DC=mygravitant, DC=com";
	 	      contx.modifyAttributes(theUserName, mods);
		      LOGS.info("Changed Password for user: " +  userId + " successfully");
		      contx.close();
	      }
		}catch(Exception e){
	       e.printStackTrace();
	    }
	}
	public String getCellData(String objectLocatorType, String locatorValue){
		String cellData = null;
		WebElement table = driver.findElement(findObject(objectLocatorType, locatorValue));
		List<WebElement> rows  = table.findElements(By.tagName("tr")); //find all tags with 'tr' (rows)
		System.out.println("Total Rows: " + rows.size()); //print number of rows
		for (int rowNum=0; rowNum<rows.size(); rowNum++) {
			List<WebElement> columns  = table.findElements(By.tagName("td")); //find all tags with 'td' (columns)
			System.out.println("Total Columns: " + columns.size()); //print number of columns
			 for (int colNum=0; colNum<columns.size(); colNum++){
				System.out.print(columns.get(colNum).getText() + " -- "); //print cell data
			}
			System.out.println();
		}
		return cellData;
	}
	public void clickListMenuItem(String objectLocatorType, String locatorValue, String listItem) throws InterruptedException, IOException{
		String webTableXpath = null;
		String xpathSubString = null;
		String menuXpath = null;
		boolean foundMenuItem = false;
		webTableXpath =  locatorValue.substring(0, locatorValue.lastIndexOf("table/")) + "table/tbody";
		//System.out.println("Table xpath: " + webTableXpath);
		if(waitForObject(listItem, objectLocatorType, locatorValue) == true){
			WebElement table = driver.findElement(findObject(objectLocatorType, webTableXpath));
			List<WebElement> rows  = table.findElements(By.tagName("tr")); //find all tags with 'tr' (rows)
			int numberOfRows = rows.size();
			if(numberOfRows==1){
				WebElement row = driver.findElement(findObject(objectLocatorType, webTableXpath + "/tr"));
				xpathSubString = locatorValue.substring(locatorValue.lastIndexOf("/tr"));
				List<WebElement> columns  = row.findElements(By.tagName("td")); //find all tags with 'td' (columns)
				int numberOfColumns = columns.size();
				for(int colNum=0; colNum<numberOfColumns; colNum++){
					String cellText = columns.get(colNum).getText().trim();
					if(cellText.contains(listItem.trim())){
						xpathSubString = locatorValue.substring(locatorValue.lastIndexOf("/tr"));
						menuXpath = webTableXpath + xpathSubString;
						try{
							WebElement menu =driver.findElement(findObject(objectLocatorType, menuXpath));
							((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", menu);
							break;
						}catch(Exception e){
							e.printStackTrace();
							this.setErrorFlag(true);
					    	LOGS.info(listItem  + " is not displayed or has changed position");
							this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, listItem + " is not displayed or has changed position."));
							this.captureScreen(this.currentTestName);
					    	LOGS.info(e.getMessage());
					    	this.msgbox("Cannot find: " + listItem + "\n Timeout limit reached.");
						}
					}
				}
			}else{
				for(int rowNum=1; rowNum<=numberOfRows;rowNum++){
					if(foundMenuItem==true){break;}else{
						WebElement row = driver.findElement(findObject(objectLocatorType, webTableXpath + "/tr[" + rowNum + "]"));
						List<WebElement> columns  = row.findElements(By.tagName("td")); 
						int numberOfColumns = columns.size();
						for(int colNum=0; colNum<numberOfColumns; colNum++){
							String cellText = columns.get(colNum).getText().trim();
							if(cellText.contains(listItem.trim())){
								xpathSubString = locatorValue.substring(locatorValue.lastIndexOf("/td["));
								menuXpath = webTableXpath + "/tr[" + rowNum + "]" + xpathSubString;
								try{
									WebElement menu =driver.findElement(findObject(objectLocatorType, menuXpath));
									((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", menu);
									foundMenuItem = true;
									break;
								}catch(Exception e){
									e.printStackTrace();
									this.setErrorFlag(true);
							    	LOGS.info(listItem  + " is not displayed or has changed position");
									this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, listItem + " is not displayed or has changed position."));
									this.captureScreen(this.currentTestName);
							    	LOGS.info(e.getMessage());
							    	this.msgbox("Cannot find: " + listItem + "\n Timeout limit reached.");
								}
							}
						}
					}
				}
			}
		}
	}
	public void clickLink(String objectLocatorType, String locatorValue) throws Exception{
		if(waitForObject("Link", objectLocatorType, locatorValue) == true){
			WebElement link = driver.findElement(findObject(objectLocatorType, locatorValue));
			((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", link);
			//link.click();
		}
	} 
	public void clickMenuItem(String objectLocatorType, String locatorValue) throws IOException{
		if(waitForObject("Menu item", objectLocatorType, locatorValue) == true){
			WebElement menuItem = driver.findElement(findObject(objectLocatorType, locatorValue));
			((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", menuItem);
		}
	}
	public int getRowNumberOfListItem(String objectLocatorType, String locatorValue, String listItem){
		WebElement table = driver.findElement(findObject(objectLocatorType, locatorValue));
		List<WebElement> rows  = table.findElements(By.tagName("tr")); //find all tags with 'tr' (rows)
		//System.out.println("Total Rows: " + rows.size());
		for (int rowNum=0; rowNum<rows.size(); rowNum++) {
			List<WebElement> columns  = table.findElements(By.tagName("td")); //find all tags with 'td' (columns)
			//System.out.println("Total Columns: " + columns.size());
			 for (int colNum=0; colNum<columns.size(); colNum++){
				String cellValue = columns.get(colNum).getText().toLowerCase();
				if(cellValue.equals(listItem.toLowerCase())){
					System.out.print(cellValue);
					listItemRow = rowNum;
					break;
				}
			}
		}
		return listItemRow;
	}
	public void enterText(String objectLocatorType, String locatorValue, String text) throws IOException, InterruptedException{
		if(waitForObject("Text box", objectLocatorType, locatorValue) == true){
			WebElement textBox = driver.findElement(findObject(objectLocatorType, locatorValue));
			try{
				textBox.clear();
				textBox.sendKeys(text);
			}catch(Exception e1){
				textBox.sendKeys(text);
			}
		}
	}
	public void reEnterText(String objectLocatorType, String locatorValue) throws IOException, InterruptedException{
		WebElement textBox = driver.findElement(findObject(objectLocatorType, locatorValue));
		String textInTextBox = textBox.getAttribute("value");
		int incrementedNumber = 0;
		String textWithoutNumbers = textInTextBox.replaceAll("[0-9]","");
		String textWithIncrementedNumber = null;
		String numberInText = null;
		int charsInText = textInTextBox.length();
        for(int i=0; i<=charsInText-1;i++){
            if(Character.isDigit(textInTextBox.charAt(i))){
            	numberInText = numberInText + textInTextBox.charAt(i);
            }
        }
        if(numberInText!=null){
        	incrementedNumber = Integer.parseInt(numberInText) + 1;
        }else{incrementedNumber = incrementedNumber + 1;}
        textWithIncrementedNumber = textWithoutNumbers + incrementedNumber;
		try{
			textBox.clear();
			textBox.sendKeys(textWithIncrementedNumber);
		}catch(Exception e1){
			textBox.sendKeys(textWithIncrementedNumber);
		}
	}
	public void selectListBoxItem(String objectLocatorType, final String locatorValue, String optionToSelect) throws IOException, InterruptedException{
		if(waitForObject("Select box", objectLocatorType, locatorValue)== true){
			Thread.sleep(4000);
			try{
				WebElement selectBox = driver.findElement(findObject(objectLocatorType, locatorValue));
				selectBox.sendKeys(optionToSelect);
			}catch(Exception e1){
				try{
					Select selectBox = new Select(driver.findElement(findObject(objectLocatorType, locatorValue)));
					selectBox.selectByVisibleText(optionToSelect);
				}catch (Exception e2) {
					e2.printStackTrace();
					LOGS.info("Select box item: " + "\"" + optionToSelect + "\"" + " is not displayed");
					LOGS.error(e2.getMessage());
					this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, "Select box item: " +  optionToSelect + " is not displayed"));
					this.captureScreen(this.currentTestName, this.currentTestStepNumber);
				}
			}
		}
	}
	public void clickRadioButtonItem(String objectLocatorType, String locatorValue, String radioButtonLabel) throws IOException, InterruptedException{
		Thread.sleep(2000);
		String trimRadioButtonLabel = radioButtonLabel.trim().replaceAll("[\\p{C}\\p{Z}]", "");
		List<WebElement> labels = driver.findElements(By.tagName("label")); 
		for(WebElement label:labels){
			String labelText  = label.getText().trim().replaceAll("[\\p{C}\\p{Z}]", "");
			//System.out.println(label.getText().trim().replaceAll("[\\p{C}\\p{Z}]", ""));
			if(labelText.equals(trimRadioButtonLabel)){
				if(waitForObject(label)==true){
					((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", label);
					break;
				}
		  }  
		} 
	}
	public void selectRadioButtonItem(String objectLocatorType, String locatorValue, String testData) throws IOException, InterruptedException{
		Thread.sleep(2000);
		WebElement radioButton = null;
		switch(objectLocatorType){
			case "id":
				waitForObject("Radio button", objectLocatorType, locatorValue.trim());
				radioButton = driver.findElement(By.id(locatorValue.trim()));
				break;
			case "xpath":
				try{
					String radioButtonXpath = this.getRadioButtonXpath(objectLocatorType, locatorValue, testData);
					if(waitForObject("Radio button", objectLocatorType, radioButtonXpath)==true){
						radioButton = driver.findElement(By.xpath(radioButtonXpath));
						((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", radioButton);
					}
				}catch(Exception e){
					String xpath = ".//tr/td/label[contains(text(),'" + testData + "')]";
					//System.out.println(xpath);
					if(waitForObject("Radio button", objectLocatorType, xpath) == true){
						radioButton = driver.findElement(By.xpath(xpath));
						radioButton.click();
					}
				}
				break;
			case "css":
				String locatorwithTestData = locatorValue.replace(locatorValue.substring(13, locatorValue.length()), testData) + "']";
				try{
					driver.findElement(findObject(objectLocatorType, locatorwithTestData)).click();
				}catch(Exception e){      
					e.printStackTrace();
				}
				break;
		}
	}
	public String getRadioButtonXpath(String objectLocatorType, String locatorValue, String radioButtonValue){
		String trimRadioButtonValue = radioButtonValue.trim().toLowerCase().replaceAll("[\\p{C}\\p{Z}]", "");
		String radioButtonXpath = null;
		String radioTableXpath =  locatorValue.substring(0, locatorValue.lastIndexOf("table/")) + "table";
		WebElement table = driver.findElement(findObject(objectLocatorType, radioTableXpath));
		List<WebElement> rows  = table.findElements(By.tagName("tr")); //find all tags with 'tr' (rows)
		int rowNumber = rows.size();
		//System.out.println("No. of rows: " + rowNumber);
		if(rowNumber > 1){
			for (int rowNum=1; rowNum<=rows.size(); rowNum++){
				List<WebElement> columns  = table.findElements(By.tagName("td")); //find all tags with 'td' (columns)
				//System.out.println("No. of columns: " + columns.size()); //print number of columns
				String columnText = columns.get(0).getText().trim().toLowerCase().replaceAll("[\\p{C}\\p{Z}]", "");
				//System.out.println("Column #: " + columnText); //print cell data
				if(columnText.contains(trimRadioButtonValue)){
					radioButtonXpath = radioTableXpath + "/tbody/tr[" + rowNum + "]/td/input";
					break;
				}
			}
		}else{
			List<WebElement> columns  = table.findElements(By.tagName("td")); //find all tags with 'td' (columns)
			//System.out.println("No. of columns: " + columns.size()); //print number of columns
			for (int colNum=0; colNum<=columns.size()-1; colNum++){
				String columnText = columns.get(colNum).getText().trim().toLowerCase().replaceAll("[\\p{C}\\p{Z}]", "");
				//System.out.println("Column #: " + colNum + " - " + columnText); //print cell data
				if(columnText.contains(trimRadioButtonValue)){
					int correctedColNum =colNum +1;
					radioButtonXpath = radioTableXpath + "/tbody/tr/td[" + correctedColNum + "]/input";
					break;
				}
			}
		}
		return radioButtonXpath;
	}
	public void checkCheckBox(String objectLocatorType, String locatorValue) throws IOException{
		if(waitForObject("Check box", objectLocatorType, locatorValue) == true){
			WebElement checkBox = driver.findElement(findObject(objectLocatorType, locatorValue));
			((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", checkBox);
		}
	}	
	public void unCheckCheckBox(String objectLocatorType, String locatorValue) throws IOException{
		if(waitForObject("Check box", objectLocatorType, locatorValue) == true){
			WebElement checkBox = driver.findElement(findObject(objectLocatorType, locatorValue));
			if (checkBox.isSelected())	{
				checkBox.click();
			}
		}
	}	
	public void switchToPopup() throws InterruptedException{
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> windows = windowHandles.iterator();
	    while(windows.hasNext()){
	         String popupHandle=windows.next().toString();
	         if(!popupHandle.contains(getMainWindowHandle())){
	             driver.switchTo().window(popupHandle);
	         }
	    }
	}
	public void closePopup() throws InterruptedException{
		Thread.sleep(2000);
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> windows = windowHandles.iterator();
	    while(windows.hasNext()){
	         String popupHandle = windows.next().toString();
	         if(!popupHandle.contains(getMainWindowHandle())){
	        	 driver.switchTo().window(popupHandle).close();
	         }
	    }
	    driver.switchTo().window(mainWindowHandle);
	    //this.switchToMainWindow();
	}
	public void switchToMainWindow() throws InterruptedException{
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> windows = windowHandles.iterator();
	    while(windows.hasNext()){
	         String currentHandle = windows.next().toString();
	         if(currentHandle.contains(mainWindowHandle)){
	        	 driver.switchTo().window(currentHandle);
	         }
	    }
	}
	public void verifyTextPresent(String objectLocatorType, String locatorValue, String testData) throws IOException{
		if(waitForObject("Text", objectLocatorType, locatorValue) == true){
			String textToVerify = driver.findElement(findObject(objectLocatorType, locatorValue)).getText().trim().toLowerCase().toString().replaceAll(" ", "");
			//System.out.println(textToVerify);
			String testDataM = testData.replaceAll("\\s","");
			//System.out.println(testDataM);
			if(textToVerify.isEmpty()){
				LOGS.info("Expected text: " +  "\"" + textToVerify + "\""  + " is not displayed");
				try {
					this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, "Expected text: " +  "\"" + textToVerify + "\""  + " is not displayed"));
					this.captureScreen(this.currentTestName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				if(textToVerify.equals("cloudcommandandcontrol-monitoring")){
					LOGS.info("Text displayed: " +  "\"" + textToVerify + "\""  + " matches expected: " + testData);
				}else{
					if(textToVerify.toLowerCase().trim().contentEquals(testData.trim().toLowerCase())){
						LOGS.info("Text displayed: " +  "\"" + textToVerify + "\""  + " does not match expected: " + testData);
						try {
							this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, "Text displayed: " +  "\"" + textToVerify + "\""  + " does not match expected: " + "\"" + testData + "\""));
							this.captureScreen(this.currentTestName);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} 
				}
			}
		}
	}
	public void verifyTextNotPresent(String objectLocatorType, String locatorValue, String testData) throws IOException {
		if(waitForObject("Text", objectLocatorType, locatorValue) == true){
			String textToVerify = driver.findElement(findObject(objectLocatorType, locatorValue)).getText();
			if(textToVerify.compareToIgnoreCase(testData)<0){
				LOGS.info("Text displayed: " +  "\"" + textToVerify + "\""  + " does not match expected: " + testData);
				try {
					this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, "Text: " +  "\"" + textToVerify + "\""  + " IS displayed"));
					this.captureScreen(this.currentTestName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void checkIfErrorMessageDisplays(String objectLocatorType, String locatorValue, String testData) throws IOException{
		if(waitForObject("Text", objectLocatorType, locatorValue) == true){
			String textToVerify = driver.findElement(findObject(objectLocatorType, locatorValue)).getText().trim().toLowerCase().toString().replaceAll(" ", "");
			//System.out.println(textToVerify);
			String cleanTestData = testData.trim().toLowerCase().toString().replaceAll("\\s","");
			//System.out.println(testDataM);
			if(textToVerify.equals(cleanTestData)){
				this.isErrorMessageDisplayed = true;
				/*StringSelection stringSelection = new StringSelection("true");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);*/
		        //this.pasteValueFromClipboard(objectLocatorType, locatorValue);
			}
		}
	}
	public   void scrollDown(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
	}
	public  void verifyPageTitle(String pageTitle) throws IOException{
		String currentWindowTitle = driver.getTitle().toString();
		if(!currentWindowTitle.isEmpty() && !currentWindowTitle.equals(pageTitle)){
			LOGS.info("Current page title: " +  "\"" + currentWindowTitle + "\"" + " does not match expected title: " + "\"" + pageTitle + "\"");
			this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, "Current page title: " +  "\"" + currentWindowTitle + "\"" + " does not match expected title: " + "\"" + pageTitle + "\""));
			this.captureScreen(this.currentTestName);
		}
	}
	public CharSequence getMainWindowHandle(){
		String mainWindowHandle=driver.getWindowHandle();
		return mainWindowHandle;
	}
	public String getBrowserName(){
		String browserName = null;
		Capabilities capability = ((RemoteWebDriver) driver).getCapabilities();
		 return browserName = capability.getBrowserName();
	}
	public void saveFile() throws IOException{
		String[] dialog;
		//String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		Capabilities capability = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = capability.getBrowserName();
		//String browserVersion = caps.getVersion();
		if(browserName.toLowerCase().contains("internet explorer")){
			String autoItScriptPath = this.findFile(this.testEnginePath,  "Save_File_IE.exe");
			//System.out.println(autoItScriptPath);
			   dialog =  new String[]{"Save_Dialog_IE.exe","Download","Save"};
			   Runtime.getRuntime().exec(dialog);
		}
		if(browserName.toLowerCase().contains("firefox")){
			String autoItScriptPath = this.findFile(this.testEnginePath,  "Save_File_FF.exe");
			//System.out.println(autoItScriptPath);
			dialog = new String[] {autoItScriptPath,"Opening","save"};
			Runtime.getRuntime().exec(dialog);
		}
		if(browserName.toLowerCase().contains("chrome")){
			String autoItScriptPath = this.findFile(this.testEnginePath,  "Save_File_Chrome.exe");
			//System.out.println(autoItScriptPath);
			dialog = new String[] {autoItScriptPath,"Download","Save"}; 
			Runtime.getRuntime().exec(dialog);
		}
	}
	public void captureScreen(String currentTestName, int currentTestStepNumber) throws IOException {
	    try {
	        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotFolderName = createFolder(currentResultsFolderPath, "Screenshots").toString();
	        FileUtils.copyFile(source, new File(screenshotFolderName + "\\" + currentTestName + "-" + "Step No." + currentTestStepNumber + ".png")); 
	    }
	    catch(IOException e){
	        LOGS.info("Failed to capture screenshot");
	        LOGS.error(e.getMessage());
			this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, "Failed to capture screenshot"));
	    }
	}
	public void captureScreen(String currentTestName) throws IOException {
		screenshotCounter++;
		String path;
	    try {
	        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        path = "./target/screenshots/" + source.getName();
	        String screenshotFolderName = createFolder("C:\\AutomatedTests", "Screenshots").toString();
	        String currentTestScreenshotFolderName = createFolder(screenshotFolderName, "\\" + currenDate).toString();
	        FileUtils.copyFile(source, new File(currentTestScreenshotFolderName + "\\" + currentTestName + "_" + screenshotCounter + ".png")); 
	    }
	    catch(IOException e) {
	        path = "Failed to capture screenshot: " + e.getMessage();
	        LOGS.info("Failed to capture screenshot");
			this.writeFailedStepToTempResultsFile(currentResultFilePath, this.reportEvent(this.currentTestName, this.currentTestStepNumber, this.currentTestStepName, "Failed to capture screenshot"));
			this.captureScreen(this.currentTestName);
	    }
	}
	public  void appendText(String objectLocatorType, String locatorValue, String text) throws IOException{
		if(waitForObject("Text box", objectLocatorType, locatorValue) == true){
			WebElement textBox = driver.findElement(findObject(objectLocatorType, locatorValue));
			textBox.sendKeys(text);
		}
	}
	public void setDbConnectionParams(String ipAddress, String portNumber, String dbName, String dbUsername, String dbPassword){
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
		this.dbName = dbName;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	public String getActivationCode(String objectLocatorType, String locatorValue, String query) throws Exception, IllegalAccessException{
		String activationCode = null;
		String dbUrl = "jdbc:mysql://" + ipAddress + ":" + portNumber + "/";
        String driver = "com.mysql.jdbc.Driver";
        String columnName = query.substring(6, query.indexOf("from")).trim();
        try {
	        Class.forName(driver).newInstance();
   	        Connection conn = DriverManager.getConnection(dbUrl + this.dbName,this.dbUsername,this.dbPassword);
	        Statement st = conn.createStatement();
	        ResultSet res = st.executeQuery(query);
	        while (res.next()){
	        	activationCode = res.getString(columnName);
		        //System.out.println(activationCode);
	        }
	        conn.close();
	        st.close();
	        res.close();
        }catch(ClassNotFoundException e){
        	e.printStackTrace();
        }catch(SQLException e){
        	 e.printStackTrace();
        }
        StringSelection stringSelection = new StringSelection(activationCode);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        LOGS.info("Activation Code: " + activationCode);
        this.pasteValueFromClipboard(objectLocatorType, locatorValue);
 		return activationCode;
	}
	public String getDbValue(String query) throws Exception, IllegalAccessException{
		String dbValue = null;
		String dbUrl = "jdbc:mysql://" + ipAddress + ":" + portNumber + "/";
        String driver = "com.mysql.jdbc.Driver";
        String columnName = query.substring(6, query.indexOf("from")).trim();
        try {
	        Class.forName(driver).newInstance();
   	        Connection conn = DriverManager.getConnection(dbUrl + this.dbName,this.dbUsername,this.dbPassword);
	        Statement st = conn.createStatement();
	        ResultSet res = st.executeQuery(query);
	        while(res.next()){
		        dbValue = res.getString(columnName);
		        //System.out.println(dbValue);
	        }
	        conn.close();
	        st.close();
	        res.close();
        }catch(ClassNotFoundException e){
        	e.printStackTrace();
        }catch(SQLException e){
        	 e.printStackTrace();
        }
        StringSelection stringSelection = new StringSelection(dbValue);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        LOGS.info("Database value: " + dbValue);
 		return dbValue;
	}
	public List<String> getDbValues(String query) throws Exception, IllegalAccessException{
		List<String> dbValues = new ArrayList<String>();
		String dbUrl = "jdbc:mysql://" + ipAddress + ":" + portNumber + "/";
        String driver = "com.mysql.jdbc.Driver";
        String columnName = query.substring(6, query.indexOf("from")).trim();
        try {
	        Class.forName(driver).newInstance();
   	        Connection conn = DriverManager.getConnection(dbUrl + this.dbName,this.dbUsername,this.dbPassword);
	        Statement st = conn.createStatement();
	        ResultSet res = st.executeQuery(query);
	        while(res.next()){
		       dbValues.add(res.getString(columnName));
		        //System.out.println(dbValue);
	        }
 	        conn.close();
	        st.close();
	        res.close();
        }catch(ClassNotFoundException e){
        	e.printStackTrace();
        }catch(SQLException e){
        	 e.printStackTrace();
        }
        StringSelection stringSelection = new StringSelection(dbValues.toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        LOGS.info("Database values: " + dbValues.toString());
 		return dbValues;
	}
	public void pasteValueFromClipboard(String objectLocatorType, String locatorValue) throws IOException {
        String clipboardText;
        Transferable trans = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        try {
            if(trans != null && trans.isDataFlavorSupported(DataFlavor.stringFlavor)){
                clipboardText = (String) trans.getTransferData(DataFlavor.stringFlavor);
                if(waitForObject("Text box", objectLocatorType, locatorValue) == true){
        			WebElement textBox = driver.findElement(findObject(objectLocatorType, locatorValue));
        			try{
        				textBox.clear();
        				textBox.sendKeys(clipboardText);
        			}catch(Exception e1){
        				textBox.sendKeys(clipboardText);
        			}
        		}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public  By findObject(String objectLocatorType, String locatorValue){
		switch (objectLocatorType.toUpperCase()){
			case "CLASS_NAME":
				return By.className(locatorValue);
			case "CSS":
				return By.cssSelector(locatorValue);
			case "ID":
				return By.id(locatorValue);
			case "LINK_TEXT":
				return By.linkText(locatorValue);
			case "NAME":
				return By.name(locatorValue);
			case "PARTIAL_LINK_TEXT":
				return By.partialLinkText(locatorValue);
			case "TAG_NAME":
				return By.tagName(locatorValue);
			case "XPATH":
				return By.xpath(locatorValue);
			default:
				throw new IllegalArgumentException(
						"Cannot determine how to locate element " + locatorValue);
		}
	}
	public  WebDriver launchBrowser(String browserName) throws URISyntaxException, IOException{
		browserName = browserName.toLowerCase();
		String browserPath = null;
		switch(browserName){
			case "firefox":
				FirefoxProfile profile = new FirefoxProfile();
				profile.setEnableNativeEvents(true);
				browserPath = this.testEnginePath + "\\Firefox_Selenium\\" + "firefox.exe";
				System.setProperty("webdriver.firefox.bin", browserPath);
				driver = new FirefoxDriver(profile);
				driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				LOGS.info("************Launching Firefox ************");
				break;
			case "chrome":
				browserPath = this.testEnginePath + "\\Chrome_Selenium\\" + "chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", browserPath);
				DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
				chromeCapabilities.setJavascriptEnabled(true);
				driver = new ChromeDriver(chromeCapabilities);
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				LOGS.info("************ Launching Chrome browser ************");
				break;                     
			case "ie":
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				browserPath = this.testEnginePath + "\\IE_Selenium\\" + "IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", browserPath);
				driver = new InternetExplorerDriver(ieCapabilities);
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				LOGS.info("************ Launching Internet Explorer ************");
				break;
			case "safari":
				//browserPath = "*safari " + this.testEnginePath + "\\Safari_Selenium\\" + "Safari.exe";
				browserPath = "C:\\Users\\Ramkanth Manga\\Desktop\\TE_1.1\\Safari_Selenium\\Safari.exe";
				System.setProperty("webdriver.safari.driver", browserPath);
				System.setProperty("webdriver.safari.noinstall", "true");
				driver = new SafariDriver();
				driver.manage().window().maximize();
				LOGS.info("************ Launching Internet Explorer ************");
				break;
			case "headless":
				driver = new HtmlUnitDriver();
 				((HtmlUnitDriver)driver).setJavascriptEnabled(true);
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//driver.manage().window().maximize();
				LOGS.info("************ Launching headless test ************");
				break;                      
			}
			return driver;
	}
	public  String navigateToUrl(String environment) throws MalformedURLException{
		environment = environment.trim().toLowerCase();
		this.environment = environment;
		driver.navigate().to(environment);
		return environment;
	}
	public  void closeBrowser(String closeBrowser) throws Exception{
		if(closeBrowser.toLowerCase().equals("yes")){
			driver.quit();
			this.killBrowserProcess(this.getBrowserName());
		}else{
			this.killBrowserProcess(this.getBrowserName());
		}
	}
	public void killBrowserProcess(String browserName) throws Exception{
	  final String KILL = "taskkill /IM";
	  String processName = null;
	  switch(browserName.toLowerCase()){
		  case "firefox":
			  processName = "firefox.exe*32";
			  Process proc = Runtime.getRuntime().exec(KILL + processName); 
			  proc.destroy();
			  //Runtime.getRuntime().exec(KILL + processName);
			  break;
		  case "ie":
			  processName = "IEDriverServer.exe"; 
			  Runtime.getRuntime().exec(KILL + processName); 
			  break;
		  case "chrome":
			  processName = "chromedriver.exe*32"; 
			  Runtime.getRuntime().exec(KILL + processName); 
			  break;
	  }
	} 
	public boolean isUrlReachable(String environment) throws UnknownHostException, IOException{
		int timeOut = 3000;
		boolean status = InetAddress.getByName("198.46.49.73").isReachable(timeOut);
		return true;
	}
	public  String createFolder(String path, String folderName){
		new File(path + "\\" + folderName).mkdir();
		return path + "\\" + folderName;
	}
	public String createTextFile(String parentFolderName, String fileName, String fileExtension) throws Exception{
		File newFile = new File(parentFolderName, fileName + "." + fileExtension);
		newFile.createNewFile();
		return newFile.getAbsolutePath();
	}
	public String createResultsFile(String parentFolderName, String currentTime){
		String resultsFilePath = null;
		try {
			resultsFilePath = this.createTextFile(parentFolderName, "\\" + "Results_" + currentTime, "txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultsFilePath;
	}
	public String createTempResultsFile(String parentFolderName, String []resultMessage){
		String resultsFilePath = null;
		try {
			resultsFilePath = this.createTextFile(parentFolderName, "Temp_" + resultMessage[0] + "_" + resultMessage[1], "txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultsFilePath;
	}
	public  void copyFile(String filePath, String newFilePath, String newFileName){
		InputStream inStream = null;
		OutputStream outStream = null;
		newFileName = newFilePath + "\\" + newFileName;
    	try{
    	    File file =new File(filePath);
    	    File newFile =new File(newFileName);
    	    inStream = new FileInputStream(file);
    	    outStream = new FileOutputStream(newFile);
    	    byte[] buffer = new byte[1024];
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
    	    	outStream.write(buffer, 0, length);
    	    }
    	    inStream.close();
    	    outStream.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	public void mouseOver(WebDriver driver, WebElement webElement) {
        String code = "var fireOnThis = arguments[0];"
                    + "var evObj = document.createEvent('MouseEvents');"
                    + "evObj.initEvent( 'mouseover', true, true );"
                    + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(code, webElement);
    }
	
	public void  generateRandomWord (){	   	            
        Random myRandom = new Random();
        for (int i = 0; i < 4; i++) {         
           String Word = "" + 
                (char) (myRandom.nextInt(26) + 'A') +
                (char) (myRandom.nextInt(26) + 'a') +
                (char) (myRandom.nextInt(26) + 'a') +
                (char) (myRandom.nextInt(26) + 'a');               
        }
	}
	public String getBrowserPath(String browserName){
		String browserPath = null;
		browserName = browserName.toLowerCase() + ".exe";
		File root = new File("c:\\");
        File[] list = root.listFiles();
        for (File f : list) {
            if (f.isDirectory() && f!=null){
            	File[] filesInFolder = f.listFiles();
            	if(Arrays.toString(filesInFolder).contains(browserName)){
            		browserPath =f.getAbsolutePath() + "\\" + browserName;
            	}
            }
        }
		return browserPath;
	}
	public String getFilePath(String folderName, String fileName){
		String filePath = null;
		File folder = new File(folderName);
        File[] filesList = folder.listFiles();
        for (File f : filesList) {
            if (f.isDirectory() && f!=null){
            	File[] filesInFolder = f.listFiles();
            	if(Arrays.asList(filesInFolder).contains(fileName)){
            		//System.out.println("yes");
            	}
            }
        }
		return filePath;
	}
	private void msgbox(String message){
		   JOptionPane.showMessageDialog(null, message);
	}
	public int getFailedTestStepsNumber(){
		return failedStepCounter;
	}
	public int setFailedTestsNumber(){
		if(failedStepCounter >0){
			failedTestsCounter++;
		}
		return failedTestsCounter;
	}
	public String[] reportEvent(String testCaseName, int testStepNumber, String testStep, String message) throws IOException{
		failedStepCounter++;
		String[] report = {testCaseName, String.valueOf(testStepNumber), testStep, message};
		return report;
	}

	public void writeFailedStepToTempResultsFile(String resultFilePath, String[] resultMessage){
		//System.out.println(Arrays.toString(resultMessage));
		String tempResultFilePath = this.createTempResultsFile(this.currentResultsFolderPath, resultMessage);
		BufferedWriter writer = null;        
	    try{
	        writer = new BufferedWriter(new FileWriter(tempResultFilePath));
	        writer.append("Test Case: " + resultMessage[0]);
    		writer.newLine();
    		writer.append("\t");
    		writer.append("Step No.");
    		writer.append(resultMessage[1]).
    		append(": ").
    		append(resultMessage[2]);
    		writer.newLine();
    		writer.append("\t\t\t").
    		append(" ACTUAL RESULT: ").
    		append(resultMessage[3]);
    		writer.newLine();
    		writer.newLine();
	    }catch (FileNotFoundException ex){
	        ex.printStackTrace();
	    }catch (IOException ex){
	        ex.printStackTrace();
	    }finally {
	        try {
	            if (writer != null) {
	                writer.flush();
	                writer.close();
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	public void writeTestResultsFile() throws IOException{
		BufferedWriter writer = null;        
		writer = new BufferedWriter(new FileWriter(this.currentResultFilePath));            
        writer.append("Tests Executed: " + this.totalTestNumber);
        writer.newLine();
        writer.append("Tests Passed: " + (this.totalTestNumber - this.failedTestsCounter));
        writer.newLine();
        writer.append("Tests Failed: " + this.failedTestsCounter);
		List<String> tempResultFiles = new ArrayList<>();
		tempResultFiles = this.findFiles(this.currentResultsFolderPath, "Temp");
		if(tempResultFiles.size() > 0){
			writer.newLine();
			writer.newLine();
    		writer.append("Failed Test Case(s):");
			for(int i=0; i<tempResultFiles.size(); i++){
				BufferedReader tempResultFileReader;
				StringBuilder sb = new StringBuilder();
				File file = new File(tempResultFiles.get(i));
				tempResultFileReader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = tempResultFileReader.readLine()) != null) {
				    sb.append(line);
				}
				tempResultFileReader.close();
				file.delete();
				int position1 = sb.indexOf("Step No.");
				String testCaseName = sb.substring(sb.indexOf("Test Case:"), position1);
				String stepNameAndNumber = sb.substring(position1, sb.indexOf("ACTUAL RESULT:"));
				String actualResult = sb.substring(sb.indexOf("ACTUAL RESULT:"), sb.length());
				writer.newLine();
				writer.append("\t");
				writer.append(testCaseName);
				writer.newLine();
				writer.append("\t\t");
			    writer.append(stepNameAndNumber);        
			    writer.newLine();
			    writer.append("\t\t\t");
			    writer.append(actualResult);
			    writer.newLine();
			}
		}
		writer.close();
	}
	
	//stand alone runner
	/*public  static void main(String arg[]) throws IOException{
		//System.out.println(Util.getBrowserPath("firefox").toString());
	}*/
	
}

