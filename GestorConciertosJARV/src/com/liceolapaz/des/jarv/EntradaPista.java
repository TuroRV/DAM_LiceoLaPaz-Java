package com.liceolapaz.des.jarv;

public class EntradaPista extends Entrada {
    protected boolean backstage;
    protected static final double PRECIO_PISTA = 99.99;


    public EntradaPista(int código, boolean backstage) {
        super(código, PRECIO_PISTA);
        this.backstage = backstage;
    }

    public boolean getBackstage() {
        return backstage;
    }

    public void setBackstage(boolean backstage) {
        this.backstage = backstage;
    }

}
