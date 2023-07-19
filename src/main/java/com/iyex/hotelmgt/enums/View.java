package com.iyex.hotelmgt.enums;

import com.iyex.hotelmgt.annotation.Display;

public enum View {
    @Display(name = "city view")
    CITY,
    @Display(name = "village view")
    VILLAGE,
    @Display(name = "lake view")
    LAKE,
    @Display(name = "has no view")
    NO
}
