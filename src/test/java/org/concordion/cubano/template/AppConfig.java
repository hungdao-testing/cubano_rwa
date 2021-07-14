package org.concordion.cubano.template;

import org.concordion.cubano.config.Config;
import org.concordion.cubano.config.PropertyLoader;
import org.concordion.cubano.driver.web.config.WebDriverConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);
    private final PropertyLoader propertyLoader;

    private String webUrl;
    private String searchUrl;
    private String apiUrl;
    private int defaultTimeout;
    private String databaseUrl;
    private String databaseSchema;

    private static class Holder {
        static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() {
        return Holder.INSTANCE;
    }

    private AppConfig() {
        propertyLoader = Config.getInstance().getPropertyLoader();
        loadProperties();
    }

    public void logSettings() {
        LOGGER.info("Environment:        " + Config.getInstance().getEnvironment());
        LOGGER.info("web_url:                " + webUrl);
        LOGGER.info("api_url:                " + apiUrl);

        WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
        LOGGER.info("Browser:            " + webDriverConfig.getBrowserProvider());

        if (!webDriverConfig.getBrowserDimension().isEmpty()) {
            LOGGER.info("browserSize:        " + webDriverConfig.getBrowserDimension());
        }

        LOGGER.info("Default Timeout:        " + getDefaultTimeout());
    }

    private void loadProperties() {
        webUrl = propertyLoader.getProperty("baseUrl");
        searchUrl = propertyLoader.getProperty("searchUrl");
        apiUrl = propertyLoader.getProperty("apiUrl");
        defaultTimeout = propertyLoader.getPropertyAsInteger("webdriver.defaultTimeout", "10");
    }

    // Application properties
    public String getWebUrl() {
        return webUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public int getDefaultTimeout() {
        return defaultTimeout;
    }
}
