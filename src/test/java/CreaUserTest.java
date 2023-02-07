import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.test.evolution.CreaUser;

public class CreaUserTest {
	
	private WebDriver driver;
	CreaUser cre;

	@Before
	public void setUp() throws Exception {
		cre = new CreaUser(driver);
		driver = cre.chromeDriverConnection();
		cre.visit("https://epxstandardcoretesting.azurewebsites.net/Account/Login");
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		cre.loginUser();
		assertTrue(cre.loginSuccess());
		cre.selectPersonalizar();
		cre.fillForm();
	}

}
