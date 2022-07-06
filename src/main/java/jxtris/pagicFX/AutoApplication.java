package jxtris.pagicFX;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Root class for JavaFX applications, extended to automatically add files
 * <p>
 *     When {@link Application#launch(String...)} is run,
 *     adds the FXML files located within a specified locations,
 *     "/resources/fxml/" by default
 * </p>
 **/
public abstract class AutoApplication extends Application {
    /**
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        PagicStage stage = new PagicStage();
        start(stage);
    }

    /**
     * The main entry point for automatic PagicFX applications.
     * NOTE: This method is called on the JavaFX Application Thread.
     * @param stage primaryStage – the primary stage for this application,
     *                              onto which the application scene can be set.
     *                              Applications may create other stages,
     *                              if needed, but they will not be primary stages.
     *                              Comes with preloaded pages.
     **/
    public abstract void start(PagicStage stage) throws Exception;
}
