import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;


import java.io.IOException;
import java.net.MalformedURLException;

public class Auth {

    public static WebClient autoLogin(String loginUrl, String login, String password) throws FailingHttpStatusCodeException, MalformedURLException, IOException {

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page = client.getPage(loginUrl);

        HtmlTextInput usernameInput = page.getFirstByXPath("//*[@id=\"login-username\"]");
        usernameInput.setValueAttribute(login);
        System.out.println("usernameInput: " + usernameInput);


        HtmlSubmitInput loginButtonOne = page.getFirstByXPath("//*[@id=\"login-signin\"]");
        System.out.println("loginButtonOne:" + loginButtonOne);
        loginButtonOne.click();
        System.out.println("'Next' button clicked!");


        HtmlInput passwordInput = page.getFirstByXPath("//input[@type='password']");
        passwordInput.setValueAttribute(password);
        System.out.println("passwordInput: " + passwordInput);


        HtmlInput loginButtonTwo = page.getFirstByXPath("//*[@id=\"login-signin\"]");
        System.out.println("loginButtonTwo: " + loginButtonTwo);


        //get the enclosing form
        HtmlForm loginForm = passwordInput.getEnclosingForm();
        System.out.println("loginForm: " + loginForm);

        //submit the form
        page = loginButtonTwo.click();
        System.out.println("Login button clicked!");
        System.out.println("page: " + page);

//        HtmlAnchor portfolioButton = page.getFirstByXPath("//*[@id=\"Nav-0-DesktopNav\"]/div/div[3]/div/div[1]/ul/li[2]/a");
//        System.out.println("portfolioButton: " + portfolioButton);
//        portfolioButton.click();
//        System.out.println("portfolioButton clicked!");


        //returns the cookies filled client :)
        return client;
    }

}
