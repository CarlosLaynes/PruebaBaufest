package PruebaMovil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;


public class Web extends Base {

	
	Properties prop = new Properties();	
	public WebDriver driver;
	
	// LOCALIZADORES
	
		By signup = By.id("signin2");	
		By usuario = By.id("sign-username");
		By pass = By.id("sign-password");
		By sign = By.xpath("//button[contains(text(), 'Sign up')]");
		
		By login = By.id("login2");	
		By lusuario = By.id("loginusername");
		By lpass = By.id("loginpassword");
		By ingresar = By.xpath("//button[contains(text(), 'Log in')]");
		
		By laptops = By.xpath("//a[contains(text(), 'Laptops')]");
		By lap = By.xpath("//a[contains(text(), '//a[contains(text(), 'Sony vaio i5')]')]");
		By agregar = By.xpath("//a[contains(text(), 'Add to cart')]");

		By cerrar = By.id("logout2");
		
		public Boolean validador = false;
		/*
		 * Constructor que invoca el driver del navegador a utilizar
		 */
		public Web(WebDriver driver) {
			super(driver);
		}
		
		/*
		 * Método que contiene el Login
		 */
		public void SignUp(String user, String password) throws FileNotFoundException, IOException, InterruptedException {		
				
				prop.load(new FileReader(rutaProperties()));
				
				click(signup);
				Thread.sleep(1000);
			    type(user, usuario);
			    type(password, pass);
			    
			    try {
			    click(sign);
			    Thread.sleep(5000);
			    } catch (UnhandledAlertException f) {
			        try {
			            Alert alert = driver.switchTo().alert();
			            String alertText = alert.getText();
			            System.out.println("Alert data: " + alertText);
			            alert.accept();
			        } catch (NoAlertPresentException e) {
			            e.printStackTrace();
			        }
			    }
		}
		
		/*
		 * Método
		 */
		public void Login(String user, String password) throws FileNotFoundException, IOException, InterruptedException {		
			
			click(login);
			Thread.sleep(1000);
		    type(user, lusuario);
		    type(password, lpass);
		   
				
		}
	
		public void Agregar() throws FileNotFoundException, IOException, InterruptedException {		
			
			 click(ingresar);
			 Thread.sleep(3000);
			 
			 click(laptops);
			 Thread.sleep(1000);
			 click(lap);	
			 Thread.sleep(3000);
			 
			 
			 try {
				 click(agregar);
				 Thread.sleep(2000);
				    } catch (UnhandledAlertException f) {
				        try {
				            Alert alert = driver.switchTo().alert();
				            String alertText = alert.getText();
				            System.out.println("Alert data: " + alertText);
				            alert.accept();
				        } catch (NoAlertPresentException e) {
				            e.printStackTrace();
				        }
				    }
			
	}
		
		
		public void CerrarSesión() throws FileNotFoundException, IOException, InterruptedException {		
			
			 click(cerrar);
			 Thread.sleep(1000);
	}
			
	
}
