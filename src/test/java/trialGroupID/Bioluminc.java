package trialGroupID;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Bioluminc {
    @Test

    public void Nametest() throws InterruptedException {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Selenium drivers/chromedriver");
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--use-fake-ui-for-media-stream=1");
        options.addArguments("--use-file-for-fake-video-capture=/users/rahulmittapalli/Downloads/Facemap1.y4m");
        options.addArguments("--disable-user-media-security");
        options.addArguments("--use-fake-device-for-media-stream");
        driver = new ChromeDriver(options);
        driver.get("https://www.biolumincmirror.com/");
        driver.manage().window().maximize();
        WebDriverWait wait =new  WebDriverWait(driver, 10); 
        By addItem = By.id("getStarted");
        wait.until(ExpectedConditions.presenceOfElementLocated(addItem)).click();
        System.out.println("Clicked");
        Thread.sleep(15000);
        WebElement camera=driver.findElement(By.id("_drawing"));
        System.out.println("Camera is Displayed "+camera.isDisplayed());
        WebElement information=driver.findElement(By.id("_imageData"));
        System.out.println("Image is Displayed "+information.isDisplayed());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement product= driver.findElement(By.xpath("//*[@class='m_0 pt_15 LTMD_font']"));
        System.out.println("Product name is "+product.getText());
        String Name="NEW! biolumin-c serum";
        Assert.assertEquals(Name,product.getText());
        WebElement Button=driver.findElement(By.id("mainproduct"));
        js.executeScript("arguments[0].scrollIntoView();",product );
        System.out.println("Button visibility is "+Button.isDisplayed());
        Thread.sleep(5000);
        driver.close();
    }
}
