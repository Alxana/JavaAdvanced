package com.exadel.lombok.animals;

import lombok.*;


@Getter
//@AllArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(exclude = "weight")
public class Animal {

    private String name;
    private @Setter double weight;

}
