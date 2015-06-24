package com.example.android.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView thumbPrint;
    private TextView result;
    private AnimationDrawable thumbAnimation;
    private String[] moodResult;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moodResult = new String[] {
                "Someone is cranky!",
                "You are my sunshine!",
                "No comments...",
                "You're stressed out!",
                "Happy camper :)",
                "Not your day :(",
                "Smile - it's good for you.",
                "In the clouds...",
                "Pensive!",
                "Sad!",
                "Excited!"

        };
        thumbPrint = (ImageView)findViewById(R.id.thumbPrint);
        thumbPrint.setBackgroundResource(R.drawable.thumb_animation);
        thumbAnimation = (AnimationDrawable)thumbPrint.getBackground();
        result = (TextView)findViewById(R.id.textResult);

        thumbPrint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
              //  Toast.makeText(getApplicationContext(),"lama",Toast.LENGTH_LONG).show();
                thumbAnimation.start();
                showResult();


                return false;
            }
        });

    }

    public void showResult(){
        mRunnable = new Runnable() {
            @Override
            public void run() {
             int rand = (int) (Math.random() * moodResult.length);
                result.setText(moodResult[rand]);
                thumbAnimation.stop();
            }
        };
        Handler mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 4000);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
