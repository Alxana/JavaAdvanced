package com.exadel.lombok.ownerProperies;

import com.exadel.lombok.enumerations.CuteLevel;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:cuteLevel.properties")
public interface CuteLevelInterface extends Config {

    @Key("bad")
    @ConverterClass(CuteLevelConverter.class)
    CuteLevel getBadCatValue();

    @Key("fat")
    @ConverterClass(CuteLevelConverter.class)
    CuteLevel getFatCatValue();
}
