package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {


    EditText etItems;
    Button bthSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItems = findViewById(R.id.etItems);
        bthSave = findViewById(R.id.bthSave);

        getSupportActionBar().setTitle("Edit Item");

        etItems.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));


        //when user is done editing, click on save button
        bthSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an intent which contain results
                Intent intent = new Intent();

                //pass the results of editing
                intent.putExtra(MainActivity.KEY_ITEM_TEXT,etItems.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION,getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                //set the result of intent
                setResult(RESULT_OK, intent);

                //finish activity and go back
                finish();
            }
        });
    }

}