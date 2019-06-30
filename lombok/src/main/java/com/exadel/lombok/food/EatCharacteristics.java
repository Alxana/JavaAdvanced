package com.exadel.lombok.food;

import com.exadel.lombok.enumerations.CatPosition;
import com.exadel.lombok.enumerations.DayPart;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder(builderClassName = "FoodCollector", buildMethodName = "createCharacteristic")
@ToString
public class EatCharacteristics {

    private double amountFoodEaten;
    private DayPart dayPart;
    private CatPosition catPosition;

}
