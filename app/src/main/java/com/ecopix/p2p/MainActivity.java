package com.ecopix.p2p;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("EcoPix P2P Anten Hazırdır!\nİnternetsiz əlaqə aktivdir.");
        tv.setTextSize(24);
        tv.setTextColor(Color.GREEN);
        tv.setGravity(Gravity.CENTER);
        setContentView(tv);
    }
}
