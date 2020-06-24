package x.y.z;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XYZconfig {

    @Bean
    public MySecondObj localMySecondObj(){
        return new MySecondObj("default");
    }

}
