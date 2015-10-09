package ru.bmstu.tp.home_assignment_1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Martin on 21.04.2015.
 */
public class SecondActivity extends ActionBarActivity {
    private ArrayList<String> data;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        this.generateData(1000);
        MyAdapter adapter = new MyAdapter(this.data);
        ListView listView = (ListView)findViewById(R.id.listtt);
        listView.setAdapter(adapter);
    }

    private void generateData(int size){
        this.data = new ArrayList<>(size);
        for (int i = 0; i<size; i++){
            String element = String.valueOf(i + 1);
            this.data.add(element);
        }
    }
}
