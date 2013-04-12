package com.example.flashmonsters.model;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.TextView;

import com.example.flashmonsters.view.BoardViewGroup;

public class MonsterView extends TextView {

	BoardViewGroup b;

	private MonsterView(Context context) {
		super(context);
	}

	public MonsterView(Context context, BoardViewGroup b) {
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
