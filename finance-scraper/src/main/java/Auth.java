import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auth {


    public static void webClient(String loginUrl, String username, String password, String portfolioUrl) {
        System.setProperty("webdriver.gecko.driver", "/Library/Java/Extensions/geckodriver");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try {

//          1. GOTO YAHOO FINANCE LOGIN URL
            driver.navigate().to(loginUrl);
            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Page URL: " + driver.getCurrentUrl());

        } catch (Exception e) {

            System.out.println("Could not find URL!");
            e.printStackTrace();
            driver.close();
        }


        try {
//          2. ENTER USERNAME
            WebElement usernameInput = driver.findElement(By.id("login-username"));
            usernameInput.sendKeys(username);
            System.out.println("Username entered...");

        } catch (Exception e) {
            System.out.println("Error entering username!");
            e.printStackTrace();
            driver.close();
        }


        try {
//          3. CLICK 'NEXT' BUTTON
            WebElement nextButton = driver.findElement(By.id("login-signin"));
            nextButton.click();
            System.out.println("'Next' button clicked...");

        } catch (Exception e) {
            System.out.println("Error hitting 'next' button!");
            e.printStackTrace();
            driver.close();
        }


        try {
//          4. ENTER PASSWORD
            WebElement passwordInput = driver.findElement(By.id("login-passwd"));
            passwordInput.sendKeys(password);
            System.out.println("Password entered...");

        } catch (Exception e) {
            System.out.println("Error entering password!");
            e.printStackTrace();
            driver.close();
        }


        try {
//          5. CLICK 'SIGN-IN' BUTTON
            WebElement signInButton = driver.findElement(By.id("login-signin"));
            signInButton.click();
            System.out.println("'Sign-in' button clicked...");

        } catch (Exception e) {
            System.out.println("Error hitting 'sign-in' button!");
            e.printStackTrace();
            driver.close();
        }


        try {
//          6. NAVIGATE TO PORTFOLIO
            driver.navigate().to(portfolioUrl);

        } catch (Exception e) {
            System.out.println("Could not navigate to portfolio!");
            e.printStackTrace();
            driver.close();
        }


        try {
//          7. SCRAPE TABLE
            WebElement tableRow = driver.findElement(By.xpath("//tr"));
            System.out.println("Table Row: " + tableRow);

            System.out.println("Page: " + driver.getPageSource());

        } catch (Exception e) {
            System.out.println("Could not scrape table!");
            e.printStackTrace();
            driver.close();
        }
    }
}
