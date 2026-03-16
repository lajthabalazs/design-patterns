package com.lajthabalazs.designpatterns.structure.adapter;

public class Horse {
    private boolean highlighted = false;

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public String render() {
        if(highlighted) {
            return "Highlighted horse";
        } else {
            return "Horse";
        }
    }
}
