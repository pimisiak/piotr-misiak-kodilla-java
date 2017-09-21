package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void findByListName() {
        //Given
        final TaskList taskList = new TaskList("Test", "Test task list");
        taskListDao.save(taskList);
        //When
        final List<TaskList> foundTaskLists = taskListDao.findByListName(taskList.getListName());
        //Then
        Assert.assertEquals(1, foundTaskLists.size());
        Assert.assertEquals(taskList.getListName(), foundTaskLists.get(0).getListName());
        Assert.assertEquals(taskList.getDescription(), foundTaskLists.get(0).getDescription());
        //Clean up
        taskListDao.delete(foundTaskLists.get(0).getId());
    }
}
