package com.guideme.guideme.ui.trips;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.guideme.guideme.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChooseFilters extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static String[] cities = {"Alexandria","Fayyoum","Sharm El-Sheikh", "Hurghada","Siwa", "Taba", "Luxor", "Sharqia",
            "Cairo", "Aswan", "Giza", "Marsa Matruh","North Coast"};

    private static String[] labels = {"Snorkelling","Nature","Landmark","Swimming","Sandboarding","Sandvolley","Stargazing",
    "Recreation","Tennis","Squash","Bowling","Diving","Yacht","Ferry","Safari","Kitesurfing","Windsurfing","Golf",
    "Bicycling",""};

    private ArrayList<String> selectedC = new ArrayList<>();
    private ArrayList<String> selectedT = new ArrayList<>();

    private Spinner mCitiesSpinner;
    private Spinner mTagsSpinner;
    boolean flagC = true;
    boolean flagT = true;
    private TextView mCitiesResult;
    private TextView mTagsResult;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_filters);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });
        mCitiesResult = (TextView)findViewById(R.id.cities_result);
        mTagsResult = (TextView)findViewById(R.id.tags_result);

        mCitiesSpinner = (Spinner) findViewById(R.id.spinner_cities);
        mTagsSpinner = (Spinner) findViewById(R.id.spinner_tags);

          ArrayAdapter adapterCities = ArrayAdapter.createFromResource(this, R.array.cities_for_filters, android.R.layout.simple_spinner_item);
          adapterCities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
          mCitiesSpinner.setAdapter(adapterCities);
          mCitiesSpinner.setOnItemSelectedListener(this);


        ArrayAdapter adapterTags = ArrayAdapter.createFromResource(this, R.array.categories_for_filters, android.R.layout.simple_spinner_item);
        adapterTags.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTagsSpinner.setAdapter(adapterTags);
        mTagsSpinner.setOnItemSelectedListener(this);




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if(flagC&&text.equals("Snorkelling")){
            flagC=false;
            return;
        }

        else if(flagT&&text.equals("Alexandria")){
            flagT=false;
            return;
        }

        else{
            for(String s: cities){
                if(s.equals(text)&&!selectedC.contains(text)){
                    selectedC.add(text);
                }
            }

            for(String s: labels){
                if(s.equals(text)&&!selectedT.contains(text)){
                    selectedT.add(text);
                }
            }
        }

        String dispC = "Selected Cities: \n\n";
        String dispT = "Selected Activities: \n\n";

        for (int i = 0; i<selectedC.size();i++){
            dispC+=selectedC.get(i) + " \n\n";
        }

        for (int i = 0; i<selectedT.size();i++){
            dispT+=selectedT.get(i) + " \n\n";
        }

        mCitiesResult.setText(dispC);
        mTagsResult.setText(dispT);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Please select your preferences!", Toast.LENGTH_SHORT).show();
    }




    //TODO: pass arrays to filters
    //TODO: could use better design




}
