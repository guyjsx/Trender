package com.guyjstitt.trender.util;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by gstitt on 11/24/14.
 */
public class TweetTask {
    private static final String CONSUMER_KEY = "ij16iXvFm1oxxss88Scw6JgCy" ;
    private static final String CONSUMER_SECRET = "T1QcwJ3d1niOp6M0NxZHgIaSFq0d67Iyp7OcmdYYyN8X4E7gOG";
    private static final String ACCESS_KEY = "1882820096-7IQ3Bqq5qpcvIeZPtp2U7WUjUu2WrtUUH8njQX6";
    private static final String ACCESS_SECRET = "M3DhHLwlduQzKRY1lmNMir8EIQq9wGn2jBfiVbHz9tddc";

    public void tweet() {
        Runnable runnable = new Runnable() {
            public void run() {
                ConfigurationBuilder cb = new ConfigurationBuilder();
                cb.setDebugEnabled(true);
                cb.setOAuthConsumerKey(CONSUMER_KEY);
                cb.setOAuthConsumerSecret(CONSUMER_SECRET);
                cb.setOAuthAccessToken(ACCESS_KEY);
                cb.setOAuthAccessTokenSecret(ACCESS_SECRET);
                TwitterFactory tf = new TwitterFactory(cb.build());
                Twitter twitter = tf.getInstance();

                Status status = null;
                try {
                    status = twitter.updateStatus("tweeting from my first andriod app using twitter api");
                } catch (TwitterException e) {
                    e.printStackTrace();
                }
                System.out.println("Successfully updated the status to [" + status.getText() + "].");
            }
        };
        Thread tweetThread = new Thread(runnable);
        tweetThread.start();
    }
}
