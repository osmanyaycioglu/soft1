package soft.train.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Aspect
@Component
public class AOPEnforcer {

    private static final Logger logger = LoggerFactory.getLogger(AOPEnforcer.class);

    @Pointcut("execution(* soft.train.spring.aop.Callee.callMe(..)) && args(str)")
    public void method(final String str) {
    }

    @Before("method(str)")
    public void beforeCall(final JoinPoint jp, final String str) {
        System.out.println("Join : " + jp);
        System.out.println("Before Input : " + str);
    }

    @After("method(str)")
    public void afterCall(final String str) {
        System.out.println("After Input : " + str);
    }

    @AfterReturning(pointcut = "method(str)",
                    returning = "retStr")
    public void afterCall(final String str, final String retStr) {
        System.out.println("AfterReturning returning  : " + retStr);
    }

    @AfterThrowing(pointcut = "method(str)",
                   throwing = "ex")
    public void afterCall(final String str, final Exception ex) {
        System.out.println("AfterThrowing  : " + ex.getMessage());
    }

    @Around("method(str)")
    public Object around(final ProceedingJoinPoint jp, final String str) {
        try {
            System.out.println("around");
            final Object[] argsLoc = jp.getArgs();
            final String strNew = (String) argsLoc[0] + "Test";
            argsLoc[0] = strNew;
            final Object proceedLoc = jp.proceed(argsLoc);
            final String strRet = "Around : " + proceedLoc;
            return strRet;
        } catch (final Throwable t) {
            return null;
        }
    }

    @Around("within(soft.train.spring.aop.*) && @annotation(log)")
    public Object around(final ProceedingJoinPoint jp, final LogAt log) {
        try {
            final Object[] argsLoc = jp.getArgs();
            final long delta = System.nanoTime();
            final Object proceedLoc = jp.proceed(argsLoc);
            logger.info(log.extraData() + " delta : " + (System.nanoTime() - delta) + " args : " + argsLoc);
            return proceedLoc;
        } catch (final Throwable t) {
            return null;
        }
    }

    @Around("within(soft.train.spring.rest.*) && @annotation(log)")
    public Object around(final ProceedingJoinPoint jp, final PostMapping log) {
        try {
            final Object[] argsLoc = jp.getArgs();
            final long delta = System.nanoTime();
            final Object proceedLoc = jp.proceed(argsLoc);
            logger.info(" delta : " + (System.nanoTime() - delta) + " args : " + argsLoc);
            return proceedLoc;
        } catch (final Throwable t) {
            return null;
        }
    }

}
