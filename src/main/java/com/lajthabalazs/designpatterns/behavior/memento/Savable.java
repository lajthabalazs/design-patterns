package com.lajthabalazs.designpatterns.behavior.memento;

public interface Savable<T extends Save> {
    T save();
    void restore(T save);
}
