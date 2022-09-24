package credentials;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/local.properties")
public interface CredentialsConfig extends Config {
    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();
}


