package com.exadel.lombok;


import com.exadel.lombok.animals.Animal;
import com.exadel.lombok.animals.inheritors.Kitty;
import com.exadel.lombok.enumerations.CatPosition;
import com.exadel.lombok.enumerations.DayPart;
import com.exadel.lombok.food.EatCharacteristics;
import com.exadel.lombok.food.KittyCat;
import com.exadel.lombok.humans.Owner;
import lombok.Cleanup;

import static com.exadel.lombok.enumerations.CuteLevel.BEST_CAT;
import static com.exadel.lombok.ownerProperies.PropertyHolder.cuteLevelInterface;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("cat", 5.1);
        System.out.println(animal.toString());

        KittyCat kittyCat = new KittyCat("kitty food", 7.5);
        System.out.println(kittyCat.toString());

        Owner owner = new Owner();
        owner.setFirstName("Alexandra");
        owner.setLastName("Voranava");

        @Cleanup("killKitty") Kitty kitty = new Kitty("Mimi", 3.7);
        kitty.setCuteLevel(BEST_CAT);
        kitty.setDailyFood(kittyCat);
        kitty.setOwner(owner);
        System.out.println(kitty.toString());

        EatCharacteristics eatCharacteristics =
                EatCharacteristics.builder().amountFoodEaten(2.5).catPosition(CatPosition.LAYING).dayPart(DayPart.DAY).createCharacteristic();

        System.out.println(eatCharacteristics.toString());
        kitty.eat(eatCharacteristics);


        @Cleanup("killKitty") Kitty badKitty = new Kitty("Bully", 5.0);
        badKitty.setCuteLevel(cuteLevelInterface.getBadCatValue());
        badKitty.setDailyFood(kittyCat);
        badKitty.setOwner(owner);
        System.out.println(badKitty.toString());

        EatCharacteristics badCatCharacteristics = EatCharacteristics.builder().amountFoodEaten(5.0).createCharacteristic();
        System.out.println(badCatCharacteristics.toString());

        badKitty.eat(badCatCharacteristics);


        @Cleanup("killKitty") Kitty fatKitty = new Kitty("Fatty", 10.0);
        fatKitty.setCuteLevel(cuteLevelInterface.getFatCatValue());
        fatKitty.setDailyFood(kittyCat);
        fatKitty.setOwner(owner);
        System.out.println(fatKitty.toString());

        EatCharacteristics fatCatCharacteristics = EatCharacteristics.builder().amountFoodEaten(2.0).createCharacteristic();
        System.out.println(fatCatCharacteristics.toString());

        fatKitty.eat(fatCatCharacteristics);

    }

}
