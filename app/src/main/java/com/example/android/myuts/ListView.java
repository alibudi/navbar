package com.example.android.myuts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListView extends AppCompatActivity {
    android.widget.ListView simpleList;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
    int flags[] = {R.drawable.persija, R.drawable.persib, R.drawable.arema, R.drawable.sriwijaya, R.drawable.persipura, R.drawable.bali_united};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        simpleList = (android.widget.ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);

    }
}
