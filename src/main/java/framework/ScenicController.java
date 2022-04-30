package main.java.framework;

/**
 * Simple controller outline of the Scenic framework
 **/
public abstract class ScenicController {
    /**
     * The {@link ScenicStage} that stores saved {@link ScenicLoader}
     * to be used
     **/
    private ScenicStage stage;

    /**
     * Sets the currently presented scene to one saved in {@link ScenicController#stage}
     * <p>
     *     Acts as a pipe to {@link ScenicStage#setScene(String)},
     *     while keeping visibility hidden
     * </p>
     * @param fileName The name of the FXML file of the scene trying to be presented
     * @see ScenicStage#setScene(String)
     **/
    public void setScene(String fileName) {
        this.stage.setScene(fileName);
    }

    /**
     * Injects the {@link ScenicStage} to be used by {@link ScenicController#setScene(String)}
     * <p>
     *     Is meant to be called by {@link ScenicStage#addScene(ScenicLoader)}
     * </p>
     * @param stage The stage this scene is to work with
     **/
    public void setStage(ScenicStage stage) {
        this.stage = stage;
    }
}
