package com.example.grid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SingleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_image);
		
		Intent i = getIntent();
		
		int position = i.getExtras().getInt("id");
		ImageAdapter adapter = new ImageAdapter(this);
		
		ImageView imageView = (ImageView) findViewById(R.id.singleImage);
		System.out.println("imageView -------> " + imageView);
		imageView.setImageResource(adapter.getThumbIds()[position]);
	}
}
