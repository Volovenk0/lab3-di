package org.fpm.di.example.Models;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Brand {
    private final BootsBrand bootsBrand;

    @Inject
    public Brand(BootsBrand bootsBrand) {
        this.bootsBrand = bootsBrand;
    }

    public BootsBrand getBootsBrand() {
        return bootsBrand;
    }
}
