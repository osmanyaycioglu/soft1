package soft.train.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// @SpringBootApplication(scanBasePackages = {"soft.train.spring","x.y.z"})
@SpringBootApplication
public class FirstSpringProjectApplication implements ApplicationRunner {

    @Autowired
    protected MyFirstObj mObj4;
    protected MyFirstObj mObj5;
    protected MyFirstObj mObj6;
    @Autowired
    MyFirstObj mObj3;
    @Autowired
    ApplicationContext ac;
    @Autowired
    private MyFirstObj mObj;
    @Autowired
    private MyFirstObj mObj2;
    @Autowired
    //@Qualifier("myImpl1")
    private IMyIntf myImpl1;

    @Autowired
    @Qualifier("osman")
    private IMyIntf myImp;

    @Autowired
    @MySelectQ
    private IMyIntf myImp2;

    @Autowired
    @Qualifier("myUvf")
    private IMyIntf myImp3;

    @Autowired
    public FirstSpringProjectApplication(final MyFirstObj mObj5) {
        this.mObj5 = mObj5;
    }

    public static void main(final String[] args) {
        final ConfigurableApplicationContext runLoc = SpringApplication.run(FirstSpringProjectApplication.class,
                                                                            args);
        final FirstSpringProjectApplication beanLoc = runLoc.getBean(FirstSpringProjectApplication.class);
        final String mObjNameLoc = beanLoc.mObj.getName();

        // MyFirstObj a = new MyFirstObj();
        // Yanlış
        //		FirstSpringProjectApplication fs = new FirstSpringProjectApplication();
        //		String nameLoc = fs.mObj.getName();
    }

    public String process() {
        return this.myImpl1.greet(this.mObj.getName());
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        this.mObj3.setName("osman");
        final String str = this.process();
        System.out.println(str);
        final IMyIntf im = (IMyIntf) this.ac.getBean("myImpl1");

    }

    @Autowired
    public void xyz(final MyFirstObj mObj6) {
        this.mObj6 = mObj6;
    }

    @PostConstruct
    public void init() {
        final String mObjNameLoc = this.mObj.getName();
    }

    @PreDestroy
    public void destroy() {

    }

}
