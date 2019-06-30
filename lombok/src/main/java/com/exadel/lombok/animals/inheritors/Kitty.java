package com.exadel.lombok.animals.inheritors;

import com.exadel.lombok.animals.Animal;
import com.exadel.lombok.enumerations.CuteLevel;
import com.exadel.lombok.food.EatCharacteristics;
import com.exadel.lombok.food.KittyCat;
import com.exadel.lombok.humans.Owner;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

@Log4j2
@ToString(callSuper = true)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Kitty extends Animal {

    public Kitty(String name, double weight) {
        super(name, weight);
        log.info("Котэ был рождён");
    }

    private @EqualsAndHashCode.Include
    CuteLevel cuteLevel;
    private @EqualsAndHashCode.Include
    Owner owner;
    private KittyCat dailyFood;

    public void eat(EatCharacteristics eatCharacteristic) {
        double foodLeft = dailyFood.getWeight() - eatCharacteristic.getAmountFoodEaten();

        if (dailyFood.getWeight() == 0.0) {
            log.warn("Кот обеспокоен нехваткой пищи");
        } else if (foodLeft >= 0.0) {
            log.info("Кот поел, сталось еды: " + foodLeft);
            dailyFood.setWeight(foodLeft);
        } else {
            log.warn("Еды не хватает!");
            dailyFood.setWeight(0.0);
        }

    }

    @SneakyThrows(InterruptedException.class)
    public void killKitty() {
        log.error(StringUtils.join("Кот ", this.getName(), " умер"));
        if (!this.getCuteLevel().equals(CuteLevel.BAD_CAT)) {
            log.info(StringUtils.join("Хозяин ", this.getOwner().getFirstName(), " ", this.getOwner().getLastName(), " в печали"));
            throw new InterruptedException();
        }
    }

}
