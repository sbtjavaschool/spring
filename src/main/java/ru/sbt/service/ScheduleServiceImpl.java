package ru.sbt.service;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import ru.sbt.run.RunAsync;

public class ScheduleServiceImpl implements ScheduleService {
    private final PersonDao personDao;
    private final LessonDao lessonDao;

    public ScheduleServiceImpl(PersonDao personDao, LessonDao lessonDao) {
        this.personDao = personDao;
        this.lessonDao = lessonDao;
    }

    @RunAsync
    public void init() {
        System.out.println("INIT!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    @Retryable(maxAttempts = 10, backoff = @Backoff(delay = 1000))
    public double calc() {
        System.out.println("CALC");
        if (true) {
            throw new NullPointerException();
        }
        personDao.save(10);
        lessonDao.update(null);
        return 0;
    }
}