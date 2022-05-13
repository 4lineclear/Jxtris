package org.jxtris.game.controls;


import javafx.scene.input.KeyCode;

public abstract class KeyProperty {
    KeyCode keyCode;
    public void setKey(KeyCode key){
        this.keyCode = key;
    }
    protected abstract void throwKey();
    protected abstract void catchKey();
}
