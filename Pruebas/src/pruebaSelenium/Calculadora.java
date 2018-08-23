package pruebaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calculadora {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Programas\\eclipse\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();  //maximizo mi browser
        // #2 Le indico al webdriver que visite la URL
        driver.get("https://www.calculator.net//");
        
        //Ingresamos a la página de porcentajes:
        driver.findElement(By.xpath("//*[@id=\"hl3\"]/li[3]/a")).click();
        
        // Ingresamos los valores que realizaremos para la prueba.
        driver.findElement(By.xpath("//*[@id=\"cpar1\"]")).sendKeys("10");
        driver.findElement(By.xpath("//*[@id=\"cpar2\"]")).sendKeys("90");
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr[2]/td/input[2]")).click();
        
        System.out.println("Resultado -> " + driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText());
        
        //Se comentarea dado que cierra el script
        //driver.close();
	}
}
