package com.example.javafxdemo.utils;

import javafx.scene.control.TextFormatter;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

/**
 * @author cmlanche
 * filter in textfield
 * From https://cmlanche.github.io/
 */
public class IntegerFilter implements UnaryOperator<TextFormatter.Change> {
    /**
     * pattern of only integer
     */
    private final static Pattern DIGIT_PATTERN = Pattern.compile("\\d*");

    /**
     * This method is called when the text changes in the text field.
     * @param change change of the charater
     * @return return null if the char isn't apply pattern.
     */
    @Override
    public TextFormatter.Change apply(TextFormatter.Change change) {
        return DIGIT_PATTERN.matcher(change.getText()).matches() ? change : null;
    }
}
