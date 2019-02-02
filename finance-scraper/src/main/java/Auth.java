import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;


import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class Auth {

    public static WebClient autoLogin(String loginUrl, String login, String password) throws FailingHttpStatusCodeException, MalformedURLException, IOException {

        WebClient client = new WebClient();
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
//          HtmlInput passwordInput = page.getFirstByXPath("//input[@type='password']");
            HtmlInput passwordInput = page.getFirstByXPath("//*[@id=\"login-passwd\"]");
            passwordInput.setValueAttribute(password);
            System.out.println("passwordInput: " + passwordInput);

        } catch (Exception e) {
            e.printStackTrace();
        }


//      5. CLICK 'SIGN-IN' BUTTON
        try {
            HtmlButton loginButtonTwo = page.getFirstByXPath("//*[@id=\"login-signin\"]");
            System.out.println("loginButtonTwo: " + loginButtonTwo);
            page = loginButtonTwo.click();
            System.out.println("'Sign-In' button clicked!");
            System.out.println("Page Text: " + page.asText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //returns the cookies filled client
        return client;
    }
}
