package jxtris.pagicFX;

import javafx.stage.Stage;

import java.util.HashMap;

public class PagicStage extends Stage implements PageManager {
    private final HashMap<String, Page> pages;

    public PagicStage() {
        pages = new HashMap<>();
    }

    public void addPage(Page page) {
        this.pages.put(page.name, page);
    }

    public void setPage(String name) {
        this.setScene(pages.get(name).scene);
    }
}
