package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: start");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: start");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        final ArrayList<Integer> list = new ArrayList<Integer>();
        //When
        final ArrayList<Integer> evenList = OddNumbersExterminator.exterminate(list);
        //Then
        System.out.println("Test Empty List");
        Assert.assertArrayEquals(list.toArray(new Integer[list.size()]), evenList.toArray(new Integer[evenList.size()]));
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
        //When
        final ArrayList<Integer> evenList = OddNumbersExterminator.exterminate(list);
        //Then
        System.out.println("Test Normal List");
        Integer[] resultList = new Integer[]{2, 4, 6, 8, 10};
        Assert.assertArrayEquals(resultList, evenList.toArray(new Integer[evenList.size()]));
    }
}
