package com.exadel.lombok.ownerProperies;

import com.exadel.lombok.enumerations.CuteLevel;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class CuteLevelConverter implements Converter<CuteLevel> {
    public CuteLevel convert(Method method, String input) {
        return CuteLevel.valueOf(input);
    }
}
