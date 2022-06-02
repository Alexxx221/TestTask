package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.load("config.conf");
    }

    String url = readConfig().getString("url");
    String browser = readConfig().getString("browser").toUpperCase();
    boolean fullscreen = readConfig().getBoolean("browser_settings.fullscreen");
    boolean headless = readConfig().getBoolean("browser_settings.headless");
    int implicit_wait = readConfig().getInt("implicit_wait");
    int explicit_wait = readConfig().getInt("explicit_wait");
    int page_load_time = readConfig().getInt("page_load_time");
    boolean page_load_strategy = readConfig().getBoolean("page_load_strategy");
}
