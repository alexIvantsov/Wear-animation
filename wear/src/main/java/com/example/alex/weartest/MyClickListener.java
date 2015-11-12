package com.example.alex.weartest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;

/**
 * Created by alex on 11/7/15.
 */
public class MyClickListener implements WearableListView.ClickListener {

    private Context context;

    public MyClickListener(Context context){
        this.context = context;
    }

    @Override
    public void onClick(WearableListView.ViewHolder v) {
        Integer tag = (Integer) v.itemView.getTag();
        Bundle b = new Bundle();
        b.putInt("animation", tag);
        Intent intent = new Intent(context, AnimationActivity.class);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    @Override
    public void onTopEmptyRegionClick() {

    }
}
