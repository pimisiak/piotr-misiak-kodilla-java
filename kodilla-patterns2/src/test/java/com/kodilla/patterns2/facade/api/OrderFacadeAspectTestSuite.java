package com.kodilla.patterns2.facade.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderFacadeAspectTestSuite {
    @Mock
    private OrderFacadeAspectLogger orderFacadeAspectLogger;
    @InjectMocks
    private OrderFacadeAspect orderFacadeAspect;
    @Autowired
    private OrderFacade orderFacade;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogProcessOrderCall() {
        //Given
        final OrderDto order = new OrderDto();
        order.addItem(new ItemDto(10L, 2));
        //When
        try {
            orderFacade.processOrder(order, 1L);
        } catch (OrderProcessingException e) {
            // error
        }
        //Then
        verify(orderFacadeAspectLogger, times(1)).info(order, 1L);
    }
}