package pom.util;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ReadAndWriteProperties {
    private static String file = System.getProperty("user.dir") + "/src/test/resources/config.properties";

    public static void writePropertyValue(String property, String value) {
        try {
            Parameters params = new Parameters();
            FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                    new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                            .configure(params.properties()
                                    .setFileName(file));
            Configuration config = builder.getConfiguration();
            config.setProperty(property, value);
            builder.save();

        } catch (ConfigurationException io) {
            io.printStackTrace();
        }
    }
}