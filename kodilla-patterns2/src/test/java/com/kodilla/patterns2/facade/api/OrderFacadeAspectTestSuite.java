package com.kodilla.patterns2.facade.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderFacadeAspectTestSuite {
    @Autowired
    private OrderFacade orderFacade;
    @Autowired
    private OrderFacadeAspect orderFacadeAspect;
    @Mock
    private OrderFacadeAspectLogger orderFacadeAspectLogger;

    @Test
    public void testLogProcessOrderCall() {
        //Given
        final OrderDto order = new OrderDto();
        order.addItem(new ItemDto(10L, 2));
        doNothing().when(orderFacadeAspectLogger).info(order, 1L);
        //When
        try {
            orderFacade.processOrder(order, 1L);
            //Then
            verify(orderFacadeAspectLogger, times(1)).info(order, 1L);
        } catch (OrderProcessingException e) {
            // do sth
        }
    }

}
