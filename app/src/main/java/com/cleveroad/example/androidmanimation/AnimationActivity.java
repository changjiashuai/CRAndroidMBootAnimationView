package com.cleveroad.example.androidmanimation;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cleveroad.androidmanimation.LoadingAnimationView;

/**
 * Example of using animation as view in layout.
 */
public class AnimationActivity extends AppCompatActivity {

	private LoadingAnimationView animation;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
		animation = (LoadingAnimationView) findViewById(R.id.animation);
		animation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!animation.isRunning()) {
					animation.startAnimation();
				} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
					animation.pauseAnimation();
				} else {
                    animation.stopAnimation();
                }
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		animation.startAnimation();
	}

	@Override
	protected void onPause() {
		animation.pauseAnimation();
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		animation.stopAnimation();
		super.onDestroy();
	}
}
