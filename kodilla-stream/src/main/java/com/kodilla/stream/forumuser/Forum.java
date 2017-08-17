package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Forum {
    /**
     * Creates list of forum users.
     *
     * @return list of forum users
     */
    public static List<ForumUser> getUserList() {
        List<ForumUser> forumUsers = new ArrayList<>();
        forumUsers.add(
                new ForumUser.ForumUserBuilder(1, "bk1")
                        .sex('F')
                        .birthday(LocalDate.of(2000, 11, 1))
                        .numberOfPosts(10).build()
        );
        forumUsers.add(
                new ForumUser.ForumUserBuilder(2, "ak2")
                        .sex('M')
                        .birthday(LocalDate.of(1990, 10, 11))
                        .numberOfPosts(10).build()
        );
        forumUsers.add(
                new ForumUser.ForumUserBuilder(3, "sp3")
                        .sex('M')
                        .birthday(LocalDate.of(2000, 9, 17))
                        .numberOfPosts(10).build()
        );
        forumUsers.add(
                new ForumUser.ForumUserBuilder(4, "pp4")
                        .sex('M')
                        .birthday(LocalDate.of(1970, 7, 22))
                        .numberOfPosts(10).build()
        );
        forumUsers.add(
                new ForumUser.ForumUserBuilder(5, "an5")
                        .sex('M')
                        .birthday(LocalDate.of(1994, 6, 19))
                        .numberOfPosts(10).build()
        );
        forumUsers.add(
                new ForumUser.ForumUserBuilder(6, "aa6")
                        .sex('F')
                        .birthday(LocalDate.of(1988, 1, 7))
                        .numberOfPosts(10).build()
        );
        forumUsers.add(
                new ForumUser.ForumUserBuilder(7, "ak7")
                        .sex('F')
                        .birthday(LocalDate.of(1990, 2, 21))
                        .numberOfPosts(10).build()
        );
        forumUsers.add(
                new ForumUser.ForumUserBuilder(8, "kk8")
                        .sex('F')
                        .birthday(LocalDate.of(2010, 3, 30))
                        .numberOfPosts(10).build()
        );
        forumUsers.add(
                new ForumUser.ForumUserBuilder(9, "zz9")
                        .sex('F')
                        .birthday(LocalDate.of(2002, 12, 1))
                        .numberOfPosts(10).build()
        );
        forumUsers.add(
                new ForumUser.ForumUserBuilder(10, "jj10")
                        .sex('F')
                        .birthday(LocalDate.of(1999, 8, 9))
                        .numberOfPosts(10).build()
        );
        return Collections.unmodifiableList(forumUsers);
    }
}
