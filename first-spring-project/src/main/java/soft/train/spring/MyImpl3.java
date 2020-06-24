package soft.train.spring;

import org.springframework.stereotype.Component;

public class MyImpl3 implements IMyIntf{
    private String prefix;

    public MyImpl3(final String prefixParam) {
        prefix = prefixParam;
    }

    @Override public String hello(final String name) {
        return prefix + " " + name;
    }

    @Override public String greet(final String name) {
        return prefix + " " + name;
    }
}
