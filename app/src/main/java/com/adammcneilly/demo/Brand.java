package com.adammcneilly.demo;

/**
 * Represents a company to display in the app.
 */
@SuppressWarnings("WeakerAccess")
public class Brand {
    private String name;
    private int logoResource;

    public Brand(String name, int logoResource) {
        this.name = name;
        this.logoResource = logoResource;
    }

    public String getName() {
        return name;
    }

    public int getLogoResource() {
        return logoResource;
    }
}
