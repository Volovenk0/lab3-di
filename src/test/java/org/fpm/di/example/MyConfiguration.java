package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.example.Models.*;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());

        //-----------------------------

        binder.bind(Brand.class);
        binder.bind(ShoesBrand.class);
        binder.bind(BootsBrand.class);

        binder.bind(HighHeelBrand.class, CalvinKlein.class);
        binder.bind(App.class);
        binder.bind(Marketplace.class, Farfetch.class);
    }
}
