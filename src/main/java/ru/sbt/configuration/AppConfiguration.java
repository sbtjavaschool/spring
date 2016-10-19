package ru.sbt.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.service.*;

@Configuration
public class AppConfiguration {
    @Qualifier("mock")
    @Bean
    public ScheduleService mockScheduleService(MockPersonDao personDao, LessonDao lessonDao) {
        return new ScheduleServiceImpl(personDao, lessonDao);
    }

    @Qualifier("db")
    @Bean
    public ScheduleService scheduleService(DbPersonDao personDao, LessonDao lessonDao) {
        return new ScheduleServiceImpl(personDao, lessonDao);
    }
}
