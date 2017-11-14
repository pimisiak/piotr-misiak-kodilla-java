package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OrderFacadeAspect {
    private final OrderFacadeAspectLogger orderFacadeAspectLogger = new OrderFacadeAspectLogger();

    @Before(
            value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))"
            + " && args(order, userId)",
            argNames = "order,userId"
    )
    public void logProcessOrderCall(final OrderDto order, final Long userId) {
        orderFacadeAspectLogger.info(order, userId);
    }
}