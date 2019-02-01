import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;


public class Main {

    public static void main(String[] args) {


            String baseUrl = "https://finance.yahoo.com" ;
            String loginUrl = "https://login.yahoo.com/config/login" ;
            String login = "tim@timwheeler.com";
            String password = "mvp71111" ;

            try {
                System.out.println("Starting autoLogin on " + loginUrl);
                WebClient client = Auth.autoLogin(loginUrl, login, password);
                HtmlPage page = client.getPage(baseUrl);

                HtmlAnchor logoutLink = page.getFirstByXPath(String.format("//a[@href='user?id=%s']", login)) ;
                if(logoutLink != null ){
                    System.out.println("Successfuly logged in!");
                    // printing the cookies
                    for(Cookie cookie : client.getCookieManager().getCookies()){
                        System.out.println(cookie.toString());
                    }
                }else{
                    System.err.println("Wrong credentials");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

