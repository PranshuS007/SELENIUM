import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;



public class Main9 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Test");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("User");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("User1");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("testUser1@xyz.com");
		Thread.sleep(1500);
		
		WebElement radio = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		boolean select = radio.isEnabled();
		
		if(select == true) {
			radio.click();
		}
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("1234567890");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
		Thread.sleep(1500);
		
		
		Select year = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		year.selectByVisibleText("1997");
		Thread.sleep(1500);
		
		
        Select month = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		month.selectByVisibleText("May");
		Thread.sleep(1500);
		
		
		driver.findElement(By.className("react-datepicker__day--010")).click();
		Thread.sleep(1500);
		
		
		WebElement subject1= driver.findElement(By.id("subjectsInput"));
	    subject1.sendKeys("English");
	    subject1.sendKeys(Keys.ARROW_DOWN);
	    subject1.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		WebElement subject2= driver.findElement(By.id("subjectsInput"));
	    subject2.sendKeys("Hindi");
	    subject2.sendKeys(Keys.ARROW_DOWN);
	    subject2.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		WebElement radio1 = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
		boolean hobbie = radio1.isEnabled();
		
		if(hobbie == true) {
			radio1.click();
		}
		Thread.sleep(1500);
		
		WebElement uploadElement = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		
		uploadElement.sendKeys("C:\\Users\\Pranshu Sharma\\Pictures\\Screenshots\\Screenshot (44).png");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("BERMUDA TRIANGLE");
		Thread.sleep(1500);
		
		
		
		WebElement state= driver.findElement(By.id("react-select-3-input"));
	    state.sendKeys("NCR");
	    state.sendKeys(Keys.ARROW_DOWN);
	    state.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		WebElement city= driver.findElement(By.id("react-select-4-input"));
	    city.sendKeys("Delhi");
	    city.sendKeys(Keys.ARROW_DOWN);
	    city.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		
		
		driver.findElement(By.xpath("//button[@id='submit']")).submit();
		Thread.sleep(2000);
		
		//NEW TAB AND NEW URL
		
		driver.switchTo().newWindow(WindowType.TAB);
		
        driver.get("http://jqueryui.com/droppable/");
		
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		
		WebElement From =  driver.findElement(By.id("draggable"));
		
		WebElement To = driver.findElement(By.id("droppable"));
		Thread.sleep(1500);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(From, To).perform();
		
		Thread.sleep(1000);
		
		driver.navigate().back();
		Thread.sleep(1000);
		
		//NEW WINDOW
		
        driver.get("https://demoqa.com/browser-windows");
        driver.navigate().refresh();
		
		String originalWindow = driver.getWindowHandle();
		System.out.println(originalWindow);
		
		
		
	    driver.findElement(By.xpath("//button[@id='windowButton']")).click();
	    
	    for (String windowHandle : driver.getWindowHandles()) {
	        if(!originalWindow.contentEquals(windowHandle)) {
	            driver.switchTo().window(windowHandle);
	            System.out.println(windowHandle);
	            break;
	            
	        }
	    }
	    Thread.sleep(1500);
	    driver.close();
	    
	    Thread.sleep(3000);
	    driver.quit();
		
	}
	
}