package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testTaskFactoryDrivingTask() {
        //Given
        //TaskFactory
        //When
        final Task drivingTask = TaskFactory.makeTask(TaskType.DRIVINGTASK);
        //Then
        Assert.assertEquals("Driving Task", drivingTask.getTaskName());
        Assert.assertFalse(drivingTask.isTaskExecuted());
        Assert.assertEquals("Executing task Driving Task in Warsaw with FIAT 126p", drivingTask.executeTask());
        Assert.assertTrue(drivingTask.isTaskExecuted());
    }

    @Test
    public void testTaskFactoryPaintingTask() {
        //Given
        //TaskFactory
        //When
        final Task paintingTask = TaskFactory.makeTask(TaskType.PAINTINGTASK);
        //Then
        Assert.assertEquals("Painting Task", paintingTask.getTaskName());
        Assert.assertFalse(paintingTask.isTaskExecuted());
        Assert.assertEquals("Executing task Painting Task, to paint Rembrandt with color Red", paintingTask.executeTask());
        Assert.assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    public void testTaskFactoryShoppingTask() {
        //Given
        //TaskFactory
        //When
        final Task shoppingTask = TaskFactory.makeTask(TaskType.SHOPPINGTASK);
        //Then
        Assert.assertEquals("Shopping Task", shoppingTask.getTaskName());
        Assert.assertFalse(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Executing task Shopping Task to buy 12.0 Egg", shoppingTask.executeTask());
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }
}
