package com.example.alex.weartest;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends Activity{

        private static String[] listItemsArr = {"Zoom", "Jumping", "Rotation", "Colors"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                WearableListView listView = (WearableListView)findViewById(R.id.wearable_list);
                listView.setAdapter(new MyAdapter(this, listItemsArr));
                listView.setClickListener(new MyClickListener(this));
                FrameLayout layout = (FrameLayout)findViewById(R.id.frame_layout);
                final View header = this.getLayoutInflater().inflate(R.layout.header, null);
                layout.addView(header, 0);
                listView.addOnScrollListener(new WearableListView.OnScrollListener() {
                        @Override
                        public void onScroll(int i) {
                        }

                        @Override
                        public void onAbsoluteScrollChange(int i) {
                                if (i > 0)
                                        header.setY(-i);
                        }

                        @Override
                        public void onScrollStateChanged(int i) {
                        }

                        @Override
                        public void onCentralPositionChanged(int i) {
                        }
                });
        }
}