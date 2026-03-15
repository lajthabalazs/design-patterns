package com.lajthabalazs.designpatterns.structure.decorator;

public abstract class ShopDecorator implements Shop{
    private final Shop coreShop;

    public ShopDecorator(Shop coreShop) {
        this.coreShop = coreShop;
    }

    protected Shop getCoreShop() {
        return coreShop;
    }
}
