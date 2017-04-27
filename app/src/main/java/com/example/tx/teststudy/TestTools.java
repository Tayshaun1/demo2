package com.example.tx.teststudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TestTools extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionMenuView menu_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tools);
        initView();
    }

    private void initView() {
        toolbar =(Toolbar)findViewById(R.id.toolbar);
        menu_view =(ActionMenuView)findViewById(R.id.menu_view);

        toolbar.inflateMenu(R.menu.tool);
        getMenuInflater().inflate(R.menu.tool,menu_view.getMenu());
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item01:
                        Toast.makeText(getApplicationContext(),"提示",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item02:
                        Toast.makeText(getApplicationContext(),"菜单",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item03:
                        Toast.makeText(getApplicationContext(),"购物",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        menu_view.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item01:
                        Toast.makeText(getApplicationContext(),"提示1",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item02:
                        Toast.makeText(getApplicationContext(),"菜单2",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item03:
                        Toast.makeText(getApplicationContext(),"购物3",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"导航栏按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
