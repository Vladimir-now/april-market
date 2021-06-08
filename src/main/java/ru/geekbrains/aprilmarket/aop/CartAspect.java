package ru.geekbrains.aprilmarket.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CartAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartAspect.class);

    @After("execution(public * ru.geekbrains.aprilmarket.controllers.CartController.add*(Long))")
    public void addLogger() {
        LOGGER.info("***В корзину добавлен продукт");
    }

    @Around("execution(public * ru.geekbrains.aprilmarket.controllers.CartController.delete*(Long))")
    public void addExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        var timeBegin = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        var timeEnd = System.currentTimeMillis();
        LOGGER.info("***Время выполнения метода по удалению продукта: {} мс", timeEnd - timeBegin);
    }
}
