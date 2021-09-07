package PruebaMovil;
/**
 * Clase que contiene valores generales para el caso de prueba
 * 
 * @author Carlos Laynes
 * @since 02/12/2020
 * @version 1.0
 * 
 */


public class RutasGenerales {
	
	private static String rutaDriverChrome=System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe";
	private static String rutaDriverFirefox=System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe";
	private static String rutaDriverIE=System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\IEDriverServer.exe";
	private static String rutaDriverEdge=System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\msedgedriver.exe";
	private static String rutaDriverOpera=System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\operadriver.exe";
	private static String rutaProperties=System.getProperty("user.dir")+"\\src\\test\\resources\\files\\parametros.properties";
    private static String rutaCarpetaContenedoraInputs=System.getProperty("user.dir") + "\\src\\test\\resources\\files\\Inputs.xlsx";
	
	
	/*
	 * M�todo que retorna la ruta del driver de Chrome
	 */
	public String rutaDriverChrome() {
		return rutaDriverChrome;
	}
	
	/*
	 * M�todo que retorna la ruta del driver de Firefox
	 */
	public String rutaDriverFirefox() {
		return rutaDriverFirefox;
	}
	
	/*
	 * M�todo que retorna la ruta del driver de Internet Explorer
	 */
	public String rutaDriverIE() {
		return rutaDriverIE;
	}
	
	/*
	 * M�todo que retorna la ruta del driver de Microsoft Edge
	 */
	public String rutaDriverEdge() {
		return rutaDriverEdge;
	}
	
	/*
	 * M�todo que retorna la ruta del driver de Opera
	 */
	public String rutaDriverOpera() {
		return rutaDriverOpera;
	}
	
	/*
	 * M�todo que retorna la ruta del archivo properties
	 */
	public String rutaProperties() {
		return rutaProperties;
	}
	
	/*
	 * M�todo que retorna la ruta del archivo properties
	 */

	
	/*
	 * M�todo que retorna la ruta del excel Inputs
	 */
	public String rutaInputs() {
		return rutaCarpetaContenedoraInputs;
	}
	
}