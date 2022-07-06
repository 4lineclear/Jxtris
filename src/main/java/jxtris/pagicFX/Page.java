package jxtris.pagicFX;

import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

import static jxtris.pagicFX.URLService.getURL;

/**
 * A Page, contains a {@link Scene}. {@link PagicController}
 * and the name of the file they were loaded from
 **/
public class Page {
    private static final String STYLE_SHEET = getStyleSheet();
    public final String name;

    public final Scene scene;

    public final PagicController controller;

    /**
     * Create a new page with an associated filename
     *
     * @param name The name of the file to load into the {@link Scene}
     * @throws IOException Error with loading the file
     **/
    public Page(String name) throws IOException {
        PagicLoader loader = new PagicLoader(name);
        this.scene = new Scene(loader.load());
        this.controller = loader.getController();
        this.name = name;
        scene.getStylesheets().add(STYLE_SHEET);
    }


    private static String getStyleSheet() {
        String stylesheet = getURL("/css/shared.css").toExternalForm();
        if (stylesheet == null)
            throw new RuntimeException("Must have css file: \"../resources/css/shared.css\"");
        return stylesheet;
    }
}
