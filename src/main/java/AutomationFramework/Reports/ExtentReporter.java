/*Author : Madhumitha Sampath
 
 ************************************************************************* 
 
Defined functions for generating reports

 ************************************************************************* 
 */
package AutomationFramework.Reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporter implements IReporter {
	private ExtentReports extent;
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
			File file = new File(System.getProperty("user.dir")+"\\build\\reports\\tests\\test\\Reports\\");
			if(file.exists())
			{			
			File[] files=file.listFiles();			
			int count=files.length;
			if(count>0) {
				for(int i=0;i<count; i++) {
				String File_Name=files[i].getName();
				File src= new File(System.getProperty("user.dir")+"\\build\\reports\\tests\\test\\Reports\\"+File_Name);
				File dest= new File(System.getProperty("user.dir")+"\\build\\reports\\tests\\test\\Old-Reports\\"+File_Name);
				try {
					Files.move(src, dest);
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
				}
			}
			else {
			new File(System.getProperty("user.dir")+"\\build\\reports\\tests\\test\\Old-Reports\\").mkdir();
			}
			extent = new ExtentReports(outputDirectory + File.separator+"\\Reports\\Automation_Report_"+(new SimpleDateFormat("ddMMMyy_hh_mm_ss_a").format(new Date()))+".html", true);
			for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		extent.flush();
		extent.close();
	}
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);
				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}
				extent.endTest(test);
			}
		}
	}
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}