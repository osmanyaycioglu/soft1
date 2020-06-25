package soft.train.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component @Qualifier("osman") public class MyImpl1 implements IMyIntf {

    @Override public String hello(final String name) {
        return "hello 1 " + name;
    }

    @Override public String greet(final String name) {
        return "hello 1 " + name;
    }
}
