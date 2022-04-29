package main.java.framework;

//TODO: DOCUMENT ALL OF THIS ITS VERY CONFUSING
//TODO: Create working Application subclass that exposes a working start(ScenicStage)
public abstract class ScenicController {
    private ScenicStage stage;

    public void setScene(String fileName) {
        this.stage.setScene(fileName);
    }

    public void setStage(ScenicStage stage) {
        this.stage = stage;
    }
}
