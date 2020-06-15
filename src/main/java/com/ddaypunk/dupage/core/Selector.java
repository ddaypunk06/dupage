package com.ddaypunk.dupage.core;

import org.openqa.selenium.By;

/**
 * Encapsulation of custom attribute selectors
 */
public class Selector {
    private String attribute;
    private String value;
    private final String formatWithValue = "[%s=\'%s\']";
    private final String formatWithoutValue = "[%s]";

    /**
     * Construct a selector in the format of "[data-test-component]"
     *
     * @param attribute custom attribute as String, ex: "data-test-button"
     *
     */
    public Selector(String attribute) {
        if(attribute == null) {
            throw new IllegalArgumentException("Selector attribute must not be null!");
        }

        this.attribute = attribute;
    }

    /**
     * Construct a selector in the format of "[data-test-component='name']"
     *
     * @param attribute custom attribute as String, ex: "data-test-button"
     * @param value value of the custom attribute as String, ex: "name"
     */
    public Selector(String attribute, String value) {
        if(attribute == null) {
            throw new IllegalArgumentException("Selector attribute must not be null!");
        }

        this.attribute = attribute;
        this.value = value;
    }

    /**
     * Get the proper By object to select an element using this selector
     * If there is a value, the selector string is formatted differently.
     *
     * @return By object using formatted string selector of the attribute and value provided
     */
    public By getBy() {
        return value != null ? getByWithValue() : getByWithoutValue();
    }

    /**
     * Get the current Selector attribute
     * @return attribute as String
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * Get the current Selector value
     * @return value as String
     */
    public String getValue() {
        return value;
    }

    // Private Selector Methods
    private By getByWithoutValue() {
        return By.cssSelector(String.format(formatWithoutValue, attribute));
    }

    private By getByWithValue() {
        return By.cssSelector(String.format(formatWithValue, attribute, value));
    }
}