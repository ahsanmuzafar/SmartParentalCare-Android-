package com.example.smaretparentalcare;
 
import com.example.smaretparentalcare.ListData;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class DetailBaseAdapter extends BaseAdapter {
        
        ArrayList myList = new ArrayList();
        LayoutInflater inflater;
        Context context;
        
        
        public DetailBaseAdapter(Context context, ArrayList myList) {
                this.myList = myList;
                this.context = context;
                inflater = LayoutInflater.from(this.context);        // only context can also be used
        }
 
        @Override
        public int getCount() {
                return myList.size();
        }
 
        @Override
        public ListData getItem(int position) {
                return (ListData) myList.get(position);
        }
 
        @Override
        public long getItemId(int position) {
                return 0;
        }
 
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                MyViewHolder mViewHolder;
                
                if(convertView == null) {
                        convertView = inflater.inflate(R.layout.layout_stats, null);
                        mViewHolder = new MyViewHolder();
                        convertView.setTag(mViewHolder);
                } else {
                        mViewHolder = (MyViewHolder) convertView.getTag();
                }
                
                mViewHolder.name = detail(convertView, R.id.name_textView, ((ListData) myList.get(position)).getChildName());
                mViewHolder.location  = detail(convertView, R.id.location_textView,  ((ListData) myList.get(position)).getChildLocatio());
                mViewHolder.stats = detail(convertView, R.id.stats_textView, ((ListData) myList.get(position)).getStats());
                mViewHolder.imgv  = detail(convertView, R.id.imageView1,  ((ListData) myList.get(position)).getImgResId());
                
                return convertView;
        }
        
        // or you can try better way
        private TextView detail(View v, int resId, String text) {
                TextView tv = (TextView) v.findViewById(resId);
                tv.setText(text);
                return tv;
        }
        
        private ImageView detail(View v, int resId, int icon) {
                ImageView iv = (ImageView) v.findViewById(resId);
                iv.setImageResource(icon); // 
                
                return iv;
        }
        
        private class MyViewHolder {
                public ImageView imgv;
				public TextView stats;
				public TextView location;
				public TextView name;
				 
        }
 
}