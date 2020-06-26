package soft.train.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import x.y.z.MySecondObj;
import x.y.z.XYZconfig;

@Configuration
@Import(XYZconfig.class)
// @EntityScan(basePackages = {""})
// @EnableJpaRepositories(basePackages = {""})
public class MySpringConfiguration {


    @Bean
    public IMyIntf createMyIntf() {
        return new MyImpl2();
    }

    @Bean
    @Qualifier("myUvf")
    public IMyIntf uvf() {
        final MyImpl3 hh = new MyImpl3("uvf");
        hh.greet("test");
        return hh;
    }

    @Bean
    public MySecondObj mySecondObj(@Qualifier("uvf") final IMyIntf uvf) {
        final String strLoc2 = this.uvf().greet("osman");
        final String strLoc = uvf.greet("osman");
        return new MySecondObj(strLoc);
    }

    @Bean
    public MySecondObj mySecondObj2() {
        final String strLoc = this.uvf().greet("osman");
        return new MySecondObj(strLoc);
    }

}
