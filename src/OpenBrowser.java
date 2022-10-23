import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenBrowser {

		WebDriver wb;
		
		@Test
		@Parameters("browser")
		public void launch(String bname)
		{
			if(bname.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
				wb = new ChromeDriver();
			}
			
			else if(bname.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",".\\Driver\\geckodriver.exe");
				wb = new FirefoxDriver();
			}
			
			wb.manage().window().maximize();
			GoToPage obj = new GoToPage(wb);
			obj.openPage();
		}
		@Test
		public void flow()
		{
			
			
		}

}
