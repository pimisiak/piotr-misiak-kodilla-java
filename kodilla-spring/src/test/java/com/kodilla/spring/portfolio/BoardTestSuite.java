package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Autowired
    private Board board;

    @Test
    public void testAddTask() {
        //Given
        board.getToDoList().addTask("TaskToDo");
        board.getInProgressList().addTask("TaskInProgress");
        board.getDoneList().addTask("TaskDone");
        //Then
        final String toDoTask = board.getToDoList().getTask(0);
        final String inProgressTask = board.getInProgressList().getTask(0);
        final String doneTask = board.getDoneList().getTask(0);
        //When
        Assert.assertEquals(toDoTask, "TaskToDo");
        Assert.assertEquals(inProgressTask, "TaskInProgress");
        Assert.assertEquals(doneTask, "TaskDone");
    }
}
