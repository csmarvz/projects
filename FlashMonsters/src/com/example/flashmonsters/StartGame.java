/*
 * Copyright (C) 2013 FlashMonsters Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package com.example.flashmonsters;

import java.util.Date;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.flashmonsters.model.MonsterGenerator;
import com.example.flashmonsters.view.BoardViewGroup;

/**
 * FlashMonsters
 * 
 * The goal of the game is to kill the monsters by touching them. The faster you
 * are the higher is your score.
 * 
 * @author sengh
 * 
 */
public class StartGame extends Activity {

	
	public static int score = 0;
	public final static int NB_MONSTERS = 20;
	public static int nbMonstersLeft = NB_MONSTERS;
	public static long startTime;
	public static long endTime;

	TextView contentView;

	private BoardViewGroup board;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		board = new BoardViewGroup(this);
		board.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
		board.setBackgroundColor(Color.BLACK);
		setContentView(board);
		waitTouchToStartGame();
	}
	
	private void waitTouchToStartGame(){
		TextView start = new TextView(this);
		start.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
		start.setTextColor(Color.YELLOW);
		start.setText("TOUCH TO START");
		Typeface font = Typeface.createFromAsset(getAssets(), "pixel.ttf");  
		start.setTypeface(font);  
		start.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				board.removeAllViews();
				startGame();
				return false;
			}
		});
		board.addView(start);
		setContentView(board);
	}

	private void startGame() {
		nbMonstersLeft = NB_MONSTERS;
		startTime = new Date().getTime();
		board.addView(MonsterGenerator.generateMonster(this, board));
		setContentView(board);
	}

	public void monsterKilled() {
		board.removeViewAt(0);
		nbMonstersLeft--;
		if (nbMonstersLeft > 0) {
			board.addView(MonsterGenerator.generateMonster(this, board));
			setContentView(board);
		} else {
			endGame();
		}
	}

	private void endGame() {
		endTime = new Date().getTime();
		long time = endTime-startTime;
		score = (int) (10000000/time);
		TextView end = new TextView(this);
		end.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
		end.setTextColor(Color.YELLOW);
		end.setText("FINAL SCORE : " + score + "\nTOUCH TO REPLAY");
		Typeface font = Typeface.createFromAsset(getAssets(), "pixel.ttf");  
		end.setTypeface(font); 
		end.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				board.removeAllViews();
				startGame();
				return false;
			}
		});
		board.addView(end);
		setContentView(board);
	}

}
