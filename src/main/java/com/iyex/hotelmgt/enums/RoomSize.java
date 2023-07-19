package com.iyex.hotelmgt.enums;

import com.iyex.hotelmgt.annotation.Display;

public enum RoomSize {
    @Display(name = "below 15 meter square")
    SMALL,
    @Display(name = "between 15 and 30 meter square")
    MEDIUM,
    @Display(name = "between 30 and 50 meter square")
    LARGE,
    @Display(name = "above 50 meter square")
    EXTRA_LARGE
}
