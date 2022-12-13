package org.fpm.di.example.Models;

import javax.inject.Inject;

public class App {
    private final Marketplace marketplace;

    @Inject
    public App(Marketplace marketplace) {
        this.marketplace = marketplace;
    }


    public Marketplace getMarketplace() {
        return marketplace;
    }
}
