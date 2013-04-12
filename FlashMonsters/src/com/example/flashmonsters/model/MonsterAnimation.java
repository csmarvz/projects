package com.example.flashmonsters.model;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class MonsterAnimation extends Animation {

	public MonsterAnimation() {
		Transformation t = new Transformation();
		t.setTransformationType(Transformation.TYPE_MATRIX);
		t.getMatrix().setRotate(180);
		applyTransformation(0, t);
	}

}
