package soft.train.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public Caller caller() {
        return new Caller();
    }

    @Bean
    public Callee callee() {
        return new Callee();
    }

}
