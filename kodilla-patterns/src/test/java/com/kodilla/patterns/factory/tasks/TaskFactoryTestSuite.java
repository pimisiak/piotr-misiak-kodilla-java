package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testTaskFactoryDrivingTask() {
        //Given
        final AbstractTaskFactory drivingTaskFactory = FactoryProducer.getTaskFactory(TaskType.DRIVINGTASK);
        //When
        final Task drivingTask = drivingTaskFactory.getDrivingTask("Commuting", "Warsaw", "FIAT 126p");
        //Then
        Assert.assertEquals("Commuting", drivingTask.getTaskName());
        Assert.assertFalse(drivingTask.isTaskExecuted());
        Assert.assertEquals("Executing task Commuting in Warsaw with FIAT 126p", drivingTask.executeTask());
        Assert.assertTrue(drivingTask.isTaskExecuted());
    }

    @Test
    public void testTaskFactoryPaintingTask() {
        //Given
        final AbstractTaskFactory paintingTaskFactory = FactoryProducer.getTaskFactory(TaskType.PAINTINGTASK);
        //When
        final Task paintingTask = paintingTaskFactory.getPaintingTask("Painting Rembrandt", "Red", "Rembrandt");
        //Then
        Assert.assertEquals("Painting Rembrandt", paintingTask.getTaskName());
        Assert.assertFalse(paintingTask.isTaskExecuted());
        Assert.assertEquals("Executing task Painting Rembrandt, to paint Rembrandt with color Red", paintingTask.executeTask());
        Assert.assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    public void testTaskFactoryShoppingTask() {
        //Given
        final AbstractTaskFactory shoppingTaskFactory = FactoryProducer.getTaskFactory(TaskType.SHOPPINGTASK);
        //When
        final Task shoppingTask = shoppingTaskFactory.getShoppingTask("Shopping", "Egg", 12);
        //Then
        Assert.assertEquals("Shopping", shoppingTask.getTaskName());
        Assert.assertFalse(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Executing task Shopping to buy 12.0 Egg", shoppingTask.executeTask());
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }
}
