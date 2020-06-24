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

    @Autowired private MyFirstObj mObj;
    @Autowired private MyFirstObj mObj2;
    @Autowired MyFirstObj mObj3;
    @Autowired protected MyFirstObj mObj4;
    protected MyFirstObj mObj5;
    protected MyFirstObj mObj6;

    @Autowired ApplicationContext ac;
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

    public String process(){
        return myImpl1.greet(mObj.getName());
    }

    @Override public void run(final ApplicationArguments args) throws Exception {
        mObj3.setName("osman");
        String str = process();
        System.out.println(str);
        IMyIntf im = (IMyIntf) ac.getBean("myImpl1");

    }

    @Autowired
    public FirstSpringProjectApplication(MyFirstObj mObj5) {
        this.mObj5 = mObj5;
    }

    @Autowired
    public void xyz(MyFirstObj mObj6){
        this.mObj6 = mObj6;
    }

   @PostConstruct
   public void init(){
       String mObjNameLoc = mObj.getName();
   }

   @PreDestroy
   public void destroy(){

   }


    public static void main(String[] args) {
        ConfigurableApplicationContext runLoc = SpringApplication.run(FirstSpringProjectApplication.class, args);
        FirstSpringProjectApplication beanLoc = runLoc.getBean(FirstSpringProjectApplication.class);
        String mObjNameLoc = beanLoc.mObj.getName();

        // MyFirstObj a = new MyFirstObj();
        // Yanlış
        //		FirstSpringProjectApplication fs = new FirstSpringProjectApplication();
        //		String nameLoc = fs.mObj.getName();
    }

}
