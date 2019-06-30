package com.exadel.lombok.ownerProperies;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:calories.properties")
public interface CaloriesInterface extends Config {
    @Key("kittyCat")
    int getKittyCatValue();

}
