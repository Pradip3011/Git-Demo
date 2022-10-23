import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToPage {

	WebDriver wb;
	public GoToPage(WebDriver wb)
	{
		this.wb=wb;
	}
	public void openPage()
	{
		wb.navigate().to("https://www.pedigree.in//");
		wb.findElement(By.xpath("//a[text()='Why']")).click();
		wb.findElement(By.xpath("//div[@class='shopping']")).click();
		String parentWindow=wb.getWindowHandle();
		wb.findElement(By.xpath("//a[@id='dtc_buy_link']")).click();
		Set<String> allwindows = wb.getWindowHandles();
		int count = allwindows.size();
		System.out.println("Total window "+count);
		for(String child : allwindows)
		{
			if(!parentWindow.equalsIgnoreCase(child))
			{
				wb.switchTo().window(child);
				wb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Switch to Child window");
				WebElement text=wb.findElement(By.xpath("//h2[text()='Dry Food']"));
				String value=text.getText();
				System.out.println("Text content is : "+value);
				List<WebElement> products = wb.findElements(By.xpath("//*[@class='sf__pcard-content text-left']"));
		        System.out.println(products.size());
		        for (WebElement Elements : products) 
		        {
		            String name = Elements.getText();
		            System.out.println("Product_Name : "+name.substring(0, 20));
		        }
				wb.close();
			}
		}
		wb.switchTo().window(parentWindow);
		System.out.println("Switch back to Parent window : " + parentWindow);
		
	}

}
