package com.kodilla.stream.lambda;

public class ExpressionExecutor {
    public void executeExpression(final double a, final double b, final MathExpression mathExpression) {
        final double result = mathExpression.calculateExpression(a, b);
        System.out.println("Result equals: " + result);
    }
}
