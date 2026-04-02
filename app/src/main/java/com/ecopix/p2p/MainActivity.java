package com.ecopix.p2p;

import android.os.Bundle;
import android.net.wifi.p2p.WifiP2pManager;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    WifiP2pManager manager;
    WifiP2pManager.Channel channel;
    ArrayList<String> messages = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.messageListView);
        EditText input = findViewById(R.id.messageInput);
        Button send = findViewById(R.id.sendButton);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, messages);
        listView.setAdapter(adapter);

        manager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        channel = manager.initialize(this, getMainLooper(), null);
        manager.discoverPeers(channel, null);

        send.setOnClickListener(v -> {
            String msg = input.getText().toString();
            if(!msg.isEmpty()){
                messages.add("P2P Siqnalı: " + msg);
                adapter.notifyDataSetChanged();
                input.setText("");
            }
        });
    }
}
