package com.example.hellofarmer;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SlideAdapter(Context context) {
        this.context=context;
    }
    public int[] slide_images={
            R.drawable.farmrent,
            R.drawable.buy,
            R.drawable.sell,
            R.drawable.community



    };
    public String[] slide_text=
            {
                    "Rent Farm Machinery",
                    "Buy fresh organic product",
                    "Sell your crops",
                    "Join a community"
            };

    @Override
    public int getCount() {
        return slide_text.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView=(ImageView)view.findViewById(R.id.slide_image);
        TextView slideTextView=(TextView)view.findViewById(R.id.slide_text);
        slideImageView.setImageResource(slide_images[position]);
        slideTextView.setText(slide_text[position]);
        container.addView(view);
        return view;


    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
