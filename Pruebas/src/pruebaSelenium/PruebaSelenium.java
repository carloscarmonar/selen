package pruebaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PruebaSelenium {
	public static void main(String[] args) throws Exception{
		String exePath = "D:\\Programas\\eclipse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();  //maximizo mi browser
        // #2 Le indico al webdriver que visite la URL
        driver.get("http://demoregistro.sqamexico.com/");
        
        // #3 Manipulo mis objetos
        //  A) Forma de manipular un objeto, usando WebElement
        WebElement nombre = driver.findElement(By.id("txt_name"));
        nombre.sendKeys("Mr Robot");
        //  B) Forma de manipular un objeto, usando Webdriver directo
        driver.findElement(By.name("txt_user")).sendKeys("root");
        
        //  C) Manipular un Combobox 
        Select combo = new Select (driver.findElement(By.id("cmb_pais"))  );
        combo.selectByValue("Mexico");
        
        combo = new Select (driver.findElement(By.id("cmb_ciudad"))  );
        combo.selectByValue("Jalisco");
        
        // Manipulando un checkbox
        WebElement checkbox_correr = driver.findElement(By.id("chk_hobbie-3"));
        if (!checkbox_correr.isSelected()) //valido que NO este seleccionado para seleccionarlo
        	checkbox_correr.click();
        
        
        // Doy click en el boton submit
        WebElement boton = driver.findElement(By.id("btnsubmit"));
        boton.click();
        
        
        
        
        // #4 Agrego un punto de verificación, para validar que el registro fue dado de alta
        WebElement confirmacion = driver.findElement(By.id("registrationok"));
        
        if (!confirmacion.getText().contains("Perfecto! el registro fue dado de alta correctamente")){
        	System.out.println("Hubo un error");
        	//log.severe("Hubo un error en el registro");
        	return;
        }
        
        System.out.println("Registro completado!");
       //log.info("Registro completado con éxito!!!");
        
        
        //Duermo el proceso para ver las modificaciones
        Thread.sleep(10000);
        
        // #5 Cierro el browser
        driver.close();
	}
}
