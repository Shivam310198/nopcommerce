package nopcommerce1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class registration {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
	
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
		Thread.sleep(2000);
		
		WebElement register = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
		register.click();
		
		WebElement gender = driver.findElement(By.id("gender-male"));
		gender.click();
		
		WebElement firstName = driver.findElement(By.id("FirstName"));
		firstName.sendKeys("Shivam");
		
		WebElement lastName = driver.findElement(By.id("LastName"));
		lastName.sendKeys("Agrawal");
		
		WebElement day = driver.findElement(By.name("DateOfBirthDay"));
		Select drpDay = new Select(day);
		drpDay.selectByValue("31");
		
		WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
		Select drpMonth = new Select(month);
		drpMonth.selectByValue("1");
		
		WebElement year = driver.findElement(By.name("DateOfBirthYear"));
		Select drpYear = new Select(year);
		drpYear.selectByValue("1998");
		
		WebElement email = driver.findElement(By.name("Email"));
		email.sendKeys("email123@email.email");
		
		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("Password");
		

		WebElement cnfPassword = driver.findElement(By.id("ConfirmPassword"));
		cnfPassword.sendKeys("Password");
		
		WebElement registerBtn = driver.findElement(By.id("register-button"));
		registerBtn.click();
		
		driver.close();
		
	}

}
