package com.kodilla.hibernate.tasklist.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

import com.kodilla.hibernate.tasklist.TaskList;
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
    public void testFindByListName() {
        //Given
        final TaskList taskList = new TaskList("Test", "Test task list");
        taskListDao.save(taskList);
        //When
        final List<TaskList> foundTaskLists = taskListDao.findByListName(taskList.getListName());
        //Then
        assertThat(foundTaskLists)
                .hasSize(1)
                .extracting("listName", "description")
                .contains(tuple(taskList.getListName(), taskList.getDescription()));
        //Clean up
        taskListDao.delete(foundTaskLists.get(0).getId());
    }
}
