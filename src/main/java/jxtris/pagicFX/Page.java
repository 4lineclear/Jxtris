package jxtris.pagicFX;

import javafx.scene.Scene;

import java.io.IOException;

public class Page {
    public final String name;

    public final Scene scene;

    public final PagicController controller;

    public Page(String name) throws IOException {
        PagicLoader loader = new PagicLoader(name);
        this.scene = loader.load();
        this.controller = loader.getController();
        this.name = name;
    }
}
