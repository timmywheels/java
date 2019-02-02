package com.timwheeler;

public class Main {

    public static void main(String[] args) {


        SubscribeBot codeSnippet = new SubscribeBot();

        String url = "https://codesnippet.io";
        String email = "bot@bot.com";

        codeSnippet.newSubscriber(url, email);

    }

}


