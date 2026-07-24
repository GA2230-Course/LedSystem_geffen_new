package ledsystem;

import ledsystem.ledssim.LedStrip;

public interface Animation {
    void apply(LedStrip strip);

    default boolean isFinished() {
        return false;
    }

    default void reset() {}
}
