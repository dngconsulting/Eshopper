package com.dngconsulting.demo.server;

import java.io.IOException;
import java.util.Properties;

public class EcomConfig {

    public static EcomConfig get(){
        return InstanceHolder.INSTANCE;
    }

    public String getDatabaseFilePath(){
        return defaultProps.getProperty("database.file.path");
    }
    
    
    private final Properties defaultProps;

    private EcomConfig(){
        defaultProps = new Properties();
        try {
            defaultProps.load(EcomConfig.class.getResourceAsStream("/ecom.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private final static class InstanceHolder {
        private final static EcomConfig INSTANCE = new EcomConfig();

    }
}
