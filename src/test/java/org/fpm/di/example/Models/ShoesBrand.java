package org.fpm.di.example.Models;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ShoesBrand {
    private final BootsBrand bootsBrand;
    private final SneakersBrands sneakersBrands;
    private final HighHeelBrand highHeelBrand;


    @Inject
    public ShoesBrand(BootsBrand bootsBrand, SneakersBrands sneakersBrands, HighHeelBrand highHeelBrand) {
        this.bootsBrand = bootsBrand;
        this.sneakersBrands = sneakersBrands;
        this.highHeelBrand = highHeelBrand;
    }


    public BootsBrand getBootsBrand() {
        return bootsBrand;
    }

    public SneakersBrands getSneakersBrands() {
        return sneakersBrands;
    }

    public HighHeelBrand getHighHeelBrand() {
        return highHeelBrand;
    }
}
