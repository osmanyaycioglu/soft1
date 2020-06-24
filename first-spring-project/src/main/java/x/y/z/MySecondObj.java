package x.y.z;

import org.springframework.stereotype.Component;

@Component
public class MySecondObj {
    private final String str;

    public MySecondObj(final String strParam) {
        str = strParam;
    }

    public String getStr() {
        return str;
    }
}
