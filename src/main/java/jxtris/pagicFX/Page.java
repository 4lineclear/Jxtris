package jxtris.pagicFX;

import javafx.scene.Scene;

import java.io.IOException;

/**
 * A Page, contains a {@link Scene}. {@link PagicController}
 * and the name of the file they were loaded from
 **/
public class Page {
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
        this.scene = loader.load();
        this.controller = loader.getController();
        this.name = name;
    }
}
