package soft.train.spring;

import org.springframework.stereotype.Component;

@Component
@MySelectQ
public class MyImpl2 implements IMyIntf{

    @Override public String hello(final String name) {
        return "hello 2 " + name;
    }

    @Override public String greet(final String name) {
        return "hello 2 " + name;
    }
}
