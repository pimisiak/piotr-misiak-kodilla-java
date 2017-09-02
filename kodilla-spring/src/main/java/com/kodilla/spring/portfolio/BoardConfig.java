package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BoardConfig {
    @Bean
    Board getBoard() {
        return new Board(taskListToDoList(), taskListInProgressList(), taskListDoneList());
    }

    @Bean(name = "ToDoList")
    TaskList taskListToDoList() {
        return new TaskList();
    }

    @Bean(name = "InProgressList")
    TaskList taskListInProgressList() {
        return new TaskList();
    }

    @Bean(name = "DoneList")
    TaskList taskListDoneList() {
        return new TaskList();
    }
}
