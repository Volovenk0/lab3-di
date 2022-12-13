package org.fpm.di.example.Models;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BootsBrand {
    private final TNF tnf;
    private final Nike nike;

    @Inject
    public BootsBrand(TNF tnf, Nike nike){
        this.tnf = tnf;
        this.nike = nike;
    }

    public TNF getTnf() {
        return tnf;
    }

    public Nike getNike() {
        return nike;
    }
}
