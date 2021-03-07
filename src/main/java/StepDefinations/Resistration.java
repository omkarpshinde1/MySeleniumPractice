package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Resistration

{
    public WebDriver driver;
    @Given("user open the browser")
    public void user_open_the_browser() {
        // Write code here that turns the phrase above into concrete actions
       System.setProperty("webdriver.chrome.driver","D://software//BrowserDriver//chromedriver.exe");
      //  System.setProperty("webdriver.gecko.driver","D://software//BrowserDriver//geckodriver.exe");
      driver=new ChromeDriver();
      //  driver=new FirefoxDriver();

    }
    @When("user see the Register page")
    public void user_see_the_register_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.naukri.com/");

      driver.manage().window().maximize();


    }
    @Then("User able to fill all the details on page")
    public void user_able_to_fill_all_the_details_on_page() throws IOException {
        // Write code here that turns the phrase above into concrete actions

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul[1]/li[7]/a/div")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/form/div[2]/input")).sendKeys("Your Email ID");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/form/div[3]/input")).sendKeys("Your Password");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/form/div[6]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("We have Successfully logged in Naukari profile");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Set<String> winId = driver.getWindowHandles();
        Iterator<String> it = winId.iterator();
        String mainWindow = it.next();
        String firstPopup = it.next();
        String secondPopup = it.next();
        String thirdPopup = it.next();
        System.out.println("Main Window Id is "+mainWindow);
        driver.switchTo().window(firstPopup);
        driver.close();
        driver.switchTo().window(secondPopup);
        driver.close();
        driver.switchTo().window(thirdPopup);
        driver.close();
        driver.switchTo().window(mainWindow);
        WebElement naukriMenu = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul[2]/li[2]/a"));
        Actions builder = new Actions(driver);
        builder.moveToElement(naukriMenu).moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div/div/ul[2]/li[2]/div/ul[1]/li[1]/a"))).contextClick(driver.findElement(By.xpath("//a[@title='Edit Profile']"))).click().build().perform();
        driver.findElement(By.xpath("//*[@id=\"lazyResumeHead\"]/div/div/div/div[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"resumeHeadlineTxt\"]")).sendKeys(" ");
        driver.findElement(By.xpath("/html/body/div[5]/div[8]/div[2]/form/div[3]/div/button")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        System.out.println("Your Profile is Successfully Updated....");
        try {
            Files.deleteIfExists(Paths.get("C:\\Users\\Ashwini\\IdeaProjects\\MySeleniumPractice\\MyScreenshot.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        TakesScreenshot screens=((TakesScreenshot)driver);
        File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(s, new File("MyScreenshot.jpg"));
        driver.quit();


    }
}
