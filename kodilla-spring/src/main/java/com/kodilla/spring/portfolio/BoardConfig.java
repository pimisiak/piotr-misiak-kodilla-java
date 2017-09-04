package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BoardConfig {
    Board getBoard() {
        return new Board(taskListToDoList(), taskListInProgressList(), taskListDoneList());
    }

    @Bean(name = "toDoList")
    TaskList taskListToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    TaskList taskListInProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    TaskList taskListDoneList() {
        return new TaskList();
    }
}
