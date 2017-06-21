package de.fischkralle.imagerotated.time;

public class Sleeper {

    public static void sleep( long sleepTimeInMillis ) {
        try {
            Thread.sleep( sleepTimeInMillis );
        } catch ( InterruptedException e ) {
            e.printStackTrace( );
        }
    }
}
/*
 *
 *
 *
 *
 *
 *
 *
 */