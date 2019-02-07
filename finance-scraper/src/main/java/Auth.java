import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
import java.util.List;

public class Auth {


    public static void webClient(String loginUrl, String username, String password, String portfolioUrl) {
        System.setProperty("webdriver.gecko.driver", "/Library/Java/Extensions/geckodriver");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        FirefoxOptions options = new FirefoxOptions();
        options.setLogLevel(FirefoxDriverLogLevel.ERROR);
        try {

//          1. GOTO YAHOO FINANCE LOGIN URL
            driver.navigate().to(loginUrl);
            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Page URL: " + driver.getCurrentUrl());

        } catch (Exception e) {

            System.out.println("Could not find URL!");
            e.printStackTrace();
            driver.quit();
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
            driver.quit();
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
            driver.quit();
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
            driver.quit();
        }


        try {
//          5. CLICK 'SIGN-IN' BUTTON
//            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-signin")));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-signin"))).click();

//            System.out.println("signInButton: " + signInButton);
//            signInButton.click();
            System.out.println("'Sign-in' button clicked...");

        } catch (Exception e) {
            System.out.println("Error hitting 'sign-in' button!");
            e.printStackTrace();
            driver.quit();
        }

        try {
//          7. SCRAPE TABLE
            var Data = new Data();
            System.out.println("Starting scraper...");
            WebElement tableRow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[3]/div[2]/div/div/div/div/div/div[3]/div/div/section/div/section[1]/table/tbody/tr[1]")));

            System.out.println("Table Row: " + tableRow);

            List<WebElement> stockData = driver.findElements(By.cssSelector("#data-util-col > section:nth-child(1) > table > tbody > tr > td"));

            List<List<String>> stockList = new ArrayList<>();

            List<String> singleStock = new ArrayList<>();

            int totalDataPointsPerStock = 5;

            for (WebElement stockDataCell : stockData) {
                singleStock.add(stockDataCell.getAttribute("innerText").trim());
                if (singleStock.size() == totalDataPointsPerStock) {
                    stockList.add(singleStock);

                    String fullCompanyName = singleStock.get(0);
                    System.out.println("fullCompanyName: " + fullCompanyName);

                    String[] companyNameAndSymbol = singleStock.get(0).split("\\r?\\n");
                    System.out.println("companyNameAndSymbol: " + companyNameAndSymbol);

                    String symbol = companyNameAndSymbol[1];
                    System.out.println("symbol: " + symbol);

                    String companyName = companyNameAndSymbol[0];
                    System.out.println("companyName: " + companyName);

                    String lastPrice = singleStock.get(1);
                    String change = singleStock.get(2);
                    String percentChange = singleStock.get(3);

                    Data.insert(symbol, companyName, lastPrice, change, percentChange);

                    singleStock = new ArrayList<>();
                }
            }

            System.out.println(stockList);
            driver.quit();

        } catch (Exception e) {
            System.out.println("Could not scrape table!");
            e.printStackTrace();
            driver.quit();
        }
    }
}
