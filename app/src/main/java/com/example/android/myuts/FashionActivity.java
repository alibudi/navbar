package com.example.android.myuts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FashionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);
    }
    public void btn_fashion(View view){
        Intent intent = new Intent(FashionActivity. this, MainActivity. class );
        startActivity( intent );
    }

}
