package jxtris.pagicFX;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;

public class PagicLoader extends FXMLLoader {
    private static String FXML_FILE_PATH = "/fxml/";

    /**
     * Create a new Loader instance with a given location
     * <p>
     * Loads {@link URL} using {@link PagicLoader#getURL(String)}
     * </p>
     **/
    public PagicLoader(String location) {
        super(getURL(location));
    }

    /**
     * Creates {@link URL} using {@link Class#getResource(String)} from the caller class
     *
     * @param name The name of the {@link URL} to load
     **/
    private static URL getURL(String name) {
        StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Class<?> callerClass = stackWalker.getCallerClass();
        return callerClass.getResource(FXML_FILE_PATH + name + ".fxml");
    }

    /**
     * Sets the path to get to FXML files
     * <p>
     * By default, it is set to "/fxml/"
     * </p>
     * This is used when calling {@link PagicLoader#load(String)}
     *
     * @param path The new path
     **/
    public static void setFilePath(String path) {
        FXML_FILE_PATH = path;
    }

    /**
     * Loads a FXMl file
     * <p>
     * Quality of life addition to {@link FXMLLoader}
     * </p>
     * IE if trying to load file "../resources/fxml/Home.fxml", would call:
     * <p><code>PagicLoader.load("Home");</code></p>
     * </code></pre>
     *
     * @param name The name of the file to load
     * @return The loaded object hierarchy
     * @throws IOException If an error occurs while loading
     **/
    public static <T> T load(String name) throws IOException {
        return FXMLLoader.load(getURL(name));
    }
}
