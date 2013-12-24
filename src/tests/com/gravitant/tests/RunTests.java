package com.gravitant.tests;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;

import com.gravitant.utils.HTMLReportGenerator;
import com.gravitant.utils.XL_Reader;
import com.gravitant.utils.CSV_Reader;
import com.gravitant.utils.Util;

public class RunTests{
	static Logger LOGS = Logger.getLogger(RunTests.class);
	public String automatedTestsFolder = "C:\\AutomatedTests";
	public String testConfigFilePath =  "C:\\AutomatedTests\\Test_Config\\Test_Config.txt";
	public String testsToRun =  "C:\\AutomatedTests\\Tests_To_Run\\TestsToRun.txt";
	
	public File testCasesFolder = new File("C:\\AutomatedTests\\Test_Cases");
    public File[] testCasesList = testCasesFolder.listFiles();
    
    public File objectMapFolder = new File("C:\\AutomatedTests\\Object_Map");
    public File[] objectMapsList = objectMapFolder.listFiles();
    public String objectMapFilePath;
    public String objectMapFileName = null;
    public String[] objectInfo = null;
    
    public File testDataFolder = new File("C:\\AutomatedTests\\Test_Data");
    public File[] testDataFilesList = testDataFolder.listFiles();
    public String testDataFilePath;
    public String testDataFileName = null;
    public String testDataFileObjectName = null;
    public String testStepObjectName = null;
    public String currentTest = null;
    public String testStepNumber = null;
    public String testStepPageName = null;
    public String testStep = null;
	public int numberofTestSteps = 0;
    
    public String environment = null;
    public String browserType = null;
    public String userName = null;
    public String password = null;
    public String pageName = null;
    
    public String[] testStepRow = null;
    public String action = null;
    public String locator_Type = null;
    public String locator_Value = null;
    public String testData = null;
    public List<String> datatestData =  null;
    
	public String testResultsFolderName;
	public String currentResultsFolderName;
	public String currentResultFileName;
	public String currentResultFilePath;
	public int totalTestsExecuted= 0;
	
	public String currentDate = FastDateFormat.getInstance("dd-MMM-yyyy").format(System.currentTimeMillis( ));
	public Calendar cal = Calendar.getInstance();
	public SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
	public String currentTime = dateFormat.format(cal.getTime()).replaceAll(":","-");
	public String path =  getClass().getClassLoader().getResource(".").getPath().toString();
	
	/******************************************************************************************************/
	public static void main(String[] args) throws Exception{
		RunTests test = new RunTests(); 
		test.start();
		Util util = new Util();
		util.generateRandomWord();
 	}
	
	/**
	 * @throws Exception
	 */
	public void start() throws Exception{
		Util util = new Util();
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");
		/*******Create test results folder ****************/
		testResultsFolderName = util.createFolder(automatedTestsFolder, "Test_Results").toString();//create test results folder
		currentResultsFolderName = util.createFolder(testResultsFolderName, "Results_" + currentDate).toString();//create folder with todays date within above folder
		currentResultFilePath =util.createResultsFile(currentResultsFolderName, currentTime);
		util.setCurrentResultFilePath(currentResultFilePath);
		currentResultFileName = currentResultFilePath;
		util.setCurrentResultFileName(currentResultFileName);
		util.setCurrentDate(currentDate);
		util.setCurrentTime(currentTime);
		/*******Get environment & browser type from test config file & launch browser, navigate to Url****************/
		environment = util.getTestConfigProperty("environment");
		browserType = util.getTestConfigProperty("browserType");
		userName = util.getTestConfigProperty("username");
		password = util.getTestConfigProperty("password");
		util.launchBrowser(browserType);
		util.navigateToUrl(environment);
		util.login(userName, password);
		/*******Get test cases to run from TestsToRun.txt*****************************************************/
        java.util.List<String> testsToRun = util.getTestsToRun();
		for(int i=0; i<=testsToRun.size()-1; i++){
			currentTest = testsToRun.get(i);
			//System.out.println(currentTest);
			/*******If test case exists in Test_Cases folder, read the file and get the page name for each step*******/
			if(!util.verifyTestCaseExists(currentTest).equals(null)){
				util.setCurrentTestName(currentTest);
				util.setTotalTestNumber();
				String currentTestPath = util.getTestCasePath(currentTest);
	        	LOGS.info("-------------------->> STARTING TEST CASE: " + currentTest + "<<--------------------");
				CSVReader testCaseReader = new CSVReader(new FileReader(currentTestPath));
			    List<String[]> testCaseContent = testCaseReader.readAll();
			    //numberofTestSteps = util.getRowCount(testCaseContent);
			    int lineNumber = 0;
			    //for (Object object : testCaseContent){
			    for (int j=1; j<testCaseContent.size(); j++){
			    	lineNumber++;
			    	testStepRow = testCaseContent.get(j);
				    testStepNumber = testStepRow[0];
				    testStepPageName = testStepRow[2];
				    testStepObjectName = testStepRow[3];
				    action = testStepRow[4];
				    if(action.equals("begin_dataTest")){
				    	int datatestLineNumber = lineNumber +1;
				    	for(int k= datatestLineNumber; k<testCaseContent.size(); k++){
				    		testStepRow = testCaseContent.get(k);
				    		testStepNumber = testStepRow[0];
						    testStepPageName = testStepRow[2];
						    testStepObjectName = testStepRow[3];
						    action = testStepRow[4];
						    datatestData = util.getDataTestData(testStepPageName, testStepObjectName);
						    for(int m=0; m<datatestData.size(); m++){
						    	testData = datatestData.get(m);
							    if(!action.equals("end_dataTest")){
							    	System.out.println(action);
							    	util.executeAction(testStepPageName, testStepObjectName, action, testData);
							    }else{
							    	break;
							    }
						    }
						    datatestLineNumber++;
				    	}
				    }else{
				    	testData = util.getTestData(testStepPageName, testStepObjectName);
				    	util.executeAction(testStepPageName, testStepObjectName, action, testData);
				    }
				 }
			  
		       /* while((testStepRow = testCaseReader.readNext()) != null){
		        	action = testStepRow[4];
        			testData = util.getTestData(testDataFileName, testStepObjectName);
		        	testStepNumber = testStepRow[0];
		        	util.setCurrentTestStep(testStepNumber);
		        	testStep = testStepRow[1];
		        	util.setCurrentTestStep(testStep);
		        	pageName = testStepRow[2];
		        	util.setCurrentPageName(pageName);
		        	testStepObjectName = testStepRow[3];
		        	util.setCurrentTestObjectName(testStepObjectName);
		        	objectMapFileName = util.getObjectMapFilePath(pageName);
		        	testDataFileName = util.getTestDataFilePath(pageName);
		        	if(!testStep.equals("Step")){LOGS.info("> Executing test step: " + testStep);}
		        	*//*******Read object map file (page file) in Object_Map folder and get the locator type & value for the test step object*******//*
		        	if(objectMapFileName != null){
		        		objectInfo = util.getObjectInfo(objectMapFileName, testStepObjectName);
		        		if(objectInfo != null){
		        			locator_Type = util.getObjectLocatorType(objectInfo);
		        			locator_Value = util.getObjectLocatorValue(objectInfo);
		        		}

		        		*//****Execute the action using object name, locator type, locator value, and test data (if any) *******//*
				        util.executeAction(testDataFileObjectName, action, locator_Type, locator_Value, testData);
		        	}
		        }*/
			    testCaseReader.close();
			}
		}
		//util.writeTestResultsFile();
	}
}

	 

