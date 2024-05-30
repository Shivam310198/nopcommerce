package nopcommerce1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SessionManager;

public class checkoutFlow {
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
	
		driver.manage().window().maximize();
		
//		driver.get("https://demo.nopcommerce.com/");
//		Thread.sleep(2000);
		
		driver.get("https://demo.nopcommerce.com/cart");
		Thread.sleep(1500);
//		WebElement login = driver.findElement(By.className("ico-login"));
//		login.click();
//		
//		WebElement email = driver.findElement(By.name("Email"));
//		email.sendKeys("email123@email.email");
//		
//		WebElement password = driver.findElement(By.id("Password"));
//		password.sendKeys("Password");
//		
//		WebElement loginBtn = driver.findElement(By.className("login-button"));
//		loginBtn.click();
		
		SessionManager sessionManager = new SessionManager(driver);
		sessionManager.usePreviousLoggedInSession("nopcommerce");
		
//		SessionManager sessionManager = new SessionManager(driver);
//		sessionManager.storeSessionFile("nopcommerce", "email123@email.email");
		
//		WebElement opnPrd = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[2]/button[1]"));
//		opnPrd.click();
//		Thread.sleep(2000);
//		
//		WebElement ram = driver.findElement(By.name("product_attribute_2"));
//		Select drp = new Select(ram);
//		drp.selectByValue("5");
//		
//		
//		WebElement hdd = driver.findElement(By.xpath("//*[@id=\"product_attribute_3_7\"]"));
//		hdd.click();
//	
//		
//		WebElement addToCart = driver.findElement(By.id("add-to-cart-button-1"));
//		addToCart.click();
//		
//		WebElement cart = driver.findElement(By.className("cart-label"));
//		cart.click();
		
		WebElement checkBox = driver.findElement(By.xpath("//div/input[@id= 'termsofservice']"));
		checkBox.click();
		
		WebElement checkout = driver.findElement(By.id("checkout"));
		checkout.click();
		
		//Checkout page
		Thread.sleep(1500);
		WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
		Select count = new Select(country);
		count.selectByValue("133");
		
		Thread.sleep(1500);
		WebElement state = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
		Select stt = new Select(state);
		stt.selectByValue("0");
		
		WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
		city.sendKeys("Noida");
		
		WebElement address1 = driver.findElement(By.id("BillingNewAddress_Address1"));
		address1.sendKeys("Cetpa");
		
		WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
		zipCode.sendKeys("201301");
		
		WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
		phoneNumber.sendKeys("1234567890");
		
		WebElement firstContinue = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[2]"));
		firstContinue.click();
		
		//Shipping Method
		Thread.sleep(2000);
		WebElement shippingMtd = driver.findElement(By.id("shippingoption_1"));
		shippingMtd.click();
		
		WebElement scndContinue = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
		scndContinue.click();
		
		
		//Payment method - Credit Card
		/*WebElement pymntMtd = driver.findElement(By.id("paymentmethod_1"));
		pymntMtd.click();
		
		WebElement cCard = driver.findElement(By.id("CreditCardType"));
		Select cc = new Select(cCard);
		cc.selectByValue("Discover");
		
		WebElement cName = driver.findElement(By.id("CardholderName"));
		cName.sendKeys("Shivam");
		
		WebElement cMonth = driver.findElement(By.id("ExpireMonth"));
		Select cm = new Select(cMonth);
		cm.selectByValue("10");
		
		WebElement cYear = driver.findElement(By.id("ExpireYear"));
		Select cy = new Select(cYear);
		cy.selectByValue("2026");
		
		WebElement cCode = driver.findElement(By.id("CardCode"));
		cCode.sendKeys("123");
		
		WebElement thrdContinue = driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button"));
		thrdContinue.click();*/
		
		//Payment method - Cash
		Thread.sleep(2000);
		WebElement pymntMtd = driver.findElement(By.id("paymentmethod_0"));
		pymntMtd.click();
		
		WebElement thrdContinue = driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button"));
		thrdContinue.click();
		
		//Cash address
		Thread.sleep(2000);
		WebElement frthContinue = driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button"));
		frthContinue.click();
		
		//Confirm order page
		Thread.sleep(2000);
		WebElement finalContinue = driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
		finalContinue.click();
		
		Thread.sleep(2000);
		driver.close();
		
		
		
		
	}

}
