package com.timwheeler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

    public class SubscribeBot {

        public static WebClient newSubscriber(String url, String email) {

            WebClient client = new WebClient();
            client.getOptions().setCssEnabled(false);
            client.getOptions().setJavaScriptEnabled(false);

            try {

                HtmlPage page = client.getPage(url);
                HtmlAnchor subscribeTrigger = page.getFirstByXPath("/html/body/div[1]/header/div/nav/div[2]/a");
                System.out.println("subscribeTrigger:" + subscribeTrigger);
                subscribeTrigger.click();
                System.out.println("Subscribe trigger clicked!");

                HtmlInput emailInput = page.getFirstByXPath("//*[@id=\"subscribe\"]/div/form/div/input");

                emailInput.setAttribute("value", email);
                System.out.println("emailInput:" + emailInput);

                HtmlButton subscribeButton = page.getFirstByXPath("//*[@id=\"subscribe\"]/div/form/button");
                System.out.println("subscribeButton:" + subscribeButton);
                subscribeButton.click();
                System.out.println("Subscribe button clicked!");


            } catch (Exception e) {
                System.out.println("There was an error!");
                e.printStackTrace();
            }

            return client;
        }

    }


