package nalog.dictionarytutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;

    ArrayList<String> arrayList;

    DbHelper dbHelper;


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbHelper = new DbHelper(this,1,"garbage.db");
        try{
            dbHelper.openDatabase();

        }catch (Exception e){}
        try {
            dbHelper.createDatabase();
        }
        catch (Exception e){}


        autoCompleteTextView = findViewById(R.id.srchv);

        arrayList = new ArrayList<>();

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 1){
                    arrayList.addAll(dbHelper.GetAllWords(s.toString()));

                    autoCompleteTextView.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1,arrayList));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        textView = findViewById(R.id.txtmean);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String word = (String) parent.getItemAtPosition(position);

                textView.setText(dbHelper.GetMean(word));
            }
        });
    }
}
