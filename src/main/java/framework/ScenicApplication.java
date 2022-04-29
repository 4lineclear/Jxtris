package main.java.framework;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ScenicApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        scenicStart((ScenicStage) (stage = new ScenicStage()));
    }

    public abstract void scenicStart(ScenicStage stage) throws IOException;
}
