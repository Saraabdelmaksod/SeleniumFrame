package utils.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigHandler {

    public static String config_username_password = "src/test/resources/config-username-password.properties";
    public static String config_url="src/test/resources/config-url.properties";
    public static String config_environment= "src/test/resources/environment.properties";
    public static Properties websiteProperty;
    public static Properties urlProperty;
    public static Properties envProperty;


    public static void setAllConfig(){
        setConfig_url();
        setConfig_username_password();
        setConfig_environment();
    }

    public static void setConfig_environment(){
        envProperty=new Properties();
        try {
            envProperty.load(Files.newInputStream(Paths.get(config_environment)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setConfig_username_password(){
        websiteProperty=new Properties();
        try {
            websiteProperty.load(Files.newInputStream(Paths.get(config_username_password)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setConfig_url(){
        urlProperty=new Properties();
        try {
            urlProperty.load(Files.newInputStream(Paths.get(config_url)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Properties getWebsiteProperty(){
        return websiteProperty;
    }
    public static Properties getUrlProperty(){
        return urlProperty;
    }

    public static Properties getEnvProperty(){
        return envProperty;
    }
}
