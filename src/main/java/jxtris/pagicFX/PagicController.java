package jxtris.pagicFX;

public abstract class PagicController {
    private PageManager manager;

    public void setManager(PageManager manager) {
        this.manager = manager;
    }

    public void setScene(String name) {
        manager.setPage(name);
    }
}
