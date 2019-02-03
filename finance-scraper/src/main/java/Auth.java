import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auth {


    public static void webClient(String url, String firstName, String lastName, String email, String phone, String message) {

        System.setProperty("webdriver.gecko.driver", "/Library/Java/Extensions/geckodriver");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);


        try{
            driver = new FirefoxDriver();
            driver.navigate().to(url);

            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Page URL: " + driver.getCurrentUrl());

            WebElement formTriggerButton = driver.findElement(By.xpath("/html/body/div/div/div/div/section/div/div/div/a/button"));
            formTriggerButton.click();
            System.out.println("Form trigger button clicked!");

            WebElement firstNameInput = driver.findElement(By.xpath("//*[@id=\"firstNameInput\"]"));
            firstNameInput.sendKeys(firstName);

            WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"lastNameInput\"]"));
            lastNameInput.sendKeys(lastName);

            WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"emailInput\"]"));
            emailInput.sendKeys(email);

            WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"phoneInput\"]"));
            phoneInput.sendKeys(phone);

            WebElement messageInput = driver.findElement(By.xpath("//*[@id=\"messageInput\"]"));
            messageInput.sendKeys(message);

            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/section/div[2]/div/form/div/input[8]"));
            submitButton.click();
            System.out.println("Form submitted successfully!");
        } catch(Exception e) {
            System.out.println("Cannot open Firefox!");
            e.printStackTrace();
            driver.close();
        }





    }
}
