package jxtris.pagicFX;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;

import static jxtris.pagicFX.URLService.getURL;

/**
 * An extended {@link FXMLLoader} to make its use more convenient
 * <p>
 *     In its use, only need to specify the filenames,
 *     not the entire paths as long as the files are placed correctly
 * </p>
 * By default, FXML files should be placed within "../resources/fxml/"
 **/
public class PagicLoader extends FXMLLoader {
    public static String FXML_FILE_PATH = "/fxml/";

    /**
     * Create a new Loader instance with a given location
     * <p>
     * Loads {@link URL} using {@link URLService#getURL(String)}
     * </p>
     **/
    public PagicLoader(String name) {
        super(getURL(FXML_FILE_PATH + name + ".fxml"));
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
        return FXMLLoader.load(getURL(FXML_FILE_PATH + name + ".fxml"));
    }
}
