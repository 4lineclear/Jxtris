package jxtris.pagicFX;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Root class for JavaFX applications, extended to provide {@link PagicStage} instad of {@link Stage}
 **/
public abstract class PagicApplication extends Application {
    /**
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        start(new PagicStage());
    }
    /**
     * The main entry point for default PagicFX applications.
     * NOTE: This method is called on the JavaFX Application Thread.
     * @param stage primaryStage – the primary stage for this application,
     *                              onto which the application scene can be set.
     *                              Applications may create other stages,
     *                              if needed, but they will not be primary stages
     **/
    public abstract void start(PagicStage stage) throws Exception;
}
