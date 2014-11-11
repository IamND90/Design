package com.example.design;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class MBackground extends Drawable{
	private Paint mPaint;
	private int colorS,colorE, height;
	
	
	public MBackground(int color){
		mPaint = new Paint();
		colorS= color;
		colorE= darkenColor(colorS);
	
	}
	
	public MBackground(String color){
		mPaint = new Paint();
		int c = Color.parseColor(color);
		
		colorS= c;
		colorE= darkenColor(colorS);
		height=0;
		
	}
	
	
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		Rect b = getBounds();
        int h = b.height();
        height = h;

        mPaint.setShader(new LinearGradient(0, 0, 0,height, colorS, colorE, Shader.TileMode.MIRROR));
        
		canvas.drawPaint(mPaint);
		
	}

	@Override
	public int getOpacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlpha(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColorFilter(ColorFilter arg0) {
		// TODO Auto-generated method stub
		
	}

	private int darkenColor(int color){
		
		float[] hsv = new float[3];
		Color.colorToHSV(color, hsv);
		hsv[2] *= 0.6f; // value component
		color = Color.HSVToColor(hsv);
		
		return color;
	}

	public static int darker (int color, float factor) {
	    int a = Color.alpha( color );
	    int r = Color.red( color );
	    int g = Color.green( color );
	    int b = Color.blue( color );

	    return Color.argb( a,
	            Math.max( (int)(r * factor), 0 ),
	            Math.max( (int)(g * factor), 0 ),
	            Math.max( (int)(b * factor), 0 ) );
	}
	
}
	
