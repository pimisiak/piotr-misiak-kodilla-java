package com.kodilla.stream.portfolio;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTestSuite {
    private Board project;
    private final User user1 = new User("developer1", "John Smith");
    private final User user2 = new User("projectmanager1", "Nina White");
    private final User user3 = new User("developer2", "Emilia Stephanson");
    private final User user4 = new User("developer3", "Konrad Bridge");

    @Before
    public void before() {
        project = new Board("Project Weather Prediction");
    }

    @Test
    public void testAddTaskListAverageWorkingOnTask() {
        //Given
        project.addTaskList(prepareTaskListInProgress());
        //When
        final double average = project.getTaskLists().stream()
                .filter(tl -> tl.getName().equals("In progress"))
                .flatMap(tl -> tl.getTasks().stream())
                .mapToLong(t -> DAYS.between(t.getCreated(), LocalDate.now()))
                .average()
                .getAsDouble();
        //Then
        Assert.assertEquals(10, average, 0.01);
    }

    @Test
    public void testAddTaskListFindLongTasks() {
        //Given
        project.addTaskList(prepareTaskListInProgress());
        //When
        final List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        final long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(Task::getCreated)
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();
        //Then
        Assert.assertEquals(2, longTasks);
    }

    @Test
    public void testAddTaskListFindOutdatedTasks() {
        //Given
        project.addTaskList(prepareTaskListToDo());
        project.addTaskList(prepareTaskListInProgress());
        //When
        final List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        final List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
        //Then
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    public void testAddTaskListFindUsersTasks() {
        //Given
        project.addTaskList(prepareTaskListToDo());
        project.addTaskList(prepareTaskListInProgress());
        project.addTaskList(prepareTaskListDone());
        //When
        final User user = new User("developer1", "John Smith");
        final List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(Collectors.toList());
        //Then
        Assert.assertEquals(2, tasks.size());
        Assert.assertEquals(user, tasks.get(0).getAssignedUser());
        Assert.assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    public void testAddTaskList() {
        //Given
        project.addTaskList(prepareTaskListToDo());
        project.addTaskList(prepareTaskListInProgress());
        project.addTaskList(prepareTaskListDone());
        //When
        int result = project.getTaskLists().size();
        //Then
        Assert.assertEquals(3, result);
    }

    private TaskList prepareTaskListInProgress() {
        final TaskList taskListInProgress = new TaskList("In progress");
        final Task task2 = new Task.TaskBuilder()
                .title("HQLs for analysis")
                .description("Prepare some HQL queries for analysis")
                .assignedUser(user1)
                .creator(user2)
                .created(LocalDate.now().minusDays(20))
                .deadline(LocalDate.now().minusDays(5))
                .build();
        final Task task4 = new Task.TaskBuilder()
                .title("Own logger")
                .description("Refactor company logger to meet our needs")
                .assignedUser(user3)
                .creator(user2)
                .created(LocalDate.now().minusDays(10))
                .deadline(LocalDate.now().plusDays(25))
                .build();
        final Task task5 = new Task.TaskBuilder()
                .title("Optimize searching")
                .description("Archive data searching has to be optimized")
                .assignedUser(user4)
                .creator(user2)
                .created(LocalDate.now())
                .deadline(LocalDate.now().plusDays(5))
                .build();
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        return taskListInProgress;
    }

    private TaskList prepareTaskListToDo() {
        final TaskList taskListToDo = new TaskList("To do");
        final Task task1 = new Task.TaskBuilder()
                .title("Microservice for taking temperature")
                .description("Write and test the microservice taking the temperaure from external service")
                .assignedUser(user1)
                .creator(user2)
                .created(LocalDate.now().minusDays(20))
                .deadline(LocalDate.now().plusDays(30))
                .build();
        final Task task3 = new Task.TaskBuilder()
                .title("Temperatures entity")
                .description("Prepare entity for temperatures")
                .assignedUser(user3)
                .creator(user2)
                .created(LocalDate.now().minusDays(20))
                .deadline(LocalDate.now().plusDays(15))
                .build();
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        return taskListToDo;
    }

    private TaskList prepareTaskListDone() {
        final TaskList taskListDone = new TaskList("Done");
        final Task task6 = new Task.TaskBuilder()
                .title("Use Streams")
                .description("Use Streams rather than for-loops in predictions")
                .assignedUser(user4)
                .creator(user2)
                .created(LocalDate.now().minusDays(15))
                .deadline(LocalDate.now().minusDays(2))
                .build();
        taskListDone.addTask(task6);
        return taskListDone;
    }
}
