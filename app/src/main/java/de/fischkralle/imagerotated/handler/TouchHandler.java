package de.fischkralle.imagerotated.handler;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class TouchHandler implements OnTouchListener {

    public boolean onTouch ( View v , MotionEvent e ) {
                    /*******************/
                    /* 0 = touch down  */
                    /* 1 = touch up    */
                    /* 2 = long touch  */
                    /*******************/
        if( e.getAction( ) == 0 ) {

        }
        return true;
    }
}