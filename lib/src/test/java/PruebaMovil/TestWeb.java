package PruebaMovil;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestWeb {
	private WebDriver driver;
	Web  objCP;
	RutasGenerales ruta;
	Properties prop = new Properties();
	Excel reader;

	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
    ExtentTest test;
    
	
   
	 @BeforeTest
	    public void startTest() {
	    	
	    			reports = new ExtentReports();
	                htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//TestWeb.html");
	                reports.attachReporter(htmlReporter);
	                
	                reports.setSystemInfo("Eclipse", "Java");
	                reports.setSystemInfo("Selenium", "WebDriver");
	                reports.setSystemInfo("ExtentReport", "Integration");
	                reports.setSystemInfo("Browser", "Google Chrome");
	    }
	
	/*
	 * Método que invoca al driver del navegador y
	 * la ruta del asplicativo a probar
	 */
	@BeforeMethod
	public void setUp() throws Exception {
		objCP = new Web(driver);
		prop.load(new FileReader(objCP.rutaProperties()));
		
		if(prop.getProperty("001_NAV").equals("0")) {
			driver = objCP.chromeDriverConnection();
		}
		ruta = new RutasGenerales();
	}

	/*
	 * Método que contiene el test de prueba
	 */
	@Test
	public void test() throws Exception {
		
		//Leer Excel	
		try {reader = new Excel(ruta.rutaInputs());
		}catch (Exception e){
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <=reader.getRowCount("Test"); rowNum++){
			
			String x = rowNum-1+"";
			test = reports.createTest("Test "+x);
			
			String user = reader.getCellData("Test", "USUARIO", rowNum);
			String password = reader.getCellData("Test", "PASS", rowNum);
			
			try {
			
			objCP.visit(prop.getProperty("URL_SomosBelcorp").trim());
			objCP.recargar();
			
				objCP.SignUp(user,password);
				
				// CAPTURA
				File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File file = new File("src/../Images/" + System.currentTimeMillis()+ ".png");
				String pathh = file.getAbsolutePath();
			    FileUtils.copyFile(source, new File(pathh));
			
			    objCP.Login(user,password);
				
			    // CAPTURA
				File source2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File file2 = new File("src/../Images/" + System.currentTimeMillis()+ ".png");
				String pathh2 = file2.getAbsolutePath();
				FileUtils.copyFile(source2, new File(pathh2));
				
				objCP.Agregar();
				
				// CAPTURA
				File source3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File file3 = new File("src/../Images/" + System.currentTimeMillis()+ ".png");
				String pathh3 = file3.getAbsolutePath();
				FileUtils.copyFile(source3, new File(pathh3));
				
				objCP.CerrarSesión();
			    
				// CAPTURA
				File source4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File file4 = new File("src/../Images/" + System.currentTimeMillis()+ ".png");
				String pathh4 = file4.getAbsolutePath();
				FileUtils.copyFile(source4, new File(pathh4));
				
				test.log(Status.PASS,MarkupHelper.createLabel("Pass Test ", ExtentColor.GREEN));
	    	   	test.log(Status.INFO,"Sign Up", MediaEntityBuilder.createScreenCaptureFromPath(pathh).build()); 
	    	   	test.log(Status.INFO,"Login", MediaEntityBuilder.createScreenCaptureFromPath(pathh2).build()); 
	    	   	test.log(Status.INFO,"Agregar", MediaEntityBuilder.createScreenCaptureFromPath(pathh3).build());
				test.log(Status.INFO,"Logout", MediaEntityBuilder.createScreenCaptureFromPath(pathh4).build()); 
	    	   	reports.flush();
				
				reader.setCellData("Test", "ESTADOREPOR", rowNum, "PASSED");
				}catch(Exception e){
					
					// CAPTURA
					File source3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File file3 = new File("src/../Images/" + System.currentTimeMillis()+ ".png");
					String pathh3 = file3.getAbsolutePath();
					FileUtils.copyFile(source3, new File(pathh3));
					
					test.log(Status.FAIL, MarkupHelper.createLabel("Fail Test ", ExtentColor.RED));
					test.log(Status.INFO,"Error" +e, MediaEntityBuilder.createScreenCaptureFromPath(pathh3).build()); 
	 				reports.flush();
	 				System.out.println(e);
	 				
					reader.setCellData("Test", "ESTADOREPOR", rowNum, "FAILED");
				}
				
			
			
		}		
		
	}
	
	
		

	/*
	 * Método que culmina el proceso de prueba
	 */
	@AfterMethod
	public void tearDown() throws Exception {
		//driver.quit();
	}
}
