package com.kodilla.hibernate.tasklist.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
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
    @Autowired
    private TaskDao taskDao;

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

    @Test
    public void testNamedQueries() {
        //Given
        final Task task1 = new Task("Test: Study Hibernate", 3);
        final Task task2 = new Task("Test: Practice Named Queries", 6);
        final Task task3 = new Task("Test: Study native queries", 7);
        final Task task4 = new Task("Test: Make some tests", 13);

        final TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
        final TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        final TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
        final TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        final TaskList taskList = new TaskList("ToDo", "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDao.save(taskList);
        int id = taskList.getId();

        //When
        final List<Task> longTasks = taskDao.retrieveLongTasks();
        final List<Task> shortTasks = taskDao.retrieveShortTasks();
        final List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        final List<Task> durationLongerThanTasks = taskDao.retrieveTasksWithDurationLongerThan(6);

        //Then
        try {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2, durationLongerThanTasks.size());
        } finally {
            //CleanUp
            taskListDao.delete(id);
        }
    }
}
