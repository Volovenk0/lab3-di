package org.fpm.di.example.Models;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SneakersBrands {
    private final Nike nike;
    private final Adidas adidas;

    @Inject
    public SneakersBrands(Nike nike, Adidas adidas){
        this.nike = nike;
        this.adidas = adidas;
    }

    public Nike getNike() {
        return nike;
    }

    public Adidas getAdidas() {
        return adidas;
    }
}
