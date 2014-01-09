package com.example.grid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	private GridView gridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gridView = (GridView) findViewById(R.id.grid);
		gridView.setAdapter(new ImageAdapter(this));
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(MainActivity.this, "hi " + position, Toast.LENGTH_SHORT).show();
				Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.back_scale);
//    			animation.setAnimationListener(new Animation.AnimationListener() {
//    				@Override
//    				public void onAnimationStart(Animation arg0) {
//    					// TODO Auto-generated method stub
//    				}
//    				
//    				@Override
//    				public void onAnimationRepeat(Animation arg0) {
//    					// TODO Auto-generated method stub
//    				}
//    				
//    				@Override
//    				public void onAnimationEnd(Animation arg0) {
//    					if(bool){
//    						imageView.setImageResource(R.drawable.b);
//    						bool = false;
//    					} else {
//    						imageView.setImageResource(R.drawable.c);
//    						bool = true;
//    					}
//    					imageView.startAnimation(AnimationUtils.loadAnimation(ImageActivity.this, R.anim.front_scale));
//    				}
//    			});
    			v.startAnimation(animation);
//    			v.setVisibility(View.INVISIBLE);
//    			v.setEnabled(false);
    			v.setId(View.generateViewId());
    			Intent i = new Intent(MainActivity.this, SingleTextViewActivity.class);
    			i.putExtra("imageId", v.getId());
    			i.putExtra("position", position);
    			startActivity(i);
			}
		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Intent intent = getIntent();
		int imageId = intent.getIntExtra("imageId", 0);
		String desc = intent.getStringExtra("desc");
		
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
//		layoutParams.topMargin = ivId;
//		layoutParams.bottomMargin = ivId;
//		layoutParams.leftMargin = ivId;
//		layoutParams.rightMargin = ivId;
		layoutParams.setMargins(1, 1, 1, 1);
		
		layoutParams.addRule(RelativeLayout.ALIGN_TOP, imageId);
		layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, imageId);
		layoutParams.addRule(RelativeLayout.ALIGN_LEFT, imageId);
		layoutParams.addRule(RelativeLayout.ALIGN_RIGHT, imageId);
		
		TextView tv = new TextView(this);
		tv.setLayoutParams(layoutParams);
		tv.setGravity(Gravity.CENTER);
		tv.setBackgroundColor(Color.RED);
		tv.setText(desc);
		
		//not support
//		gridView.addView(tv, 1);
	}
	
	private void constructTextView(final View iv){
		int ivId = iv.getId();
		System.out.println("view.getId --------> " + ivId);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
//		layoutParams.topMargin = ivId;
//		layoutParams.bottomMargin = ivId;
//		layoutParams.leftMargin = ivId;
//		layoutParams.rightMargin = ivId;
		layoutParams.setMargins(1, 1, 1, 1);
		
		layoutParams.addRule(RelativeLayout.ALIGN_TOP, ivId);
		layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, ivId);
		layoutParams.addRule(RelativeLayout.ALIGN_LEFT, ivId);
		layoutParams.addRule(RelativeLayout.ALIGN_RIGHT, ivId);
		
		TextView tv = new TextView(this);
		tv.setLayoutParams(layoutParams);
		tv.setGravity(Gravity.CENTER);
		tv.setBackgroundColor(Color.RED);
		tv.setText("Íò¼ýÆë·¢£¡");
		
//		gridView.addView(tv);
		
	}

}
