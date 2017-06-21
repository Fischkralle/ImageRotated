package de.fischkralle.imagerotated.time;

public class Counter {

    public  static float timeSinceLastFrame = 0.0f;
    private static long  timeLastFrame = System.currentTimeMillis( );;

    public Counter( ) { ; }

    public static void tickFrame( ) {
        long timeThisFrame = System.currentTimeMillis( );
        timeSinceLastFrame = ( float )( timeThisFrame - timeLastFrame ) / 1000.0f;
        timeLastFrame      = timeThisFrame;
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