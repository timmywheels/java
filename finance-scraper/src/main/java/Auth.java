import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Auth {


    public static void webClient(String loginUrl, String username, String password, String portfolioUrl) {
        System.setProperty("webdriver.gecko.driver", "/Library/Java/Extensions/geckodriver");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {

//          1. GOTO YAHOO FINANCE LOGIN URL
            driver.navigate().to(loginUrl);
            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Page URL: " + driver.getCurrentUrl());

        } catch (Exception e) {

            System.out.println("Could not find URL!");
            e.printStackTrace();
//            driver.quit();
        }


        try {
//          2. ENTER USERNAME
            WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-username")));
            System.out.println("usernameInput:" + usernameInput);
            usernameInput.sendKeys(username);
            System.out.println("Username entered...");

        } catch (Exception e) {
            System.out.println("Error entering username!");
            e.printStackTrace();
//            driver.quit();
        }


        try {
//          3. CLICK 'NEXT' BUTTON
            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-signin")));
            System.out.println("nextButton: " + nextButton);
            nextButton.click();
            System.out.println("'Next' button clicked...");

        } catch (Exception e) {
            System.out.println("Error hitting 'next' button!");
            e.printStackTrace();
//            driver.quit();
        }


        try {
//          4. ENTER PASSWORD
            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-passwd")));

            System.out.println("passwordInput: " + passwordInput);
            passwordInput.sendKeys(password);
            System.out.println("Password entered...");


        } catch (Exception e) {
            System.out.println("Error entering password!");
            e.printStackTrace();
//            driver.quit();
        }


        try {
//          5. CLICK 'SIGN-IN' BUTTON
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-signin")));
            System.out.println("signInButton: " + signInButton);
            signInButton.click();
            System.out.println("'Sign-in' button clicked...");

        } catch (Exception e) {
            System.out.println("Error hitting 'sign-in' button!");
            e.printStackTrace();
//            driver.quit();
        }

//        try {
//////            WebElement myPortfolioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("My Portfolio")));
////            myPortfolioButton.click();
////            System.out.println("myPortfolioButton: " + myPortfolioButton);
////            System.out.printf("Portfolio button clicked...");
////
////            WebElement myWatchListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("My Watchlist")));
////            System.out.println("myWatchListButton: " + myWatchListButton);
////            myWatchListButton.click();
////            System.out.println("Watchlist button clicked!");
////          6. NAVIGATE TO PORTFOLIO
////            driver.get(portfolioUrl);
////            System.out.println("Navigated to portfolio page");
//
//        } catch (Exception e) {
//            System.out.println("Could not navigate to portfolio!");
//            e.printStackTrace();
////            driver.quit();
//        }

        try {
//          7. SCRAPE TABLE
//            WebElement tableRow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pf-detail-table']/div[1]/table/tbody/tr[1]")));
            WebElement tableRow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[3]/div[2]/div/div/div/div/div/div[3]/div/div/section/div/section[1]/table/tbody/tr[1]")));

            System.out.println("Table Row: " + tableRow);

            //td[@aria-label="Symbol"]

//            List<WebElement> symbols =  driver.findElements(By.xpath("//a[contains(@href,'quote')]"));
            List<WebElement> symbols = driver.findElements(By.cssSelector("#data-util-col > section:nth-child(1) > table > tbody > tr > td"));
            for(WebElement symbol : symbols){
                System.out.println("Symbol: " + symbol.getAttribute("innerHTML"));
            }
//            System.out.println("Page: " + driver.getPageSource());

        } catch (Exception e) {
            System.out.println("Could not scrape table!");
            e.printStackTrace();
//            driver.quit();
        }
    }
}
