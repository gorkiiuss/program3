package com.github.gorkiiuss.program3.swing.loadingroulette;

public interface Loading {
    boolean isLoaded();
    void executeWhenLoaded(Runnable action);
}
