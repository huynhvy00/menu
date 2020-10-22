package com.example.context;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> array123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        lv =(ListView) findViewById(R.id.listview);

        array123 = new ArrayList<>();

        array123.add("Ngo Lam Doon");
        array123.add("Cam Cam");
        array123.add("La La");
        array123.add("Chou Chou");
        array123.add("Se Se");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_multiple_choice,array123);
        lv.setAdapter(adapter);
lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String items = (String) parent.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, array123.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {

               Toast.makeText(MainActivity.this,"Long click: "+i,Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        return super.onCreateOptionsMenu(menu);
    }
}