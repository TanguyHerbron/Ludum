package com.ludum.Ludum.twitterAPI;

import twitter4j.*;

public class TwitterHashtagStream {

    public static void getTweetStreamForHashtag(String hashtag)
    {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("source:twitter4j yusukey");
        QueryResult result = null;
        try {
            result = twitter.search(query);

            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
