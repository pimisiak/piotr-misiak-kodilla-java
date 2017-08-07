package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testNumber = 0;
    private ShapeCollector shapeCollector;

    @BeforeClass
    public static void beforeTests() {
        System.out.println("Tests: start");
    }

    @AfterClass
    public static void afterTests() {
        System.out.println("Tests: end");
    }

    @Before
    public void beforeTest() {
        testNumber++;
        shapeCollector = new ShapeCollector();
        System.out.printf("Test #%d start%n", testNumber);
    }

    @After
    public void afterTest() {
        System.out.printf("Test #%d end%n", testNumber);
    }

    @Test
    public void testAddFigure() {
        //Given
        final Shape circle = new Circle(2.5);
        //When
        shapeCollector.addFigure(circle);
        //Then
        System.out.println("Test addFigure");
        Assert.assertEquals(1, shapeCollector.size());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        final Shape square = new Square(3);
        shapeCollector.addFigure(square);
        //When
        final boolean result = shapeCollector.removeFigure(square);
        //Then
        System.out.println("Test removeFigure");
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.size());
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        final Shape square = new Square(3);
        //When
        final boolean result = shapeCollector.removeFigure(square);
        //Then
        System.out.println("Test removeFigureNotExisting");
        Assert.assertFalse(result);
    }

    @Test
    public void testGetFigure() {
        //Given
        final Shape triangle = new Triangle(1.5, 2.0);
        shapeCollector.addFigure(triangle);
        //When
        final Shape resultTriangle = shapeCollector.getFigure(0);
        //Then
        System.out.println("Test getFigure");
        Assert.assertEquals(resultTriangle, triangle);
    }

    @Test
    public void testShowFigures() {
        //Given
        final Shape triangle = new Triangle(2, 1);
        final Shape square = new Square(1);
        final Shape circle = new Circle(1);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        //When
        final String result = shapeCollector.showFigures();
        //Then
        System.out.println("Test showFigures");
        Assert.assertEquals(result, "Triangle - 1,00; Square - 1,00; Circle - 3,14");
    }
}
