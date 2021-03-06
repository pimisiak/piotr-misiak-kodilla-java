package com.kodilla.patterns2.facade.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderFacadeAspectTestConfiguration.class)
public class OrderFacadeAspectTestSuite {
    @Autowired
    private OrderFacadeAspectLogger orderFacadeAspectLogger;
    @Autowired
    private OrderFacade orderFacade;

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