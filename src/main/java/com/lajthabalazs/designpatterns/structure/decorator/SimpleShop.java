package com.lajthabalazs.designpatterns.structure.decorator;

import java.util.List;

public class SimpleShop implements Shop{

    @Override
    public List<String> sellItem() {
        return List.of("Take money", "Give item");
    }
}
