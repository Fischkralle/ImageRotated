package de.fischkralle.imagerotated;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import de.fischkralle.imagerotated.handler.TouchHandler;
import de.fischkralle.imagerotated.time.Counter;
import de.fischkralle.imagerotated.manager.GfxManager;

public class MainThread extends Thread {

    public static boolean isRunning = false;

    private Canvas canvas;

    private Screen        screen;
    private SurfaceHolder surfaceHolder;

    private GfxManager   gfx;
    private TouchHandler touch;

    private Rotated rotated;

    public MainThread(Screen screen, SurfaceHolder surfaceHolder ) {
        this.screen        = screen;
        this.surfaceHolder = surfaceHolder;
        this.surfaceHolder.addCallback( screen );
    }

    @Override
    public void run( ) {
        while ( isRunning ) {
            Counter.tickFrame( );
            tryToDraw( );
        }
    }

    private void tryToDraw( ) {
        canvas = null;
        try {
            canvas = surfaceHolder.lockCanvas( );
            if ( canvas != null ) { screen.onDraw( canvas ); }
        } finally {
            if ( canvas != null ) { surfaceHolder.unlockCanvasAndPost( canvas ); }
        }
    }

  // SETTER
    public void setGfxManager( GfxManager gfx ) { this.gfx = gfx; }
    public void setTouchHandler( TouchHandler touch ) { this.touch = touch; }
    public void setRotated( Rotated rotated ) { this.rotated = rotated; }
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