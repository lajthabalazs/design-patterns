package com.lajthabalazs.designpatterns.structure.flyweight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlyweightTest {

    @Test
    public void testFlyweight() {
        var contractStore = new ContractStore();
        var aliceContract = contractStore.createContract("Let's agree!", "Alice");
        aliceContract.sign("A");
        var bobContract = contractStore.createContract("Let's agree!", "Bob");
        bobContract.sign("B");
        var carolContract = contractStore.createContract("Let's agree!", "Carol");
        var danContract = contractStore.createContract("We should do this!", "Dan");
        danContract.sign("D");
        var erinContract = contractStore.createContract("We should do this!", "Erin");
        var frankContract = contractStore.createContract("Something nefarious...", "Frank");

        Assertions.assertEquals(3, contractStore.getTemplateCount());
        Assertions.assertEquals("""
                Contract text: Let's agree!
                Assigned to: Alice
                Status: Signed
                Signature; A""", aliceContract.displayContract());
        Assertions.assertEquals("""
                Contract text: Let's agree!
                Assigned to: Bob
                Status: Signed
                Signature; B""", bobContract.displayContract());
        Assertions.assertEquals("""
                Contract text: Let's agree!
                Assigned to: Carol
                Status: Signature needed""", carolContract.displayContract());
        Assertions.assertEquals("""
                Contract text: We should do this!
                Assigned to: Dan
                Status: Signed
                Signature; D""", danContract.displayContract());
        Assertions.assertEquals("""
                Contract text: We should do this!
                Assigned to: Erin
                Status: Signature needed""", erinContract.displayContract());
        Assertions.assertEquals("""
                Contract text: Something nefarious...
                Assigned to: Frank
                Status: Signature needed""", frankContract.displayContract());

    }
}
