package nopcommerce1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkoutFlow {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
	
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
		
		WebElement login = driver.findElement(By.className("ico-login"));
		login.click();
		
		WebElement email = driver.findElement(By.name("Email"));
		email.sendKeys("email123@email.email");
		
		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("Password");
		
		WebElement loginBtn = driver.findElement(By.className("login-button"));
		loginBtn.click();
		
		WebElement opnPrd = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[2]/button[1]"));
		opnPrd.click();
		Thread.sleep(2000);
		
		WebElement ram = driver.findElement(By.name("product_attribute_2"));
		Select drp = new Select(ram);
		drp.selectByValue("5");
		
		
		WebElement hdd = driver.findElement(By.xpath("//*[@id=\"product_attribute_3_7\"]"));
		hdd.click();
	
		
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button-1"));
		addToCart.click();
		
		WebElement cart = driver.findElement(By.className("cart-label"));
		cart.click();
		
		WebElement checkBox = driver.findElement(By.id("termsofservice"));
		checkBox.click();
		
		WebElement checkout = driver.findElement(By.id("checkout"));
		checkout.click();
		
	}

}
