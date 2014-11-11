package com.example.design;

import android.R.color;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class MButton extends Button{

	Button root;
	MBackground background ;
	
	String mycolor;
	
	int colorNormal, colorPressed, textColor;
	
	public MButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		background= new MBackground(color.darker_gray);
		this.setBackground(background);
	}



	public MButton(View v){
		super(v.getContext());
		root = (Button) v;
		
		setColor("#999999");
		
	
		root.setOnTouchListener(new Button.OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				final float scale = 1.3f;
				
				int actoin = event.getAction();

				if( actoin == MotionEvent.ACTION_DOWN){
					
					
					root.setBackground(new MBackground(colorPressed));
				}

				if( actoin== MotionEvent.ACTION_UP){
				
					root.setBackground(new MBackground(colorNormal));
				}
				
				return false;
			}
		});
		root.setBackground(background);
		
	}

	
	private int getNegativeColor(int color) { 
		int alpha = ((color >> 24) & 0xFF); 
		int negRed = ~((color >> 16) & 0xFF); 
		int negGreen = ~((color >> 8) & 0xFF); 
		int negBlue = ~(color & 0xFF); 
		return (alpha << 24) | (negRed << 16) | (negGreen << 8) | negBlue; 
		
	}
	
	private int darkenColor(int color){
		
		float[] hsv = new float[3];
		Color.colorToHSV(color, hsv);
		hsv[2] *= 0.8f; // value component
		color = Color.HSVToColor(hsv);
		
		return color;
	}
	
	public void setColor(String hexcolor){
		
		mycolor = hexcolor;
		colorNormal = Color.parseColor(mycolor);
		colorPressed = darkenColor(colorNormal);
		textColor = getNegativeColor(colorNormal);
		
		background= new MBackground(colorNormal);
		//background.setPressed(true);
		
		root.setBackground(background);
		root.setTextColor(textColor);
		
		root.setTypeface(null, Typeface.BOLD);
	}
	
}
