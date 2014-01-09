package com.example.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

	private Context context;
	public Integer[] thumbIds;
	public static final int VIEW_COUNT = 5;
	
	public Integer[] getThumbIds() {
		thumbIds = new Integer[VIEW_COUNT];
		for(int i = 0; i < thumbIds.length; i++){
			thumbIds[i] = R.drawable.a;
			if(i%2 == 0){
				thumbIds[i] = R.drawable.b;	
			}
		}
		return thumbIds;
	}

	public void setThumbIds(Integer[] thumbIds) {
		this.thumbIds = thumbIds;
	}

	public ImageAdapter(Context c) {
		this.context = c;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getItem(int paramInt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int paramInt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressLint("NewApi")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		thumbIds = getThumbIds();
		if(convertView == null){
			imageView = new ImageView(context);
			imageView.setId(View.generateViewId());
			imageView.setLayoutParams(new GridView.LayoutParams(85, 105));
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setPadding(3, 3, 3, 3);
			imageView.setBackgroundColor(Color.BLUE);
			imageView.setImageResource(thumbIds[position]);
		}else{
			imageView = (ImageView) convertView;
//			if(!imageView.isEnabled()){
//				return constructTextView(imageView);
//			}
		}
		return imageView;
	}

	private TextView constructTextView(View iv){
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
		
		TextView tv = new TextView(context);
		tv.setLayoutParams(layoutParams);
		tv.setGravity(Gravity.CENTER);
		tv.setBackgroundColor(Color.RED);
		tv.setText("Íò¼ýÆë·¢£¡");
		
		return tv;
	}
}
