package jxtris.pagicFX;

import javafx.stage.Stage;

import java.util.HashMap;

/**
 * An Extended {@link Stage} that provided convenient multipage development
 * through the implementation of {@link PageManager}
 **/
public class PagicStage extends Stage implements PageManager {
    /**
     * The saved pages that {@link PagicController} can switch to
     * <p>
     *     The keys are the filenames of the saved pages
     * </p>
     **/
    private final HashMap<String, Page> pages;

    public PagicStage() {
        pages = new HashMap<>();
    }

    public void addPage(Page page) {
        page.controller.setManager(this);
        this.pages.put(page.name, page);
    }

    public void setPage(String name) {
        this.setScene(pages.get(name).scene);
    }
}
