package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OrderFacadeAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeAspect.class);

    @Before(
            value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))"
            + " && args(order, userId) && target(object)",
            argNames = "order,userId,object"
    )
    public void logProcessOrderCall(final OrderDto order, final Long userId, final Object object) {
        LOGGER.info(String.format("Running processOrder for user with id: %d  ", userId));
    }
}
