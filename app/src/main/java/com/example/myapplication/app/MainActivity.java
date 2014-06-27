package com.example.myapplication.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private Button btnTabActivity;
    private Button btnLinearLayout;
    private Button btnActionBar;
    private Button btnMyWall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTabActivity = (Button) findViewById(R.id.btnTab);
        btnLinearLayout = (Button) findViewById(R.id.btnLinearLayout);
        btnActionBar = (Button)findViewById(R.id.btnActionBar);
        btnMyWall = (Button) findViewById(R.id.btnMyWall);
        btnTabActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iTab = new Intent(MainActivity.this, TabActivity.class);
                startActivity(iTab);
            }
        });
        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iTab = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(iTab);
            }
        });
        btnActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iActionBar = new Intent(MainActivity.this, ActionBar.class);
                startActivity(iActionBar);
            }
        });
        btnMyWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iWall = new Intent(MainActivity.this, MyWall.class);
                startActivity(iWall);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
