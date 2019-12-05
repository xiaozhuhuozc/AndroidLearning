package com.hopemind.learn.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.project.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_test);
        ListView list01 = findViewById(R.id.list01);
        String [] arr1 = {"马东","李诞","薛兆丰"};
        ArrayAdapter<String> adapter01 = new ArrayAdapter<String>(this,R.layout.array_item,arr1);
        list01.setAdapter(adapter01);



        ListView list02 = findViewById(R.id.list02);
        List< Map<String,Object> > listitems= new ArrayList<>();
        String[] des ={"主持人","脱口秀","经济学者"};
        int[] images = new int[]{R.drawable.ic_airport_shuttle,R.drawable.ic_pool_black,R.drawable.ic_spa_black_24dp};

        for(int i=0;i<arr1.length;i++){
         Map<String,Object> listitem = new HashMap<>();
         listitem.put("header",images[i]);
         listitem.put("name",arr1[i]);
         listitem.put("des",des[i]);
            listitems.add(listitem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitems,R.layout.simple_item,new String[]{"header","name","des"}
        ,new int[]{R.id.header,R.id.name,R.id.des});
        list02.setAdapter(simpleAdapter);
    }
}
