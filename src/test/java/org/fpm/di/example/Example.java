package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.junit.Before;
import org.junit.Test;
import org.fpm.di.example.Models.*;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

    @Test
    public void shouldBuildInInjectDep(){
        final App app = container.getComponent(App.class);
        assertSame(app.getMarketplace(), container.getComponent(Farfetch.class));
    }

    @Test
    public void shouldBuildInInjectDep2(){
        final Farfetch farfetch = container.getComponent(Farfetch.class);
        final Farfetch sFarfetch = container.getComponent(Farfetch.class);
        assertSame(farfetch, sFarfetch);
    }

    @Test
    public void shouldBuildInInjectDep3(){
        final Farfetch farfetch = container.getComponent(Farfetch.class);
        assertSame(container.getComponent(Farfetch.class), farfetch);
    }

    @Test
    public void shouldBuildInInjectDep4(){
        final Farfetch farfetch = container.getComponent(Farfetch.class);
        assertSame(container.getComponent(Marketplace.class), farfetch);
    }

    @Test
    public void shouldBuildingInInjectDep5(){
        final ShoesBrand shoesBrand = container.getComponent(ShoesBrand.class);
        assertSame(container.getComponent(CalvinKlein.class), shoesBrand.getHighHeelBrand());
    }

    @Test
    public void shouldBuildingInInjectDep6(){
        final ShoesBrand shoesBrand = container.getComponent(ShoesBrand.class);
        assertSame(shoesBrand.getBootsBrand().getNike(), shoesBrand.getSneakersBrands().getNike());
    }

    @Test
    public void shouldBuildingInInjectDep7(){
        final Brand brand = container.getComponent(Brand.class);
        final ShoesBrand shoesBrand = container.getComponent(ShoesBrand.class);

        assertSame(brand.getBootsBrand().getNike(), shoesBrand.getSneakersBrands().getNike());
    }
}
