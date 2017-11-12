package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorTestSuite {
    private final Mentor janKowalski = new Mentor("Jan", "Kowalski");
    private final Mentor ryszardPawlak = new Mentor("Ryszard", "Pawlak");

    @Test
    public void testUpdate() {
        //Given
        final TaskQueue adamTasks = new TaskQueueImpl();
        final TaskQueue jolaTasks = new TaskQueueImpl();
        final TaskQueue janTasks = new TaskQueueImpl();
        adamTasks.registerObserver(janKowalski);
        jolaTasks.registerObserver(janKowalski);
        janTasks.registerObserver(ryszardPawlak);
        //When
        adamTasks.offer(new TaskImpl("http://www.test.com/adamTasks", "Hi, I've implemented queue", "Implement FIFO queue."));
        jolaTasks.offer(new TaskImpl("http://www.test.com/jolaTasks", "Hi, I think i have a problem...", "Implement FIFO queue."));
        janTasks.offer(new TaskImpl("http://www.test.com/janTasks", "What's FIFO?", "Implement FIFO queue."));
        //Then
        assertEquals(2, janKowalski.getToCheckTasks());
        assertEquals(1, ryszardPawlak.getToCheckTasks());
    }
}
