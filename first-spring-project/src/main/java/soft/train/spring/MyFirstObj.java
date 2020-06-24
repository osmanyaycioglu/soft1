package soft.train.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class MyFirstObj {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String nameParam)  {
        name = nameParam;
    }
}
