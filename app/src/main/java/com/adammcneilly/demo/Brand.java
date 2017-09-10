package com.adammcneilly.demo;

/**
 * Represents a company to display in the app.
 */
@SuppressWarnings("WeakerAccess")
public class Brand {
    /**
     * The name of the brand.
     */
    private String name;

    /**
     * The resource (R.id.apple, for example) of their image.
     */
    private int logoResource;

    /**
     * Default constructor.
     *
     * @param name The name of the brand.
     * @param logoResource The resource identifier for their logo.
     */
    public Brand(String name, int logoResource) {
        this.name = name;
        this.logoResource = logoResource;
    }

    /**
     * @return The name of the brand.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The resource identifier for the brand's logo.
     */
    public int getLogoResource() {
        return logoResource;
    }
}
