package com.example.grid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleTextViewActivity extends Activity {
	
	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_textview);
		
		String desc = "Íò¼ýÆë·¢";
		Intent i = getIntent();
		
		int imageId = i.getExtras().getInt("imageId");
		i.putExtra("imageId", imageId);
		i.putExtra("desc", desc);
		
		
		textView = (TextView) findViewById(R.id.singleTextView);
		textView.setText(desc);
		
	}
	
	
}
