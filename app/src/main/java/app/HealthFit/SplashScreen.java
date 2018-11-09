package app.HealthFit;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
public class SplashScreen extends Activity  {
    private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, TabHostADMIN.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_to_center, R.anim.center_to_right);
            }
        }, SPLASH_TIME_OUT);


    }

}