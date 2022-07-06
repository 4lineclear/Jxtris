package jxtris.pagicFX;

/**
 * A basic controller to extend when making controllers
 * <p>
 *     Exposes basic methods to change the scene
 * </p>
 **/
public abstract class PagicController {
    private PageManager manager;

    public void setManager(PageManager manager) {
        this.manager = manager;
    }

    public void setScene(String name) {
        manager.setPage(name);
    }
}
