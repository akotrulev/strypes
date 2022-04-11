package utility;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class CustomFileReader {
    String basePath;

    public CustomFileReader() {

        basePath = Optional.ofNullable(System.getProperty("testdata"))
                .orElse(System.getProperty("user.dir")) + File.separator;
    }

    /**
     * Used to read .properties file
     *
     * @param path the path to the file
     * @return the file in a Properties class as to access the different properties' values
     * <p>
     * Throws runtime exception as to stop the execution of the test
     */
    public Properties readPropFile(String path) {
        Properties prop = new Properties();
        try {
            prop.load(new FileReader(basePath + path));
        } catch (IOException e) {
            CustomAssert.failTest(String.format("Error while reading file %s", path));
        }
        return prop;
    }

    /**
     * Used to read a .json file and parse it to an object.
     * This can be used in data driven tests
     *
     * @param path   the path to the json file
     * @param tClass the class to which the json should be parsed
     * @return the file in the specified class type
     * <p>
     * Throws runtime exception as to stop the execution of the test
     */
    public <T> T readJsonFile(String path, Class<T> tClass) {
        try {
            return new Gson().fromJson(new FileReader(basePath + path), tClass);
        } catch (FileNotFoundException e) {
            CustomAssert.failTest(String.format("Can not find file %s", path));
        }
        return null;
    }

    public File readFile(String path) {

        return new File(basePath + path);
    }
}
