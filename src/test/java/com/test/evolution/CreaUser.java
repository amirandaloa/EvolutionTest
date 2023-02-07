package com.test.evolution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreaUser extends Base{
	
	public Boolean loginin;
	By userLocator = By.name("Login1$UserName");
	By passLocator = By.id("Login1_Password");
	By buttonIngresar = By.id("Login1_btnLogIn");
	By _personalizar = By.id("foo_list_13");
	By _particular = By.id("foo_bar_13_lbOpcion_1");
	By _btnnuevocontacto = By.id("MainContent_btnNuevoContacto");
	By _txtNombre = By.id("txtNombreContacto");
	By _txtApellido = By.id("txtPrimerApellido");
	By _txtDireccion = By.id("txtDirreccion");
	By _txtEmpresa = By.id("txtEmpresa");
	By _txtTelefono = By.id("txtTelefono");
	By _txtmail = By.id("txtEmail1");
	By _txtcargo = By.id("txtCargo");
	By _txtestrato = By.id("MainContent_wucCustomDataContact_rpIndices_txtData_0");
	By _dpt = By.id("MainContent_wucCustomDataContact_DropDownListDepartamento_chosen");
	By _iddpt = By.xpath("//li[@data-option-array-index='2']");
	By _ci = By.id("MainContent_wucCustomDataContact_DropDownListCiudad_chosen");
	By _idci = By.xpath("//li[@data-option-array-index='6']");
	By _sendInfo = By.id("MainContent_wucCustomDataContact_ckAutorizacionElec");
	By _saveInfo = By.id("MainContent_btnGuardarContacto");
	
	String _nombre = "";
	String _apellido = "";
	String _usuario = "";
	String _paswd = "";
	String _email = "";
	String _telefono = "";
	String _empresa = "";
	String _estrato = "";
	String _cargo = "";
	String _direccion = "";

public CreaUser(WebDriver driver){
	//TODO: here
	super(driver);
}

public void loginUser() throws InterruptedException, IOException {
	
	
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

                if(val.toString().trim().toLowerCase().contains("nombre")) {

                	_nombre = _ln[1];
                }
                else if(val.toString().trim().toLowerCase().contains("apellido")) {
              
                	_apellido = _ln[1];
                }
                else if(val.toString().trim().toLowerCase().contains( "usuario")) {
                
                	_usuario = _ln[1];
                }
                else if(val.toString().trim().toLowerCase().contains("paswd")) {
                
                	_paswd = _ln[1];
                }
                else if(val.toString().trim().toLowerCase().contains("email")) {
                
                	_email = _ln[1];
                }
                else if(val.toString().trim().toLowerCase().contains("telefono")) {
                	_telefono = _ln[1];
                }
                else if(val.toString().trim().toLowerCase().contains("empresa")) {
                	
                	_empresa = _ln[1];
                }
                else if(val.toString().trim().toLowerCase().contains("estrato")) {
              
                	_estrato = _ln[1];
                }
                else if(val.toString().trim().toLowerCase().contains("cargo")) {
               
                	_cargo = _ln[1];
                }
                else if(val.toString().trim().toLowerCase().contains("direccion")) {
                
                	_direccion = _ln[1];
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

public void selectPersonalizar() throws InterruptedException
{
	Thread.sleep(5000);
	click(_personalizar);
	Thread.sleep(5000);
	click(_particular);
	Thread.sleep(5000);
	click(_btnnuevocontacto);
	Thread.sleep(5000);
}

public void fillForm() throws InterruptedException {
	Thread.sleep(5000);
	type(_nombre, _txtNombre);
	type(_apellido, _txtApellido);
	type(_direccion, _txtDireccion);
	type(_empresa, _txtEmpresa);
	type(_telefono, _txtTelefono);
	type(_email, _txtmail);
	type(_cargo,_txtcargo);
	type(_estrato, _txtestrato);
	Thread.sleep(5000);
	click(_dpt);
	Thread.sleep(5000);
	click(_iddpt);
	Thread.sleep(5000);
	click(_ci);
	Thread.sleep(5000);
	click(_idci);
	Thread.sleep(5000);
	click(_sendInfo);
	Thread.sleep(5000);
	click(_saveInfo);
	Thread.sleep(10000);
}


}