package de.fischkralle.imagerotated;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private Screen screen;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        screen = new Screen( this );
        setContentView( screen );
    }
}
