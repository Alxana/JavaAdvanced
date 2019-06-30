package com.exadel.lombok.ownerProperies;

import org.aeonbits.owner.ConfigFactory;

public class PropertyHolder {

    public static CuteLevelInterface cuteLevelInterface = ConfigFactory.create(CuteLevelInterface.class);
    public static CaloriesInterface caloriesInterface = ConfigFactory.create(CaloriesInterface.class);
}
