package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        final User userMillenial = new Millennials("millenial");
        final User userYGeneration = new YGeneration("yGeneration");
        final User userZGeneration = new ZGeneration("zGeneration");
        //When
        final String millResult = userMillenial.sharePost();
        final String yGenResult = userYGeneration.sharePost();
        final String zGenResult = userZGeneration.sharePost();
        //Then
        Assert.assertEquals("Snapchat", millResult);
        Assert.assertEquals("Twitter", yGenResult);
        Assert.assertEquals("Facebook", zGenResult);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        final User user = new YGeneration("yGeneration");
        //Then
        user.setSocialPublisher(new SnapchatPublisher());
        //When
        Assert.assertEquals("Snapchat", user.sharePost());
    }
}
