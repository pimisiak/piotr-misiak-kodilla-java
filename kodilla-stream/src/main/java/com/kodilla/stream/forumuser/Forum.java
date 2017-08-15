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
        forumUsers.add(new ForumUser(1,"bk1", 'F', LocalDate.of(2000, 11, 1) , 10));
        forumUsers.add(new ForumUser(2,"ak2", 'M', LocalDate.of(1990, 10, 11) , 10));
        forumUsers.add(new ForumUser(3,"sp3", 'M', LocalDate.of(2000, 9, 17) , 10));
        forumUsers.add(new ForumUser(4,"pp4", 'M', LocalDate.of(1970, 7, 22) , 10));
        forumUsers.add(new ForumUser(5,"an5", 'M', LocalDate.of(1994, 6, 19) , 10));
        forumUsers.add(new ForumUser(6,"aa6", 'F', LocalDate.of(1988, 1, 7) , 10));
        forumUsers.add(new ForumUser(7,"ak7", 'F', LocalDate.of(1990, 2, 21) , 10));
        forumUsers.add(new ForumUser(8,"kk9", 'F', LocalDate.of(2010, 3, 30) , 10));
        forumUsers.add(new ForumUser(9,"zz9", 'F', LocalDate.of(2002, 12, 1) , 10));
        forumUsers.add(new ForumUser(10,"jj10", 'F', LocalDate.of(1999, 8, 9) , 10));
        return Collections.unmodifiableList(forumUsers);
    }
}
