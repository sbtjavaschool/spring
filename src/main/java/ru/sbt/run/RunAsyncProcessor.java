package ru.sbt.run;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

@Service
public class RunAsyncProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Stream.of(bean.getClass().getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(RunAsync.class))
                .forEach(m -> new Thread(() -> {
                            System.out.println("Started " + m.getName());
                            try {
                                m.invoke(bean);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new RuntimeException(e);
                            } finally {
                                System.out.println("Finished " + m.getName());
                            }
                        }).start()
                );

        return bean;
    }
}
