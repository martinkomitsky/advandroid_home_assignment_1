package ru.bmstu.tp.home_assignment_1;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.ref.WeakReference;

public class SplashScreenActivity extends ActionBarActivity {
    static boolean backPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        backPressed = false;

        Animation animation = new Animation(this);
        ThreadSleep a = new ThreadSleep(animation);
        a.start();
    }

    @Override
    protected void onStop() {
        backPressed = true;
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
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

    private static class ThreadSleep extends Thread {
        @Override
        public void run() {
            try {
                sleep(2000);
                Log.d("flag", Boolean.toString(backPressed));
                if (!backPressed) {
                    test.sendMessage(new Message());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private ThreadSleep(Animation test) {
            super();
            this.test = test;
        }

        private Animation test;
    }

    private static class Animation extends Handler {
        public Animation(SplashScreenActivity listener) {
            this.link = new WeakReference<>(listener);
        }

        @Override
        public void handleMessage(Message msg) {
            SplashScreenActivity hardLink = this.link.get();
            if (hardLink != null) {
                Intent startSecond = new Intent(hardLink, SecondActivity.class);
                hardLink.startActivity(startSecond);
                hardLink.finish();
            }
        }

        private WeakReference<SplashScreenActivity> link;
    }
}