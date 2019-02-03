import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.AbstractJavaScriptEngine;


import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class Auth {

    public static WebClient autoLogin(String loginUrl, String login, String password) throws FailingHttpStatusCodeException, MalformedURLException, IOException {

        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

        WebClient client = new WebClient(BrowserVersion.FIREFOX_52);
        client.setAjaxController(new NicelyResynchronizingAjaxController());
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

//      1. GOTO LOGIN PAGE
        HtmlPage page = client.getPage(loginUrl);


//      2. ENTER EMAIL/USERNAME
        try {
            HtmlTextInput usernameInput = page.getFirstByXPath("//*[@id=\"login-username\"]");
            usernameInput.setValueAttribute(login);
            System.out.println("usernameInput: " + usernameInput);
        } catch (Exception e) {
            e.printStackTrace();
        }


//      3. CLICK 'NEXT' BUTTON
        try {
            HtmlSubmitInput loginButtonOne = page.getFirstByXPath("//*[@id=\"login-signin\"]");
            System.out.println("loginButtonOne:" + loginButtonOne);
            page = loginButtonOne.click();
            System.out.println("'Next' button clicked!");
        } catch (Exception e) {
            e.printStackTrace();
        }


//      4. ENTER PASSWORD
        try {
            HtmlInput passwordInput = page.getFirstByXPath("//*[@id=\"login-passwd\"]");
            passwordInput.setValueAttribute(password);
            System.out.println("passwordInput: " + passwordInput);

        } catch (Exception e) {
            e.printStackTrace();
        }


//      5. CLICK 'SIGN-IN' BUTTON
        try {
//            client.getOptions().setJavaScriptEnabled(true);
            HtmlButton loginButtonTwo = page.getFirstByXPath("//*[@id=\"login-signin\"]");
            System.out.println("loginButtonTwo: " + loginButtonTwo);
            page = loginButtonTwo.click();
            System.out.println("'Sign-In' button clicked!");
//            System.out.println("Page Text: " + page.asText());
        } catch (Exception e) {
            e.printStackTrace();
        }

//      6. GOTO 'MY PORTFOLIO'
        try {
            HtmlAnchor myPortfolioButton = page.getFirstByXPath("//*[@id=\"Nav-0-DesktopNav\"]/div/div[3]/div/div[1]/ul/li[2]/a");
            System.out.println("myPortfolioButton: " + myPortfolioButton);
            page = myPortfolioButton.click();
            System.out.println("'My Portfolio' button clicked");

        } catch (Exception e) {
            e.printStackTrace();
        }

//      8. GOTO 'MY WATCHLIST'

        try {
            client.getOptions().setJavaScriptEnabled(true);
//            client.setJavaScriptEngine();
            System.out.println("JavaScript Enabled!");
//            HtmlAnchor myWatchListButton = page.getFirstByXPath("//*[@id=\"Col1-0-Portfolios-Proxy\"]/main/table/tbody/tr/td[1]/a");
//            System.out.println("myWatchListButton: " + myWatchListButton);
//            page = myWatchListButton.click();
            page = client.getPage("https://finance.yahoo.com/portfolio/p_0/view/v1");
            System.out.println("Page Text: " + page.asText());
        } catch (Exception e) {
            e.printStackTrace();
        }


//      7. RETURN CLIENT WITH AUTH COOKIES
        return client;
    }
}
