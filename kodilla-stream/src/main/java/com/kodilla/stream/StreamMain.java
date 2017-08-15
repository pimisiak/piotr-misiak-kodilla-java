package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    /**
     * Main method of StreamMain is used for lambdas testing.
     *
     * @param args arguments of method main
     */
    public static void main(final String[] args) {
        //Forum users assignment
        Map<Integer, ForumUser> forumUsers = Forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getBirthday().isBefore(LocalDate.now().minusYears(20)))
                .filter(user -> user.getNumberOfPosts() > 1)
                .collect(Collectors.toMap(ForumUser::getIdNumber, user -> user));

        forumUsers.entrySet().stream().map(entry -> entry.getKey() + ":" + entry.getValue()).forEach(System.out::println);

        //Beautify poem assignment
        System.out.println("Beautify Poem!");
        final PoemBeautifier poemBeautifier = new PoemBeautifier();
        final String poem0 = poemBeautifier.beautify("This is a poem!", (poem) -> String.format("ABC %s ABC", poem));
        final String poem1 = poemBeautifier.beautify("This is a poem!", String::toUpperCase);
        final String poem2 = poemBeautifier.beautify("This is a poem!", String::toLowerCase);

        final String poem3 = poemBeautifier.beautify("This is a poem!", (poem) -> {
            StringBuilder builder = new StringBuilder();
            for (int i = poem.length() - 1; i >= 0; i--) {
                builder.append(poem.charAt(i));
            }
            return builder.toString();
        });

        final String poem4 = poemBeautifier.beautify("This is a poem!", (poem) -> {
            StringBuilder builder = new StringBuilder(poem);
            return builder.reverse().toString();
        });

        final String poem5 = poemBeautifier.beautify("This is a poem!", (poem) -> {
            final StringBuilder builder = new StringBuilder();
            final String[] poemWords = poem.split(" ");
            for (String poemWord : poemWords) {
                for (int i = 0; i < poemWord.length(); i++) {
                    builder.append(poemWord.charAt(i));
                    builder.append(".");
                }
                builder.deleteCharAt(builder.lastIndexOf("."));
                builder.append(" ");
            }
            return builder.toString();
        });

        System.out.println(poem0);
        System.out.println(poem1);
        System.out.println(poem2);
        System.out.println(poem3);
        System.out.println(poem4);
        System.out.println(poem5);
    }
}
