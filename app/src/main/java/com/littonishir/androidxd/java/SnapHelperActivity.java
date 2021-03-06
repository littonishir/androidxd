package com.littonishir.androidxd.java;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;

import com.littonishir.androidxd.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SnapHelperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap_helper);



        RecyclerView mRecyclerView1 = findViewById(R.id.rv1);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        
        SnapHelperAdapter mSnapHelperAdapter1 = new SnapHelperAdapter(this);
        /**
         * PagerSnapHelper
         */
        PagerSnapHelper mPagerSnapHelper = new PagerSnapHelper();
        mPagerSnapHelper.attachToRecyclerView(mRecyclerView1);
        mRecyclerView1.setAdapter(mSnapHelperAdapter1);

        RecyclerView mRecyclerView2 = findViewById(R.id.rv2);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        
        SnapHelperAdapter mSnapHelperAdapter2 = new SnapHelperAdapter(this);
        /**
         * LinearSnapHelper
         */
        LinearSnapHelper mLinearSnapHelper = new LinearSnapHelper();
        mLinearSnapHelper.attachToRecyclerView(mRecyclerView2);
        mRecyclerView2.setAdapter(mSnapHelperAdapter2);
    }
}
