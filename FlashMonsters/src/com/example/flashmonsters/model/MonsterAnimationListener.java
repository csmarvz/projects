package com.example.flashmonsters.model;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class MonsterAnimationListener implements AnimationListener {

	View v;

	public MonsterAnimationListener(View v) {
		if (v == null)
			throw new NullPointerException("Parameter must be not null!");
		this.v = v;
	}

	@Override
	public void onAnimationEnd(Animation arg0) {
		notify();
	}

	@Override
	public void onAnimationRepeat(Animation arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation arg0) {
		// TODO Auto-generated method stub

	}

}
