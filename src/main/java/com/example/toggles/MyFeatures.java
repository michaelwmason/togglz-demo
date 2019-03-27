package com.example.toggles;

import org.togglz.core.Feature;
import org.togglz.core.context.FeatureContext;

public enum MyFeatures implements Feature {
    MESSAGE,
    RATING;
    
    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}


