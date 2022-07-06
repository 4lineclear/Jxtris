package jxtris.pagicFX;

import javafx.stage.Stage;

/**
 * An interface to expose the basic functionalities
 * needed to implement a multipage JavaFX app
 **/
public interface PageManager {
    /**
     * Add a page to the saved
     * collection of pages
     * Injects itself into the added page
     * @param page The page to save and inject itself into
     **/
    void addPage(Page page);
    /**
     * Sets the current page
     * @param name The name of the Page(FXML filename) to put onto the {@link Stage}
     **/
    void setPage(String name);
}
