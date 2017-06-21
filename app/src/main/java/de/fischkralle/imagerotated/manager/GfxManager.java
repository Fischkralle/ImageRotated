package de.fischkralle.imagerotated.manager;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

import de.fischkralle.imagerotated.Screen;

public class GfxManager {

    public static float scaleWidth;
    public static float scaleHeight;

    private AssetManager assetManager;

    public Bitmap background;
    public Bitmap inRect;
    public Bitmap outRect;

    public GfxManager( AssetManager assetManager ) {
        this.assetManager = assetManager;

        this.scaleWidth  = Screen.width / 1920.0f;
        this.scaleHeight = Screen.height / 1080.0f;

        background = loadImage("background.png", Screen.width , Screen.height );
        outRect    = loadImage("outrect.png", ( int )( 112.0f * scaleWidth ) , ( int )( 112.0f * scaleHeight ) );
        inRect     = loadImage("inrect.png", ( int )( 48.0f * scaleWidth ) , ( int )( 48.0f * scaleHeight ) );
    }

    private Bitmap loadImage( String name , int width , int height ) {
        try {
            Bitmap bitmap = BitmapFactory.decodeStream( assetManager.open( name , AssetManager.ACCESS_BUFFER ) );
            return Bitmap.createScaledBitmap( bitmap , width , height , true );
        } catch ( IOException e ) {
            e.printStackTrace( );
            return null;
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