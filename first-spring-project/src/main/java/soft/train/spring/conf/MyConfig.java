package soft.train.spring.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "my.conf.app")
@Component
public class MyConfig {

    public String name;
    public String ip;
    public int    port;
    public String username;
    public String password;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(final String ipParam) {
        this.ip = ipParam;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(final int portParam) {
        this.port = portParam;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }
}
