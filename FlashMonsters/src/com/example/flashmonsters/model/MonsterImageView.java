package com.example.flashmonsters.model;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.example.flashmonsters.view.BoardViewGroup;

public class MonsterImageView extends ImageView {
	BoardViewGroup b;
	
	private MonsterImageView(Context context) {
		super(context);
	}
	
	public MonsterImageView(Context context, BoardViewGroup b) {
		super(context);
		this.b = b;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		b.monsterKilled(this);
		return super.onTouchEvent(event);
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		b.setMonsterSize(getWidth(), getHeight());
	}

}
