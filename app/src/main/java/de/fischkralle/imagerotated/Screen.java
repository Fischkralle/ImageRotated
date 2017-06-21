package de.fischkralle.imagerotated;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import de.fischkralle.imagerotated.handler.TouchHandler;
import de.fischkralle.imagerotated.manager.GfxManager;

public class Screen extends SurfaceView implements SurfaceHolder.Callback {

    public static int width;
    public static int height;

    private GfxManager   gfx;
    private TouchHandler touch;

    private MainThread mainThread;

    private Rotated rotated;

    public Screen( Context context ) {
        super( context );

        mainThread = new MainThread( this , super.getHolder( ) );
    }

    @Override
    public void onDraw( Canvas canvas ) {
        rotated.draw( canvas );
    }

    public void init( ) {
        this.width  = getWidth( );
        this.height = getHeight( );

        gfx     = new GfxManager( getContext( ).getAssets( ) );
        touch   = new TouchHandler( );

        rotated = new Rotated( );
        rotated.setGfxManager( gfx );
        rotated.createBounding( );

        setOnTouchListener( touch );

        mainThread.isRunning = true;
        mainThread.setGfxManager( gfx );
        mainThread.setTouchHandler( touch );
        mainThread.setRotated( rotated );
        mainThread.start( );
    }

    @Override public void surfaceChanged( SurfaceHolder surfaceHolder , int i1 , int i2 , int i3 ) { ; }
    @Override public void surfaceCreated( SurfaceHolder surfaceHolder ) { init( ); }
    @Override public void surfaceDestroyed( SurfaceHolder surfaceHolder ) { MainThread.isRunning = false; }
    @Override public boolean onTouchEvent( MotionEvent motionEvent ) {
        return true;
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