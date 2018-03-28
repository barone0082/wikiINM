package br.com.inmetrics.RegistroPonto.Apoio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/*
   <h1>Configurar Navegador Selenium</h1>
		Classe que configura o navegador utilizando o chromedriver e selenium
		
	  Autor: Ricardo Kohatsu
	*/
 
public class Navegador_java {
	private String nomeNavegador;
	
	public String getNomeNavegador() {
		return nomeNavegador;
	}

	public void setNomeNavegador(String nomeNavegador) {
		this.nomeNavegador = nomeNavegador;
	}

	public WebDriver configurarNavegador() {
	     switch (nomeNavegador.toUpperCase()) {  
	       case "CHROME":
	    	   ChromeOptions options= new ChromeOptions();
	    	   options.addArguments("--disable-extensions");
		   		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
				return new ChromeDriver(options);
	       default: 
	    	   System.out.println("Tipo de navegador não conhecido");  
	       	   return null;
	     }
	}
	
	public void acessarPaginaWeb(String url, WebDriver driver) {
		driver.get(url);
	}
}
