package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.StringJoiner;

public class StreamMain {
    /**
     * Main method of StreamMain is used for lambdas testing.
     *
     * @param args arguments of method main
     */
    public static void main(final String[] args) {
        final ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expression with method references");
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::divideAByB);

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
