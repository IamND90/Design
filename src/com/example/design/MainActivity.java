package com.example.design;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	static Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		
		Button b = (Button) findViewById(R.id.button3);
		b.setBackground(new MBackground("#ff00ff"));
		
		
		final MButton m = new MButton(findViewById(R.id.button4));
		
		
		context = this;
	}
	
	
	static void setToast( String g){
		
		Toast.makeText(context, g, Toast.LENGTH_SHORT).show();
	}
	
}

