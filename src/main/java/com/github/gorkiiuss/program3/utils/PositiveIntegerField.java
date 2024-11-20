package com.github.gorkiiuss.program3.utils;

import javax.swing.JTextField;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class PositiveIntegerField extends JTextField {

    public PositiveIntegerField() {
        super();
        // Set the custom document filter
        ((PlainDocument) this.getDocument()).setDocumentFilter(new PositiveIntegerFilter());
    }

    // Optional: Allow setting the initial text and column width
    public PositiveIntegerField(String text, int columns) {
        super(text, columns);
        ((PlainDocument) this.getDocument()).setDocumentFilter(new PositiveIntegerFilter());
    }

    // Optional: Allow setting the column width only
    public PositiveIntegerField(int columns) {
        super(columns);
        ((PlainDocument) this.getDocument()).setDocumentFilter(new PositiveIntegerFilter());
    }

    // Inner class that defines the filter
    private static class PositiveIntegerFilter extends DocumentFilter {

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (isValidInput(string, fb, offset)) {
                super.insertString(fb, offset, string, attr);
            } else {
                // Optionally, you can provide feedback to the user here
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (isValidInput(text, fb, offset, length)) {
                super.replace(fb, offset, length, text, attrs);
            } else {
                // Optionally, you can provide feedback to the user here
            }
        }

        private boolean isValidInput(String text, FilterBypass fb, int offset) throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            StringBuilder sb = new StringBuilder(currentText);
            sb.insert(offset, text);

            // Empty input is acceptable
            if (sb.length() == 0) {
                return true;
            }

            try {
                int value = Integer.parseInt(sb.toString());
                return value >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        // Overloaded method to handle replace operation
        private boolean isValidInput(String text, FilterBypass fb, int offset, int length) throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            StringBuilder sb = new StringBuilder(currentText);
            sb.replace(offset, offset + length, text);

            // Empty input is acceptable
            if (sb.length() == 0) {
                return true;
            }

            try {
                int value = Integer.parseInt(sb.toString());
                return value >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    // Optional: Method to get the integer value directly
    public int getInteger() {
        String text = getText();
        if (text.isEmpty()) {
            return 0; // or throw an exception if preferred
        }
        return Integer.parseInt(text);
    }
}
