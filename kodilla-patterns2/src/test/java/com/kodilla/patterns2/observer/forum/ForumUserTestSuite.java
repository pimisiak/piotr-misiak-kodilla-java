package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {
    private final ForumUser johnSmith = new ForumUser("John Smith");
    private final ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
    private final ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");

    @Test
    public void testUpdate() {
        //Given
        final ForumTopic javaHelpForum = createJavaHelpForum();
        final ForumTopic javaToolsForum = createJavaToolsForum();
        //When
        javaHelpForum.addPost("Hi everyone! Could you help me with for loop?");
        javaHelpForum.addPost("Better try to use while loop in this case.");
        javaToolsForum.addPost("Help pls, my MySQL db doesn't want to work :(");
        javaHelpForum.addPost("Why while? Is it better?");
        javaToolsForum.addPost("When i try to log in I got 'bad credentials' message.");
        //Then
        assertEquals(3, johnSmith.getUpdateCount());
        assertEquals(2, ivoneEscobar.getUpdateCount());
        assertEquals(5, jessiePinkman.getUpdateCount());
    }

    private ForumTopic createJavaHelpForum() {
        final ForumTopic javaHelpForum = new JavaHelpForumTopic();
        javaHelpForum.registerObserver(johnSmith);
        javaHelpForum.registerObserver(jessiePinkman);
        return javaHelpForum;
    }

    private ForumTopic createJavaToolsForum() {
        final ForumTopic javaToolsForum = new JavaToolsForumTopic();
        javaToolsForum.registerObserver(ivoneEscobar);
        javaToolsForum.registerObserver(jessiePinkman);
        return javaToolsForum;
    }

}
