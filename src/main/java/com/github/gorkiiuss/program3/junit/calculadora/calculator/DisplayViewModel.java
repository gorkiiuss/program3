package com.github.gorkiiuss.program3.junit.calculadora.calculator;

import com.github.gorkiiuss.program3.junit.calculadora.Observable;
import com.github.gorkiiuss.program3.junit.calculadora.Observer;
import com.github.gorkiiuss.program3.junit.calculadora.model.calculation.Calculation;
import com.github.gorkiiuss.program3.junit.calculadora.model.calculation.CalculationError;
import com.github.gorkiiuss.program3.junit.calculadora.model.calculation.CalculationHistory;

public class DisplayViewModel implements Observer {
    private final DisplayView view;
    private String text = "";
    private boolean isShowingEvaluation;

    public DisplayViewModel(DisplayView view) {
        this.view = view;
    }

    public void clear() {
        isShowingEvaluation = false;
        text = "";
    }

    public void append(char c) {
        isShowingEvaluation = false;
        text += c;
    }

    public void showEvaluation(String s) {
        text += s;
        isShowingEvaluation = true;
    }

    public void erase() {
        isShowingEvaluation = false;
        text = text.substring(0, text.length() - 1);
    }

    private void showError(String msg) {
        text = msg;
    }

    @Override
    public void update(Observable observable, Object... args) {
        if (args.length != 1 || !(args[0] instanceof Character))
            return;

        char selectedEntry = (char) args[0];
        if (String.valueOf(selectedEntry).matches("[0-9.+\\-*/^()]")) {
            if (isShowingEvaluation)
                clear();

            append(selectedEntry);
        } else switch (selectedEntry) {
            case 'c' -> clear();
            case '<' -> erase();
            case '=' -> {
                Calculation calculation = Calculation.parseExpression(text);
                clear();

                CalculationHistory.get().addCalculation(calculation);

                if (calculation.getCalculationError() == CalculationError.NONE)
                    showEvaluation(String.valueOf(calculation.evaluate()));
                else showError(calculation.getCalculationError().getMsg());
            }
            case 'H' -> CalculationHistory.get().showHistory();
        }

        view.setText(text);
    }
}
