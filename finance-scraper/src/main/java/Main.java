import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

public class Main {

    public static void main(String[] args) {

            String baseUrl = "https://finance.yahoo.com" ;
            String loginUrl = "https://login.yahoo.com/config/login?.intl=us&.lang=en-US&.src=finance&.done=https%3A%2F%2Ffinance.yahoo.com%2F";
            String login = "tim@timwheeler.com";
            String password = "<ENTER_PASSWORD>" ;


            try {

                System.out.println("Starting autoLogin on " + loginUrl);
                WebClient client = Auth.autoLogin(loginUrl, login, password);
                HtmlPage page = client.getPage(baseUrl);
                String logoutLink = "https://login.yahoo.com/config/?logout_all=1";


                if(logoutLink != null ){
                    System.out.println("Successfully logged in!");
                    // printing the cookies
                    for(Cookie cookie : client.getCookieManager().getCookies()){
                        System.out.println(cookie.toString());
                    }

                } else {
                    System.err.println("Wrong credentials");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

