import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.test.evolution.Login;

public class loginTest {
	
	private WebDriver driver;
	Login proc;

	@Before
	public void setUp() throws Exception {
		proc = new Login(driver);
		driver = proc.chromeDriverConnection();
		proc.visit("https://epxstandardcoretesting.azurewebsites.net/Account/Login");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		proc.loginUser();;
		Thread.sleep(2000);
		assertTrue(proc.loginSuccess());
	}

}
