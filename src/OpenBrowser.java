import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenBrowser {

		WebDriver driver;
		
		@Test
		@Parameters("browser")
		public void launch(String bname)
		{
			if(bname.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			else if(bname.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",".\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.get("https:\\www.google.com");
			System.out.println(driver.getTitle());
		}

}
