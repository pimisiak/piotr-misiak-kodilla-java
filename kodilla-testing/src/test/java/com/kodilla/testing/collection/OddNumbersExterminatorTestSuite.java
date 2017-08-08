package com.kodilla.testing.collection;

import java.util.ArrayList;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OddNumbersExterminatorTestSuite {
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
        Assert.assertTrue(evenList.isEmpty());
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
        Assert.assertThat(evenList, CoreMatchers.hasItems(2, 4, 6, 8, 10));
    }
}
