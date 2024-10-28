package com.github.gorkiiuss.program3.junit.calculadora.calculator;

import com.github.gorkiiuss.program3.junit.calculadora.Observable;

public class ButtonPanelViewModel extends Observable {
    private char selectedEntry;

    public ButtonPanelViewModel() {

    }

    public char getSelectedEntry() {
        return selectedEntry;
    }

    public void setSelectedEntry(char selectedEntry) {
        this.selectedEntry = selectedEntry;
        notifyObservers(selectedEntry);
    }
}
