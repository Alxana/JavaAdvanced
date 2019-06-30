package com.exadel.lombok.food;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true)
public class KittyCat {

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private @NonNull String name;

    private @NonNull double weight;

    @ToString.Exclude
    private int calories;
}
