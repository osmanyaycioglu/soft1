package soft.train.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;

public class Caller {

    @Autowired
    private Callee cl;

    @LogAt(extraData = "caller:call")
    public void call(final String str) {
        final String sLoc = this.cl.callMe(str);
        System.out.println("Callee result : " + sLoc);
        this.cl.xyz("osman2");
        this.cl.abc("osman3");
    }
}
