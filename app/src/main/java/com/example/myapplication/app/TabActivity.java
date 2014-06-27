package com.example.myapplication.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.media.Rating;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class TabActivity extends ActionBarActivity {

    private TextView tvScore;
    private RatingBar rbScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        this.getActionBar().setDisplayHomeAsUpEnabled(true);
        //GetAndBindControl();
    }
    /*
        获取控件并绑定事件
     */
    private void GetAndBindControl()
    {/*
        tvScore = (TextView)findViewById(R.id.tvScore);
        rbScore = (RatingBar)findViewById(R.id.rbScore);
        rbScore.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(),String.valueOf(v),Toast.LENGTH_SHORT).show();
            }
        });
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tab, menu);
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
    /*
    public class CollectionDemoActivity extends FragmentActivity{
        //DemoCollectionPagerAdapter
    }

    public class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter{
        public DemoCollectionPagerAdapter(FragmentManager fm){
            super(fm);
        }

    }

    public static class DemoObjectFragment extends Fragment{
        public static final String ARG_OBJECT = "object";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           View rootView = inflater.inflate(R.layout.fragment_collection_object)
        }
    }
    */
}
