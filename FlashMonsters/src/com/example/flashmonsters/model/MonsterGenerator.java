package com.example.flashmonsters.model;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

import com.example.flashmonsters.R;
import com.example.flashmonsters.view.BoardViewGroup;

public class MonsterGenerator {

	public static View generateMonster(Context c, BoardViewGroup b) {
//		MonsterView m = new MonsterView(c, b);
//		m.setLayoutParams(new LinearLayout.LayoutParams(
//				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//		m.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
//		m.setTextColor(Color.RED);
//		m.setText("(>O,O<)");
		//m.setText(".-c===3");
		BitmapDrawable image = new BitmapDrawable(c.getResources(), BitmapFactory.decodeResource(c.getResources(), R.drawable.sengseng));
		
		MonsterImageView m = new MonsterImageView(c, b);
		//m.setImageResource(R.drawable.sengseng);
		
		image.setAntiAlias(false);
		image.setDither(false);
		image.setFilterBitmap(false);
		m.setImageDrawable(image);
		m.setAdjustViewBounds(true);
		int sp = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 
			    100 , 
			    c.getResources().getDisplayMetrics());
		m.setScaleType(ScaleType.FIT_XY);
		m.setLayoutParams(new RelativeLayout.LayoutParams(sp,sp));
		
		//m.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT));
		
		
		return m;
	}

}
