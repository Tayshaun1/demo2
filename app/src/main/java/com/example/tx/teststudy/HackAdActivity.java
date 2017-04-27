package com.example.tx.teststudy;

import android.Manifest;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.security.Permission;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class HackAdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack_ad);
        Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.PACKAGE_USAGE_STATS) != PackageManager
                .PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.PACKAGE_USAGE_STATS},10);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        switch (requestCode){
            case 10:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(HackAdActivity.this,"权限已开启",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public void openService(View view) {
        startService(new Intent(HackAdActivity.this, MonitorService.class));
        Toast.makeText(this, "服务已开启！", Toast.LENGTH_SHORT).show();
    }

    public void closeService(View view) {
        stopService(new Intent(HackAdActivity.this, MonitorService.class));
        Toast.makeText(this, "服务已关闭！", Toast.LENGTH_SHORT).show();
    }


}
