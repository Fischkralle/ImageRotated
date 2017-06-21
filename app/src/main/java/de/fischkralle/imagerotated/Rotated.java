package de.fischkralle.imagerotated;

import android.graphics.Canvas;
import android.graphics.RectF;

import de.fischkralle.imagerotated.manager.GfxManager;
import de.fischkralle.imagerotated.time.Counter;

public class Rotated {

    private GfxManager gfx;

    private RectF outRectBounding;
    private RectF inrectBounding;

    private float degreesAtSecondOut = 180.0f;
    private float degreesAtSecondIn  = 180.0f;
    private float degreesLoadIn      = 0.0f;
    private float degreesLoadOut     = 0.0f;

    public Rotated( ) { ; }

    public void draw( Canvas canvas ) {
        canvas.drawBitmap( gfx.background , 0 , 0 , null );
        degreesLoadOut += degreesAtSecondOut * Counter.timeSinceLastFrame;
        if( degreesLoadOut >= 360 ) { degreesLoadOut -= 360; }
        rotatedImage( canvas , degreesLoadOut , outRectBounding.centerX( ) , outRectBounding.centerY( ) );
        canvas.drawBitmap( gfx.outRect , outRectBounding.left , outRectBounding.top , null );
        resetImage( canvas , degreesLoadOut , outRectBounding.centerX( ) , outRectBounding.centerY( ) );

        degreesLoadIn -= degreesAtSecondIn * Counter.timeSinceLastFrame;
        if( degreesLoadIn <= 0 ) { degreesLoadIn += 360; }
        rotatedImage( canvas , degreesLoadIn , inrectBounding.centerX( ) , inrectBounding.centerY( ) );
        canvas.drawBitmap( gfx.inRect , inrectBounding.left , inrectBounding.top , null );
        resetImage( canvas , degreesLoadIn , inrectBounding.centerX( ) , inrectBounding.centerY( ) );
    }

    private void rotatedImage( Canvas canvas , float degrees , float centerX , float centerY ) {
        canvas.rotate( degrees , centerX , centerY );
    }

    private void resetImage( Canvas canvas , float degrees , float centerX , float centerY ) {
        canvas.rotate( 360 - degrees , centerX , centerY );
    }

    public void createBounding( ){
        outRectBounding = new RectF( );
        outRectBounding.left   = 760.0f * GfxManager.scaleWidth;
        outRectBounding.top    = 150.0f * GfxManager.scaleHeight;
        outRectBounding.right  = ( 760.0f + 112.0f ) * GfxManager.scaleWidth;
        outRectBounding.bottom = ( 150.0f + 112.0f ) * GfxManager.scaleHeight;

        inrectBounding = new RectF( );
        inrectBounding.left   = 792.0f * GfxManager.scaleWidth;
        inrectBounding.top    = 182.0f * GfxManager.scaleHeight;
        inrectBounding.right  = ( 792.0f + 48.0f ) * GfxManager.scaleWidth;
        inrectBounding.bottom = ( 182.0f + 48.0f ) * GfxManager.scaleHeight;
    }

  // SETTER
    public void setGfxManager( GfxManager gfx ) { this.gfx = gfx; }
}