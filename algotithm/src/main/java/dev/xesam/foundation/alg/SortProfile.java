package dev.xesam.foundation.alg;

/**
 * Created by xe on 16-3-31.
 */
public abstract class SortProfile {
    protected String getName() {
        return getClass().getSimpleName();
    }

    public abstract void run();
}
