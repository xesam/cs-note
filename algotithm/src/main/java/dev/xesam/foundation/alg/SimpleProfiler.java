package dev.xesam.foundation.alg;

/**
 * Created by xe on 16-3-31.
 */
public class SimpleProfiler {
    public static void profile(SortProfile profiler) {
        long startTime = System.nanoTime();
        profiler.run();
        long endTime = System.nanoTime();
        System.out.println(profiler.getName() + ":" + (endTime - startTime));
    }
}
