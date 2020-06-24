package soft.train.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import x.y.z.MySecondObj;
import x.y.z.XYZconfig;

@Configuration
@Import(XYZconfig.class)
public class MySpringConfiguration {

    @Bean
    public IMyIntf createMyIntf(){
        return new MyImpl2();
    }

    @Bean
    @Qualifier("myUvf")
    public IMyIntf uvf(){
        MyImpl3 hh = new MyImpl3("uvf");
        hh.greet("test");
        return hh;
    }
    @Bean
    public MySecondObj mySecondObj(@Qualifier("uvf")  IMyIntf uvf){
        String strLoc2 = uvf().greet("osman");
        String strLoc = uvf.greet("osman");
        return new MySecondObj(strLoc);
    }
    @Bean
    public MySecondObj mySecondObj2(){
        String strLoc = uvf().greet("osman");
        return new MySecondObj(strLoc);
    }

}
