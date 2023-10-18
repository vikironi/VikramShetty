package activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.vikramshetty.R;
import com.squareup.picasso.Picasso;

public class SplashActivity extends AppCompatActivity {
    private final static int SPLASH_SCREEN_TIMEOUT = 4000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_activity);
        getWidget();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =  new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIMEOUT);
    }

    private void getWidget() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        Glide.with(this)
                .load(getString(R.string.mySplashUrl))
                .placeholder(R.drawable.placeholder)
                .dontAnimate()
                .into(imageView);

        Animation animation = new AlphaAnimation(1,0);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setStartOffset(500);
        animation.setDuration(1500);
    }
}
