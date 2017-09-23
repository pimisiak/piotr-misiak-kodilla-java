package com.kodilla.hibernate.tasklist.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
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

    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        final Task task = new Task("Test: Learn Hibernate", 14);
        final Task task2 = new Task("Test: Write some entities", 3);
        final TaskFinancialDetails taskFinancialDetails = new TaskFinancialDetails(new BigDecimal(20), false);
        final TaskFinancialDetails taskFinancialDetails2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(taskFinancialDetails);
        task2.setTaskFinancialDetails(taskFinancialDetails2);
        final TaskList taskList = new TaskList("ToDo", "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);
        //When
        taskListDao.save(taskList);
        //Then
        assertThat(taskList.getId()).isNotEqualTo(0);
        //Clean Up
        //taskListDao.delete(taskList.getId());
    }
}
