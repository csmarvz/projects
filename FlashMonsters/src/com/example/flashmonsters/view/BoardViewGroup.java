package com.example.flashmonsters.view;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.flashmonsters.StartGame;

public class BoardViewGroup extends RelativeLayout {

	int monsterWidth = 0;
	int monsterHeight = 0;
	RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
			RelativeLayout.LayoutParams.WRAP_CONTENT,
			RelativeLayout.LayoutParams.WRAP_CONTENT);

	public BoardViewGroup(Context context) {
		super(context);
	}

	@Override
	public void addView(View v) {
		super.addView(v);
		((RelativeLayout.LayoutParams)v.getLayoutParams()).leftMargin = getRandomX(this, v);
		((RelativeLayout.LayoutParams)v.getLayoutParams()).topMargin = getRandomY(this, v);

//		params.leftMargin = getRandomX(this, v);
//		params.topMargin = getRandomY(this, v);
		//v.setLayoutParams(params);
	}

	public void monsterKilled(View v) {
		// removeView(v);
		((StartGame) getContext()).monsterKilled();
	}

	public void setMonsterSize(int w, int h) {
		monsterHeight = h;
		monsterWidth = w;
		invalidate();
	}

	private int getRandomY(View b, View m) {
		System.out
				.println("\nheights " + b.getHeight() + " / " + m.getHeight());
		int yMax = b.getHeight() - monsterHeight;
		int y = (int) (Math.random() * yMax + 1);
		// System.out.println("\nmeasuredHeight="+b.getMeasuredHeight()+" y:"+y);
		return y;
	}

	private int getRandomX(View b, View m) {
		System.out.println("widths " + b.getWidth() + " / " + m.getWidth());
		int xMax = b.getWidth() - monsterWidth;
		int x = (int) (Math.random() * xMax + 1);
		// System.out.println("x:"+x);
		return x;
	}

	public void resetBGColor() {
		setBackgroundColor(Color.BLACK);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// setBackgroundColor(Color.DKGRAY);
		// invalidate();
		//
		// Thread t1 = new Thread() {
		// public void run() {
		// try {
		// sleep(200);
		// ((Activity) getContext()).runOnUiThread(new Runnable() {
		//
		// @Override
		// public void run() {
		// resetBGColor();
		// }
		// });
		//
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// };
		// t1.run();
		return super.onTouchEvent(event);

	}

}
