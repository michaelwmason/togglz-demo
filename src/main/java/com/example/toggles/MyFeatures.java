package com.example.toggles;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum MyFeatures implements Feature {
    @Label("Returns a message indicating if it the toggle is enabled")
    MESSAGE,
    @Label("Toggles requirement for a description")
    RATING


}


