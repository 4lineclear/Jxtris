package jxtris.pagicFX;

import javafx.application.Application;
import javafx.stage.Stage;

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
        pagicStart(new PagicStage());
    }

    public abstract void pagicStart(PagicStage stage) throws Exception;
}
