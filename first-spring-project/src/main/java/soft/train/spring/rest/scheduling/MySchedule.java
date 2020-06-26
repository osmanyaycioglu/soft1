package soft.train.spring.rest.scheduling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.*;

@Configuration
@EnableScheduling
@EnableAsync
public class MySchedule {

    @Scheduled(fixedDelay = 10_000)
    public void test() {

    }

    @Bean
    public Executor createMyExecutor() {
        return Executors.newFixedThreadPool(10);
    }

    @Async("createMyExecutor")
    public Future<String> myMethod() {
        return CompletableFuture.completedFuture("OK");
    }

    public void myCont() throws ExecutionException, InterruptedException, TimeoutException {
        final Future<String> stringFutureLoc = this.myMethod();
        if (stringFutureLoc.isDone()) {
            stringFutureLoc.get();
        }

        final String s = stringFutureLoc.get();

        stringFutureLoc.get(1000,
                            TimeUnit.MILLISECONDS);
    }

}
