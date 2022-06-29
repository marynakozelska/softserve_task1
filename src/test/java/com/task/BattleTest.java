package com.task;

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
    @DisplayName("2: Fight")
    void testBattle2() {
        var carl = new Warrior();
        var jim = new Knight();
        assert !Battle.fight(carl, jim);
    }

    @Test
    @DisplayName("3: Fight")
    void testBattle3() {
        var ramon = new Knight();
        var slevin = new Warrior();
        assert Battle.fight(ramon, slevin);
        assert ramon.isAlive();
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

        assert Battle.fight(myArmy, enemyArmy) == true;
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
        var army_warrior = new Army();
        var army_lancer = new Army();

        army_warrior.addUnits(Warrior::new, 2);
        army_lancer.addUnits(Lancer::new, 1);
        army_lancer.addUnits(Warrior::new, 1);

        assert !Battle.fight(army_warrior, army_lancer);
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

        var my_army = new Army();
        my_army.addUnits(Defender::new, 2);
        my_army.addUnits(Healer::new, 1);
        my_army.addUnits(Vampire::new, 2);
        my_army.addUnits(Lancer::new, 2);
        my_army.addUnits(Healer::new, 1);
        my_army.addUnits(Warrior::new, 1);

        var enemy_army = new Army();
        enemy_army.addUnits(Warrior::new, 2);
        enemy_army.addUnits(Lancer::new, 4);
        enemy_army.addUnits(Healer::new, 1);
        enemy_army.addUnits(Defender::new, 2);
        enemy_army.addUnits(Vampire::new, 3);
        enemy_army.addUnits(Healer::new, 1);

        var army_3 = new Army();
        army_3.addUnits(Warrior::new, 1);
        army_3.addUnits(Lancer::new, 1);
        army_3.addUnits(Healer::new, 1);
        army_3.addUnits(Defender::new, 2);

        var army_4 = new Army();
        army_4.addUnits(Vampire::new, 3);
        army_4.addUnits(Warrior::new, 1);
        army_4.addUnits(Healer::new, 1);
        army_4.addUnits(Lancer::new, 2);

        assert Battle.fight(my_army, enemy_army) == false;
        assert Battle.fight(army_3, army_4) == true;
    }

    @Test
    @DisplayName("18: Army")
    void testArmy18() {
        var army_1 = new Army();
        var army_2 = new Army();

        army_1.addUnits(Lancer::new, 7);
        army_1.addUnits(Vampire::new, 3);
        army_1.addUnits(Healer::new, 1);
        army_1.addUnits(Warrior::new, 4);
        army_1.addUnits(Healer::new, 1);
        army_1.addUnits(Defender::new, 2);
        army_2.addUnits(Warrior::new, 4);
        army_2.addUnits(Defender::new, 4);
        army_2.addUnits(Healer::new, 1);
        army_2.addUnits(Vampire::new, 6);
        army_2.addUnits(Lancer::new, 4);

        assert Battle.fight(army_1, army_2);
    }

    @Test
    @DisplayName("18_1: Army")
    void testArmy18_1() {
        var army_1 = new Army();
        var army_2 = new Army();

        army_1.addUnits(Lancer::new, 1);
        army_1.addUnits(Warrior::new, 3);
        army_1.addUnits(Healer::new, 1);
        army_1.addUnits(Warrior::new, 4);
        army_1.addUnits(Healer::new, 1);
        army_1.addUnits(Knight::new, 2);
        army_2.addUnits(Warrior::new, 4);
        army_2.addUnits(Defender::new, 4);
        army_2.addUnits(Healer::new, 1);
        army_2.addUnits(Vampire::new, 6);
        army_2.addUnits(Lancer::new, 4);

        assert !Battle.fight(army_1, army_2);
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
        var army_1 = new Army();
        var army_2 = new Army();

        army_1.addUnits(Lancer::new, 5);
        army_1.addUnits(Vampire::new, 3);
        army_1.addUnits(Warrior::new, 4);
        army_1.addUnits(Defender::new, 2);
        army_2.addUnits(Warrior::new, 4);
        army_2.addUnits(Defender::new, 4);
        army_2.addUnits(Vampire::new, 6);
        army_2.addUnits(Lancer::new, 5);

        assert !Battle.straightFight(army_1, army_2);
    }

    @Test
    @DisplayName("20: Army")
    void testArmy20() {
        var army_1 = new Army();
        var army_2 = new Army();

        army_1.addUnits(Lancer::new, 7);
        army_1.addUnits(Vampire::new, 3);
        army_1.addUnits(Warrior::new, 4);
        army_1.addUnits(Defender::new, 2);
        army_2.addUnits(Warrior::new, 4);
        army_2.addUnits(Defender::new, 4);
        army_2.addUnits(Vampire::new, 6);
        army_2.addUnits(Lancer::new, 4);

        assert Battle.straightFight(army_1, army_2);
    }

    @Test
    @DisplayName("21: Army")
    void testArmy21() {
        var army_1 = new Army();
        var army_2 = new Army();

        army_1.addUnits(Lancer::new, 7);
        army_1.addUnits(Vampire::new, 3);
        army_1.addUnits(Healer::new, 1);
        army_1.addUnits(Warrior::new, 4);
        army_1.addUnits(Healer::new, 1);
        army_1.addUnits(Defender::new, 2);
        army_2.addUnits(Warrior::new, 4);
        army_2.addUnits(Defender::new, 4);
        army_2.addUnits(Healer::new, 1);
        army_2.addUnits(Vampire::new, 6);
        army_2.addUnits(Lancer::new, 4);

        assert !Battle.straightFight(army_1, army_2);
    }

    @Test
    @DisplayName("22: Army")
    void testArmy22() {
        var army_1 = new Army();
        var army_2 = new Army();

        army_1.addUnits(Lancer::new, 4);
        army_1.addUnits(Warrior::new, 3);
        army_1.addUnits(Healer::new, 1);
        army_1.addUnits(Warrior::new, 4);
        army_1.addUnits(Healer::new, 1);
        army_1.addUnits(Knight::new, 2);
        army_2.addUnits(Warrior::new, 4);
        army_2.addUnits(Defender::new, 4);
        army_2.addUnits(Healer::new, 1);
        army_2.addUnits(Vampire::new, 2);
        army_2.addUnits(Lancer::new, 4);

        assert Battle.straightFight(army_1, army_2);
    }

}