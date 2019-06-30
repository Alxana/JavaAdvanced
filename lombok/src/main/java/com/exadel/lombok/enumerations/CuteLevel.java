package com.exadel.lombok.enumerations;

import org.apache.commons.lang3.StringUtils;

public enum CuteLevel {

    GOOD_CAT,
    BAD_CAT,
    FAT_CAT,
    SUPER_CAT,
    SMELLY_CAT,
    BEST_CAT;


    @Override
    public String toString() {
        String res = StringUtils.lowerCase(super.toString());
        res = StringUtils.capitalize(res);
        res = StringUtils.replaceChars(res, '_', ' ');
        return res;
    }
}
