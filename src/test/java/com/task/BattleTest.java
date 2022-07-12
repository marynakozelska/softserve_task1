package com.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BattleTest {
    @Test
    @DisplayName("Moodle: 1")
    void testBattleMoodle1() {
//        arrange
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

//        act
        assert Battle.fight(chuck, bruce) == true;
        assert Battle.fight(dave, carl) == false;
        assert chuck.isAlive() == true;
        assert bruce.isAlive() == false;
        assert carl.isAlive() == true;
        assert dave.isAlive() == false;
    }

    @Test
    @DisplayName("1: Fight")
    void testFight1() {
        var carl = new Warrior();
        var jim = new Knight();
        assert !Battle.fight(carl, jim);
    }

    @Test
    @DisplayName("2: Fight")
    void testFight2() {
        var ramon = new Knight();
        var slevin = new Warrior();
        assert Battle.fight(ramon, slevin);
        assert ramon.isAlive();
    }

    @Test
    @DisplayName("3: Fight")
    void testFight3() {
        var bob = new Warrior();
        var mars = new Warrior();
        assert Battle.fight(bob, mars);
        assert bob.isAlive();
    }

    @Test
    @DisplayName("4: Fight")
    void testFight4() {
        var zeus = new Knight();
        var godkiller = new Warrior();
        assert Battle.fight(zeus, godkiller);
        assert zeus.isAlive();
    }

    @Test
    @DisplayName("5: Fight")
    void testFight5() {
        var husband = new Warrior();
        var wife = new Warrior();
        Battle.fight(husband, wife);
        assert !wife.isAlive();
    }

    @Test
    @DisplayName("6: Fight")
    void testFight6() {
        var dragon = new Warrior();
        var knight = new Knight();
        Battle.fight(dragon, knight);
        assert knight.isAlive();
    }

    @Test
    @DisplayName("7: Fight")
    void testFight7() {
        var unit1 = new Warrior();
        var unit2 = new Knight();
        var unit3 = new Warrior();
        Battle.fight(unit1, unit2);
        assert !Battle.fight(unit2, unit3);
    }

    @Test
    @DisplayName("8: Fight")
    void testFight8() {
        var unit1 = new Defender();
        var unit2 = new Rookie();
        Battle.fight(unit1, unit2);
        assert unit1.getHealth() == 60;
    }

    @Test
    @DisplayName("9: Fight")
    void testFight9() {
        var unit1 = new Defender();
        var unit2 = new Rookie();
        var unit3 = new Warrior();
        Battle.fight(unit1, unit2);
        assert Battle.fight(unit1, unit3);
    }

}

class ArmyTest {
    @Test
    @DisplayName("Moodle: Army")
    void testArmyMoodle() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();

        assert Battle.fight(chuck, bruce) == true;
        assert Battle.fight(dave, carl) == false;
        assert chuck.isAlive() == true;
        assert bruce.isAlive() == false;
        assert carl.isAlive() == true;
        assert dave.isAlive() == false;
        assert Battle.fight(carl, mark) == false;
        assert carl.isAlive() == false;

        var myArmy = new Army();
        myArmy.addUnits(() -> new Knight(), 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(() -> new Warrior(), 3);

        var army3 = new Army();
        army3.addUnits(() -> new Warrior(), 20);
        army3.addUnits(() -> new Knight(), 5);

        var army4 = new Army();
        army4.addUnits(() -> new Warrior(), 30);

        assert Battle.fight(myArmy, enemyArmy);
        assert Battle.fight(army3, army4) == false;
    }

    @Test
    @DisplayName("1: Army")
    void testArmy1() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior::new, 1);
        army2.addUnits(Warrior::new, 2);

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("2: Army")
    void testArmy2() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior::new, 2);
        army2.addUnits(Warrior::new, 3);

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("3: Army")
    void testArmy3() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior::new, 5);
        army2.addUnits(Warrior::new, 7);

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("4: Army")
    void testArmy4() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior::new, 20);
        army2.addUnits(Warrior::new, 21);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("5: Army")
    void testArmy5() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior::new, 10);
        army2.addUnits(Warrior::new, 11);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("6: Army")
    void testArmy6() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior::new, 11);
        army2.addUnits(Warrior::new, 7);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("Moodle: Army 2")
    void testArmyMoodle2() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();

        assert Battle.fight(chuck, bruce) == true;
        assert Battle.fight(dave, carl) == false;
        assert chuck.isAlive() == true;
        assert bruce.isAlive() == false;
        assert carl.isAlive() == true;
        assert dave.isAlive() == false;
        assert Battle.fight(carl, mark) == false;
        assert carl.isAlive() == false;
        assert Battle.fight(bob, mike) == false;
        assert Battle.fight(lancelot, rog) == true;

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Defender::new, 1);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 2);

        assert Battle.fight(myArmy, enemyArmy) == false;
        assert Battle.fight(army3, army4) == true;
    }


    @Test
    @DisplayName("7: Army")
    void testArmy7() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 5);
        army1.addUnits(Defender::new, 4);
        army1.addUnits(Defender::new, 5);
        army2.addUnits(Warrior::new, 4);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("8: Army")
    void testArmy8() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 5);
        army1.addUnits(Warrior::new, 20);
        army2.addUnits(Warrior::new, 21);
        army1.addUnits(Defender::new, 4);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("9: Army")
    void testArmy9() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 10);
        army1.addUnits(Defender::new, 5);
        army2.addUnits(Warrior::new, 5);
        army1.addUnits(Defender::new, 10);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("10: Army")
    void testArmy10() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 2);
        army1.addUnits(Warrior::new, 1);
        army1.addUnits(Defender::new, 1);
        army2.addUnits(Warrior::new, 5);

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("Moodle: Army 3 with Vampires")
    void testArmyMoodle3() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();

        assert Battle.fight(chuck, bruce) == true;
        assert Battle.fight(dave, carl) == false;
        assert chuck.isAlive() == true;
        assert bruce.isAlive() == false;
        assert carl.isAlive() == true;
        assert dave.isAlive() == false;
        assert Battle.fight(carl, mark) == false;
        assert carl.isAlive() == false;
        assert Battle.fight(bob, mike) == false;
        assert Battle.fight(lancelot, rog) == true;
        assert Battle.fight(eric, richard) == false;
        assert Battle.fight(ogre, adam) == true;

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Warrior::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);
        enemyArmy.addUnits(Defender::new, 2);
        enemyArmy.addUnits(Vampire::new, 3);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Defender::new, 4);

        var army4 = new Army();
        army4.addUnits(Vampire::new, 3);
        army4.addUnits(Warrior::new, 2);

        assert Battle.fight(myArmy, enemyArmy) == false;
        assert Battle.fight(army3, army4) == true;
    }

    @Test
    @DisplayName("11: Army")
    void testArmy11() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 5);
        army1.addUnits(Vampire::new, 6);
        army1.addUnits(Warrior::new, 7);
        army2.addUnits(Warrior::new, 6);
        army2.addUnits(Defender::new, 6);
        army2.addUnits(Vampire::new, 6);

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("12: Army")
    void testArmy12() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 2);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 3);

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("13: Army")
    void testArmy13() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 11);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 13);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("14: Army")
    void testArmy14() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 9);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 8);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 13);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("Moodle: Army 4 with Lancers")
    void testArmyMoodle4() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();
        var freelancer = new Lancer();
        var vampire = new Vampire();

        assert Battle.fight(chuck, bruce) == true;
        assert Battle.fight(dave, carl) == false;
        assert chuck.isAlive() == true;
        assert bruce.isAlive() == false;
        assert carl.isAlive() == true;
        assert dave.isAlive() == false;
        assert Battle.fight(carl, mark) == false;
        assert carl.isAlive() == false;
        assert Battle.fight(bob, mike) == false;
        assert Battle.fight(lancelot, rog) == true;
        assert Battle.fight(eric, richard) == false;
        assert Battle.fight(ogre, adam) == true;
        assert Battle.fight(freelancer, vampire) == true;
        assert freelancer.isAlive() == true;

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Lancer::new, 4);
        myArmy.addUnits(Warrior::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);
        enemyArmy.addUnits(Lancer::new, 2);
        enemyArmy.addUnits(Defender::new, 2);
        enemyArmy.addUnits(Vampire::new, 3);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Lancer::new, 1);
        army3.addUnits(Defender::new, 2);

        var army4 = new Army();
        army4.addUnits(Vampire::new, 3);
        army4.addUnits(Warrior::new, 1);
        army4.addUnits(Lancer::new, 2);

        assert Battle.fight(myArmy, enemyArmy) == true;
        assert Battle.fight(army3, army4) == false;
    }

    @Test
    @DisplayName("15: Army")
    void testArmy15() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 5);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new, 5);

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("16: Army")
    void testArmy16() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 7);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new, 4);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("17: Army")
    void testArmy17() {
        var armyWarrior = new Army();
        var armyLancer = new Army();

        armyWarrior.addUnits(Warrior::new, 2);
        armyLancer.addUnits(Lancer::new, 1);
        armyLancer.addUnits(Warrior::new, 1);

        assert !Battle.fight(armyWarrior, armyLancer);
    }

    @Test
    @DisplayName("Moodle: Army 5 with Healers")
    void testArmyMoodle5() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();
        var freelancer = new Lancer();
        var vampire = new Vampire();
        var priest = new Healer();

        assert Battle.fight(chuck, bruce) == true;
        assert Battle.fight(dave, carl) == false;
        assert chuck.isAlive() == true;
        assert bruce.isAlive() == false;
        assert carl.isAlive() == true;
        assert dave.isAlive() == false;
        assert Battle.fight(carl, mark) == false;
        assert carl.isAlive() == false;
        assert Battle.fight(bob, mike) == false;
        assert Battle.fight(lancelot, rog) == true;
        assert Battle.fight(eric, richard) == false;
        assert Battle.fight(ogre, adam) == true;
        assert Battle.fight(freelancer, vampire) == true;
        assert freelancer.isAlive() == true;
        assert freelancer.getHealth() == 14;
        priest.heal(freelancer);
        assert freelancer.getHealth() == 16;

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Warrior::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);
        enemyArmy.addUnits(Lancer::new, 4);
        enemyArmy.addUnits(Healer::new, 1);
        enemyArmy.addUnits(Defender::new, 2);
        enemyArmy.addUnits(Vampire::new, 3);
        enemyArmy.addUnits(Healer::new, 1);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Lancer::new, 1);
        army3.addUnits(Healer::new, 1);
        army3.addUnits(Defender::new, 2);

        var army4 = new Army();
        army4.addUnits(Vampire::new, 3);
        army4.addUnits(Warrior::new, 1);
        army4.addUnits(Healer::new, 1);
        army4.addUnits(Lancer::new, 2);

        assert Battle.fight(myArmy, enemyArmy) == false;
        assert Battle.fight(army3, army4) == true;
    }

    @Test
    @DisplayName("18: Army")
    void testArmy18() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 7);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Healer::new, 1);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new, 4);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("18_1: Army")
    void testArmy18_1() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 1);
        army1.addUnits(Warrior::new, 3);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Knight::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Healer::new, 1);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new, 4);

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("Moodle: Army 6 straight fight")
    void testArmyMoodle6() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();
        var freelancer = new Lancer();
        var vampire = new Vampire();
        var priest = new Healer();

        assert Battle.fight(chuck, bruce) == true;
        assert Battle.fight(dave, carl) == false;
        assert chuck.isAlive() == true;
        assert bruce.isAlive() == false;
        assert carl.isAlive() == true;
        assert dave.isAlive() == false;
        assert Battle.fight(carl, mark) == false;
        assert carl.isAlive() == false;
        assert Battle.fight(bob, mike) == false;
        assert Battle.fight(lancelot, rog) == true;
        assert Battle.fight(eric, richard) == false;
        assert Battle.fight(ogre, adam) == true;
        assert Battle.fight(freelancer, vampire) == true;
        assert freelancer.isAlive() == true;
        assert freelancer.getHealth() == 14;
        priest.heal(freelancer);
        assert freelancer.getHealth() == 16;

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Warrior::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);
        enemyArmy.addUnits(Lancer::new, 4);
        enemyArmy.addUnits(Healer::new, 1);
        enemyArmy.addUnits(Defender::new, 2);
        enemyArmy.addUnits(Vampire::new, 3);
        enemyArmy.addUnits(Healer::new, 1);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Lancer::new, 1);
        army3.addUnits(Healer::new, 1);
        army3.addUnits(Defender::new, 2);

        var army4 = new Army();
        army4.addUnits(Vampire::new, 3);
        army4.addUnits(Warrior::new, 1);
        army4.addUnits(Healer::new, 1);
        army4.addUnits(Lancer::new, 2);

        var army5 = new Army();
        army5.addUnits(Warrior::new, 10);

        var army6 = new Army();
        army6.addUnits(Warrior::new, 6);
        army6.addUnits(Lancer::new, 5);

        assert Battle.fight(myArmy, enemyArmy) == false;
        assert Battle.fight(army3, army4) == true;
        assert Battle.straightFight(army5, army6) == false;
    }

    @Test
    @DisplayName("19: Army")
    void testArmy19() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 5);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new, 5);

        assert !Battle.straightFight(army1, army2);
    }

    @Test
    @DisplayName("20: Army")
    void testArmy20() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 7);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new, 4);

        assert Battle.straightFight(army1, army2);
    }

    @Test
    @DisplayName("21: Army")
    void testArmy21() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 7);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Defender::new, 2);

        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Healer::new, 1);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new, 4);

        assert !Battle.straightFight(army1, army2);
    }

    @Test
    @DisplayName("22: Army")
    void testArmy22() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 4);
        army1.addUnits(Warrior::new, 3);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Knight::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Healer::new, 1);
        army2.addUnits(Vampire::new, 2);
        army2.addUnits(Lancer::new, 4);

        assert Battle.straightFight(army1, army2);
    }
}

class WeaponTest {
    @Test
    @DisplayName("Moodle: Weapon")
    void testArmyMoodle7() {
        var ogre = new Warrior();
        var lancelot = new Knight();
        var richard = new Defender();
        var eric = new Vampire();
        var freelancer = new Lancer();
        var priest = new Healer();

        // you may consider using another interfaces for the predefined weapon
        // e.g. you could use enum or some factory
        var sword = Weapon.getSword();
        var shield = Weapon.getShield();
        var axe = Weapon.getGreatAxe();
        var katana = Weapon.getKatana();
        var wand = Weapon.getMagicWand();

        // consider using a builder instead
        var superWeapon = Weapon.builder()
                .health(50)
                .attack(10)
                .defense(5)
                .vampirism(150)
                .healPower(8)
                .build();

        ogre.equipWeapon(sword);
        ogre.equipWeapon(shield);
        ogre.equipWeapon(superWeapon);
        lancelot.equipWeapon(superWeapon);
        richard.equipWeapon(shield);
        eric.equipWeapon(superWeapon);
        freelancer.equipWeapon(axe);
        freelancer.equipWeapon(katana);
        priest.equipWeapon(wand);   // 2 + 3
        priest.equipWeapon(shield);

        assert ogre.getHealth() == 125;
        assert lancelot.getAttack() == 17;
        assert richard.getDefense() == 4;
        assert eric.getVampirism() == 200;
        assert freelancer.getHealth() == 15;
        assert priest.getHealingPower() == 5;

        assert Battle.fight(ogre, eric) == false;
        assert Battle.fight(priest, richard) == false;
        assert Battle.fight(lancelot, freelancer) == true;

        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 1);
        myArmy.addUnits(Lancer::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, axe);
        myArmy.equipWarriorAtPosition(1, superWeapon);

        enemyArmy.equipWarriorAtPosition(0, katana);
        enemyArmy.equipWarriorAtPosition(1, wand);

        assert Battle.fight(myArmy, enemyArmy) == true;
    }

    @Test
    @DisplayName("1: Weapon")
    void testWeapon1() {
        var unit1 = new Warrior();
        var unit2 = new Vampire();

        var weapon1 = Weapon.builder()
                .health(-10)
                .attack(5)
                .vampirism(0)
                .defense(40)
                .healPower(0)
                .build();
        var weapon2 = Weapon.getSword();

        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);

        assert Battle.fight(unit1, unit2);
    }

    @Test
    @DisplayName("2: Weapon")
    void testWeapon2() {
        var unit1 = new Defender();
        var unit2 = new Lancer();

        var weapon1 = Weapon.getShield();
        var weapon2 = Weapon.getGreatAxe();

        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);

        assert !Battle.fight(unit1, unit2);
    }

    @Test
    @DisplayName("3: Weapon")
    void testWeapon3() {
        var unit1 = new Healer();
        var unit2 = new Knight();

        var weapon1 = Weapon.getMagicWand();
        var weapon2 = Weapon.getKatana();

        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);

        assert !Battle.fight(unit1, unit2);
    }

    @Test
    @DisplayName("4: Weapon")
    void testWeapon4() {
        var unit1 = new Defender();
        var unit2 = new Vampire();

        var weapon1 = Weapon.getShield();
        var weapon2 = Weapon.getMagicWand();
        var weapon3 = Weapon.getShield();
        var weapon4 = Weapon.getKatana();

        unit1.equipWeapon(weapon1);
        unit1.equipWeapon(weapon2);
        unit2.equipWeapon(weapon3);
        unit2.equipWeapon(weapon4);

        assert !Battle.fight(unit1, unit2);
    }

    @Test
    @DisplayName("5: Weapon")
    void testWeapon5() {
        var weapon1 = Weapon.getMagicWand();
        var weapon2 = Weapon.getGreatAxe();

        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 1);
        myArmy.addUnits(Lancer::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon2);

        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon2);

        assert Battle.fight(myArmy, enemyArmy);
    }

    @Test
    @DisplayName("6: Weapon")
    void testWeapon6() {
        var weapon1 = Weapon.getSword();
        var weapon2 = Weapon.getGreatAxe();

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 1);
        myArmy.addUnits(Warrior::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Knight::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon2);
        myArmy.equipWarriorAtPosition(1, weapon2);

        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon1);

        assert Battle.fight(myArmy, enemyArmy);
    }

    @Test
    @DisplayName("7: Weapon")
    void testWeapon7() {
        var weapon1 = Weapon.getKatana();
        var weapon2 = Weapon.getShield();

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Knight::new, 1);
        enemyArmy.addUnits(Vampire::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);

        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon1);

        assert !Battle.fight(myArmy, enemyArmy);
    }

    @Test
    @DisplayName("8: Weapon")
    void testWeapon8() {
        var weapon1 = Weapon.builder()
                .health(-20)
                .attack(6)
                .defense(1)
                .vampirism(40)
                .healPower(-2)
                .build();
        var weapon2 = Weapon.builder()
                .health(20)
                .attack(-2)
                .defense(2)
                .vampirism(-55)
                .healPower(3)
                .build();

        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 2);

        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon2);

        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon2);
        enemyArmy.equipWarriorAtPosition(2, weapon2);

        assert Battle.fight(myArmy, enemyArmy);
    }

    @Test
    @DisplayName("9: Weapon")
    void testWeapon9() {
        var weapon1 = Weapon.builder()
                .health(-20)
                .attack(1)
                .defense(1)
                .vampirism(40)
                .healPower(-2)
                .build();
        var weapon2 = Weapon.builder()
                .health(20)
                .attack(2)
                .defense(2)
                .vampirism(-55)
                .healPower(3)
                .build();

        var myArmy = new Army();
        myArmy.addUnits(Vampire::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 2);

        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon2);

        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon2);
        enemyArmy.equipWarriorAtPosition(2, weapon2);

        assert !Battle.straightFight(myArmy, enemyArmy);
    }

    @Test
    @DisplayName("10: Weapon")
    void testWeapon10() {
        var weapon1 = Weapon.getKatana();
        var weapon2 = Weapon.getShield();

        var myArmy = new Army();
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Rookie::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 2);

        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon2);

        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon2);
        enemyArmy.equipWarriorAtPosition(2, weapon2);

        assert Battle.straightFight(myArmy, enemyArmy);
    }

    @Test
    @DisplayName("11: Weapon")
    void testWeapon11() {
        var weapon1 = Weapon.getSword();
        var weapon2 = Weapon.getGreatAxe();

        var myArmy = new Army();
        myArmy.addUnits(Vampire::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon2);
        myArmy.equipWarriorAtPosition(1, weapon2);
        myArmy.equipWarriorAtPosition(2, weapon2);

        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon1);

        assert Battle.straightFight(myArmy, enemyArmy);
    }

    @Test
    @DisplayName("12: Weapon")
    void testWeapon12() {
        var weapon1 = Weapon.getKatana();
        var weapon2 = Weapon.getMagicWand();

        var myArmy = new Army();
        myArmy.addUnits(Rookie::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Defender::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon1);

        enemyArmy.equipWarriorAtPosition(0, weapon2);
        enemyArmy.equipWarriorAtPosition(1, weapon2);

        assert !Battle.fight(myArmy, enemyArmy);
    }
}

class WarlordTest {
    @Test
    @DisplayName("Moodle: Warlords")
    void testWarlordsMoodle() {
        var ronald = new Warlord();
        var heimdall = new Knight();

        assert Battle.fight(heimdall, ronald) == false;

        var myArmy = new Army();
        myArmy.addUnits(Warlord::new, 1);
        myArmy.addUnits(Warrior::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warlord::new, 3);
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 2);
        enemyArmy.addUnits(Knight::new, 2);

        myArmy.moveUnits();
        enemyArmy.moveUnits();

// you can provide any other interface for testing the order
        assert myArmy.unitAtPosition(0).getClass() == Lancer.class;
        assert myArmy.unitAtPosition(1).getClass() == Healer.class;
// negative index means from the last position, so -1 == last
        assert myArmy.unitAtPosition(-1).getClass() == Warlord.class;

        assert enemyArmy.unitAtPosition(0).getClass() == Vampire.class;
        assert enemyArmy.unitAtPosition(-1).getClass() == Warlord.class;
        assert enemyArmy.unitAtPosition(-2).getClass() == Knight.class;

//6, not 8, because only 1 Warlord per army could be
        assert enemyArmy.size() == 6;

        assert Battle.fight(myArmy, enemyArmy) == true;
    }

    @Test
    @DisplayName("10: Fight with warlord")
    void testWarlord1() {
        var unit1 = new Defender();
        var unit2 = new Warlord();

        assert !Battle.fight(unit1, unit2);
    }

    @Test
    @DisplayName("11: Fight with warlord")
    void testWarlord2() {
        var unit1 = new Warlord();
        var unit2 = new Vampire();

        assert Battle.fight(unit1, unit2);
    }

    @Test
    @DisplayName("12: Fight with warlord")
    void testWarlord3() {
        var unit1 = new Warlord();
        var unit2 = new Knight();

        assert Battle.fight(unit1, unit2);
    }

    @Test
    @DisplayName("23: Armies fight with warlord")
    void testWarlord4() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warlord::new, 1);
        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Lancer::new, 2);
        army1.addUnits(Healer::new, 2);

        army2.addUnits(Warlord::new, 1);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Healer::new, 2);
        army2.addUnits(Knight::new, 2);

        army1.moveUnits();
        army2.moveUnits();

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("24: Armies fight with warlord")
    void testWarlord5() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Lancer::new, 2);
        army1.addUnits(Defender::new, 1);
        army1.addUnits(Warlord::new, 3);

        army2.addUnits(Warlord::new, 2);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Healer::new, 5);
        army2.addUnits(Knight::new, 2);

        army1.moveUnits();
        army2.moveUnits();

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("25: Armies fight with warlord")
    void testWarlord6() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Lancer::new, 3);
        army1.addUnits(Defender::new, 1);
        army1.addUnits(Warlord::new, 4);

        army2.addUnits(Warlord::new, 1);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Rookie::new, 1);
        army2.addUnits(Knight::new, 1);

        army1.getWarrior(0).equipWeapon(Weapon.getSword());
        army2.getWarrior(0).equipWeapon(Weapon.getShield());

        army1.moveUnits();
        army2.moveUnits();

        assert Battle.fight(army1, army2);
    }
    @Test
    @DisplayName("26: Armies fight with warlord")
    void testWarlord7() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Lancer::new, 3);
        army1.addUnits(Defender::new, 1);
        army1.addUnits(Warlord::new, 1);

        army2.addUnits(Warlord::new, 5);
        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Rookie::new, 1);
        army2.addUnits(Knight::new, 1);

        army1.getWarrior(0).equipWeapon(Weapon.getSword());
        army2.getWarrior(0).equipWeapon(Weapon.getShield());

        army1.moveUnits();
        army2.moveUnits();

        assert !Battle.straightFight(army1, army2);
    }
}

class WitchTest {
    @Test
    @DisplayName("1: Witch Test")
    void testWitch1() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Witch::new, 1);
        army2.addUnits(Warrior::new, 1);
        army2.addUnits(Warrior::new, 1);
        army2.addUnits(Warrior::new, 1);

        assert !Battle.straightFight(army1, army2);
    }

    @Test
    @DisplayName("2: Witch Test")
    void testWitch2() {
        var witch = new Witch();
        var vampire = new Vampire();

        assert Battle.fight(witch, vampire);
    }

    @Test
    @DisplayName("3: Witch Test")
    void testWitch3() {
        var armyWitches = new Army();
        var armyVampires = new Army();

        armyWitches.addUnits(Witch::new, 1);
        armyVampires.addUnits(Vampire::new, 2);

        assert !Battle.fight(armyWitches, armyVampires);
    }

    @Test
    @DisplayName("4: Witch Test")
    void testWitch4() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Witch::new, 1);

        army2.addUnits(Vampire::new, 1);
        army2.addUnits(Lancer::new, 2);

        assert !Battle.straightFight(army1, army2);
    }

    @Test
    @DisplayName("5: Witch Test")
    void testWitch5() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Witch::new, 1);
        army1.addUnits(Healer::new, 4);

        army2.addUnits(Warrior::new, 3);
        army2.addUnits(Lancer::new, 2);

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("6: Witch Test")
    void testWitch6() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Witch::new, 1);
        army1.addUnits(Healer::new, 4);

        army2.addUnits(Warrior::new, 3);
        army2.addUnits(Lancer::new, 2);

        army1.equipWarriorAtPosition(0, Weapon.getMagicSleeves());

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("7: Witch Test")
    void testWitch7() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Witch::new, 1);
        army1.addUnits(Healer::new, 2);

        army2.addUnits(Lancer::new, 1);
        army2.addUnits(Warrior::new, 3);

        army1.equipWarriorAtPosition(0, Weapon.getMagicSleeves());

        assert Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("8: Witch Test")
    void testWitch8() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Healer::new, 2);

        army2.addUnits(Witch::new, 1);
        army2.addUnits(Warrior::new, 3);

        army1.equipWarriorAtPosition(0, Weapon.getMagicSleeves());

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("9: Witch Test")
    void testWitch9() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Witch::new, 1);
        army1.addUnits(Warrior::new, 2);

        army2.addUnits(Witch::new, 1);
        army2.addUnits(Lancer::new, 2);

        army2.equipWarriorAtPosition(0, Weapon.getMagicSleeves());

        assert !Battle.fight(army1, army2);
    }

    @Test
    @DisplayName("10: Witch Test")
    void testWitch10() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 1);
        army1.addUnits(Vampire::new, 2);

        army2.addUnits(Witch::new, 2);

        army1.equipWarriorAtPosition(0, Weapon.getMagicSleeves());

        assert Battle.fight(army1, army2);
    }
}

class FanaticTest {
    @Test
    @DisplayName("1: Fanatic Test")
    void testFanatic1() {
        var fanatic = new Fanatic();
        var warrior = new Warrior();

        assert !Battle.fight(fanatic, warrior);
    }

    @Test
    @DisplayName("2: Fanatic Test")
    void testFanatic2() {
        var witch = new Witch();
        var fanatic = new Fanatic();

        assert Battle.fight(witch, fanatic);
    }
}
