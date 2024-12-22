import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Declare WebDriverWait as a local variable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Initialize it here

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // From Login
        driver.findElement(By.id("inputUsername")).sendKeys("Eduwork");
        driver.findElement(By.name("inputPassword")).sendKeys("CourseEduwork");
        driver.findElement(By.className("submit")).click();

        // Use the local wait instance
        WebElement elementMessageIncorrect = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("p.error")));
        System.out.println("Message Incorrect : " + elementMessageIncorrect.getText());

        // Forgot Your Password ?
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Admin Eduwork");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("andika@eduwork.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("081239283922");

        // Use the local wait instance again
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("button.reset-pwd-btn")));
        WebElement buttonResetLogin = driver.findElement(By.cssSelector("button.reset-pwd-btn"));
        buttonResetLogin.click();

        WebElement MessageResetSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.infoMsg")));
        System.out.println("Message Success Reset : " + MessageResetSuccess.getText());

        // Close Browsers
        driver.quit();
    }
}