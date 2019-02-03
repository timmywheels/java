//import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
//import com.gargoylesoftware.htmlunit.html.HtmlForm;
//import com.gargoylesoftware.htmlunit.html.HtmlInput;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
//
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//
//
//public class Scraper {
//
//    WebClient client = new WebClient();
//    String searchUrl = "https://finance.yahoo.com";
//
//
//    public void Scraper(){
//        client.getOptions().setCssEnabled(false);
//        client.getOptions().setJavaScriptEnabled(false);
//        try {
//            HtmlPage page = client.getPage(searchUrl);
//            System.out.println("Page: " + page);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
