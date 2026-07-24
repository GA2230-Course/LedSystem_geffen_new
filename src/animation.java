package ledsystem;

import ledsystem.MyLedStrip;

interface Animation {
    void apply(MyLedStrip strip);

    default boolean isFinished() {
        return false;
    }
}
