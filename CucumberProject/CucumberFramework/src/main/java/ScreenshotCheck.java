import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotCheck {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.amazon.in");
		
		driver.manage().window().maximize();
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);		
		File Destfile = new File("C:\\Users\\612627350\\OneDrive - BT Plc\\Desktop\\amazon.png");
		
		FileUtils.copyFile(srcFile, Destfile);
		
		

	}

}
