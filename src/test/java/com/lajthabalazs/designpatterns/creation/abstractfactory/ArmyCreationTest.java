package com.lajthabalazs.designpatterns.creation.abstractfactory;

import com.lajthabalazs.designpatterns.creation.abstractfactory.elf.Drow;
import com.lajthabalazs.designpatterns.creation.abstractfactory.elf.EldritchKnight;
import com.lajthabalazs.designpatterns.creation.abstractfactory.elf.ElfFactory;
import com.lajthabalazs.designpatterns.creation.abstractfactory.elf.HighElf;
import com.lajthabalazs.designpatterns.creation.abstractfactory.human.ArcaneTrickster;
import com.lajthabalazs.designpatterns.creation.abstractfactory.human.Champion;
import com.lajthabalazs.designpatterns.creation.abstractfactory.human.HumanFactory;
import com.lajthabalazs.designpatterns.creation.abstractfactory.human.Sorcerer;
import com.lajthabalazs.designpatterns.creation.abstractfactory.ork.Assasin;
import com.lajthabalazs.designpatterns.creation.abstractfactory.ork.Barbarian;
import com.lajthabalazs.designpatterns.creation.abstractfactory.ork.OrkFactory;
import com.lajthabalazs.designpatterns.creation.abstractfactory.ork.Warlock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

public class ArmyCreationTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new HumanFactory(), Map.of(
                                Warrior.class, Champion.class,
                                Mage.class, Sorcerer.class,
                                Rogue.class, ArcaneTrickster.class
                        )
                ),
                Arguments.of(
                        new OrkFactory(), Map.of(
                                Warrior.class, Barbarian.class,
                                Mage.class, Warlock.class,
                                Rogue.class, Assasin.class
                        )
                ),
                Arguments.of(
                        new ElfFactory(), Map.of(
                                Warrior.class, EldritchKnight.class,
                                Mage.class, HighElf.class,
                                Rogue.class, Drow.class
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void test(ArmyFactory factory, Map<Class<Unit>, Class<Unit>> typeMap) {
        var warrior = factory.creatWarrior();
        var mage = factory.createMage();
        var rogue = factory.createRogue();
        Assertions.assertInstanceOf(typeMap.get(Warrior.class), warrior);
        Assertions.assertInstanceOf(typeMap.get(Mage.class), mage);
        Assertions.assertInstanceOf(typeMap.get(Rogue.class), rogue);
    }
    
}
