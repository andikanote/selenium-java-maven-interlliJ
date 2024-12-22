import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumTestLogin {

    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Enter incorrect username
        WebElement usernameInput = driver.findElement(By.id("inputUsername"));
        usernameInput.sendKeys("wrongUsername");

        // Enter incorrect password
        WebElement passwordInput = driver.findElement(By.name("inputPassword"));
        passwordInput.sendKeys("wrongPassword");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.className("submit"));
        loginButton.click();

        // Wait for the error message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));

        // Print the error message
        System.out.println("Error Message: " + errorMessage.getText());

        // Close the browser
        driver.quit();
    }

}


