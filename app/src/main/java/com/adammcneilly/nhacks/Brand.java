package com.adammcneilly.nhacks;

/**
 * Created by adam.mcneilly on 6/17/17.
 */

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
