package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class SeleniumFunctions {
    public static WebDriver driver = null;
    public static WebDriverWait waitVar = null;

    public static String baseURL = "https://github.com";

    public WebDriver createDriver() throws MalformedURLException,
            InterruptedException {
        File fileFF = new File("./src/drivers/chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(baseURL);

        waitVar = new WebDriverWait(driver, 15);
        return driver;
    }

    public void teardown() {
        driver.quit();
    }

    public void ishomepageDisplayed() {
        waitVar.until(ExpectedConditions.
                presenceOfElementLocated(By.linkText("Sing in")));

        driver.findElement(By.linkText("Sign in")).isDisplayed();
    }

    public  void clickSigninLink() {
        driver.findElement(By.linkText("Sign in")).click();
    }

    public void inputLogin(String login) {
        driver.findElement(By.id("user[login]")).clear();
        driver.findElement(By.id("user[login]")).sendKeys();
    }

    public void inputPassword(String pass) {
        driver.findElement(By.id("user[password]")).clear();
        driver.findElement(By.id("user[[password]]")).sendKeys();
    }

    public void loginToSite(String login, String pass) {
        driver.findElement(By.id("user[login]")).clear();
        driver.findElement(By.id("user[login]")).sendKeys();
        driver.findElement(By.id("user[password]")).clear();
        driver.findElement(By.id("user[[password]]")).sendKeys();
        driver.findElement(By.linkText("Sign in")).click();
    }

    public boolean isloginsectionDisplayed() {
        boolean isOpen = false;
        waitVar.until(ExpectedConditions.
                presenceOfElementLocated(By.className("auth-form-body")));
        waitVar.until(ExpectedConditions.
                presenceOfElementLocated(By.name("commit")));

        isOpen = (driver.findElement(By.className("auth-form-body")).
                isDisplayed())&&(driver.findElement(By.name("commit")).isDisplayed());

        return isOpen;
    }
}
