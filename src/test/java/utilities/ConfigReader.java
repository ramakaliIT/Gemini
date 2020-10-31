package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //The purpose of this class is to read the data in the configuration.properties file

    private static Properties properties;
    //We are initializing configuration.properties data
        static {
        String path = "configuration.properties";
        try {

            FileInputStream file=new FileInputStream(path);
            properties=new Properties();
            properties.load(file);
            file.close();
        } catch (Exception e) {
            //System.out.println("Path is not found");
            e.printStackTrace();
        }
    }
    // We create static method to read and return the value of a user requested key


    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}