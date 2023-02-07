package com.test.evolution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base{
	
	public Boolean loginin;
	By userLocator = By.name("Login1$UserName");
	By passLocator = By.id("Login1_Password");
	By buttonIngresar = By.id("Login1_btnLogIn");
	
	public Login(WebDriver driver){
		//TODO: here
		super(driver);
	}
	
	public void loginUser() throws InterruptedException, IOException {
		
		String _usuario = "";
		String _paswd = "";

		
		if(isDisplayed(userLocator))
		{	
			BufferedReader br = null;

	        try {

	            String sCurrentLine;

	            br = new BufferedReader(new FileReader("C:\\Users\\user\\eclipse-workspace\\CucumberTest\\src\\test\\java\\com\\test\\evolution\\ConfigRun.txt"));

	            String val = "";
	            
	            while ((sCurrentLine = br.readLine()) != null) {
	            	
	                System.out.println(sCurrentLine);
	                String[] _ln = sCurrentLine.split(":");
	                
	                val = _ln[0].toString();

	                if(val.toString().trim().toLowerCase().contains( "usuario")) {
	                	_usuario = _ln[1];
	                }
	                else if(val.toString().trim().toLowerCase().contains("paswd")) {
	                	_paswd = _ln[1];
	                }
	                             
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (br != null)br.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }

										
			type(_usuario,userLocator);
			type(_paswd,passLocator);
			click(buttonIngresar);
			Thread.sleep(5000);
			this.loginin = true;
		}else {
			this.loginin = false;
			System.out.println("User element was not found");
		}
	}
	
	public Boolean loginSuccess() {
		return this.loginin;
	}
	


}