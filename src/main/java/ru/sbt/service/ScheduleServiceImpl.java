package ru.sbt.service;

import org.springframework.stereotype.Service;

public class ScheduleServiceImpl implements ScheduleService {
    private final PersonDao personDao;
    private final LessonDao lessonDao;

    public ScheduleServiceImpl(PersonDao personDao, LessonDao lessonDao) {
        this.personDao = personDao;
        this.lessonDao = lessonDao;
    }

    @Override
    public double calc() {
        return 0;
    }
}
