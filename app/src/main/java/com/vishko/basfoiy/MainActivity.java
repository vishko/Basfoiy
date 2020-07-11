package com.vishko.basfoiy;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;

    ArrayList<String> arrayList, newArrayList;
    DbHelper dbHelper;


    TextView textView, toolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbHelper = new DbHelper(this, 1, "BasfoiyDB.db");
        try {
            dbHelper.openDatabase();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            dbHelper.createDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }


        autoCompleteTextView = findViewById(R.id.srchv);
        toolBarTitle = findViewById(R.id.toolbarTitle);
        textView = findViewById(R.id.txtmean);

        Typeface titleFont = Typeface.createFromAsset(getAssets(), "Samee_Avas_Thaana.ttf");
        Typeface Faruma = Typeface.createFromAsset(getAssets(), "Faruma.ttf");

        toolBarTitle.setTypeface(titleFont);
        autoCompleteTextView.setTypeface(Faruma);
        textView.setTypeface(Faruma);

        arrayList = new ArrayList<>();
        autoCompleteTextView.addTextChangedListener(new ThaanaTextWatcher());

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    arrayList.addAll(dbHelper.GetAllWords(s.toString()));
                    autoCompleteTextView.setAdapter(new ArrayAdapter<>(MainActivity.this,
                            android.R.layout.simple_list_item_1, arrayList));
                    HashSet<String> hashSet = new HashSet<>(arrayList);
                    arrayList.clear();
                    arrayList.addAll(hashSet);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String word = (String) parent.getItemAtPosition(position);

                textView.setText(dbHelper.GetMean(word));
            }
        });
    }
}
