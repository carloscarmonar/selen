package pruebaSelenium;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstTest {
	private WebDriver _driver;

	@Before
	public void iniciarBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Programas\\eclipse\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();  //maximizo mi browser
		_driver = driver;
	}

	@Test
	public void generarConsulta() throws Exception {
		_driver.get("https://www.google.com/");
		assertEquals("Google", _driver.getTitle());
		_driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).clear();
		_driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("selenium");
		_driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
		_driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		assertEquals("Selenium - Web Browser Automation", _driver.getTitle());
	}

	@After
	public void terminarBrowser() throws Exception {
//	_driver.quit();
	}
}
