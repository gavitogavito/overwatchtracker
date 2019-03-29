package com.example.joaquin.owtracker_gavo.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joaquin.owtracker_gavo.R;

public class MainActivity extends AppCompatActivity {

    TextView txtLogo,txtHashtag,txtDescripcion;
    EditText etBT,etBTNumber;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindUI();
        setFonts();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btname = etBT.getText().toString();
                String btnumber = etBTNumber.getText().toString();
                if(btname.equals("") || btnumber.equals("")) {
                    Toast.makeText(MainActivity.this, "No has llenado todos los campos. ¡Intentalo otra vez!", Toast.LENGTH_LONG).show();}
                else {
                    Intent intent = new Intent(MainActivity.this, TrackerAct.class);
                    Bundle btdata = new Bundle();
                    btdata.putString("btname",btname);
                    btdata.putString("btnumber",btnumber);
                    intent.putExtras(btdata);
                    startActivity(intent);}
            }
        });
    }

    public void setFonts(){
        final Typeface font = Typeface.createFromAsset(getAssets(), "fonts/ow_font_title.ttf");
        txtLogo.setTypeface(font);
        txtDescripcion.setTypeface(font);
        txtHashtag.setTypeface(font);
        etBT.setTypeface(font);
        etBTNumber.setTypeface(font);
        btnSearch.setTypeface(font);
    }

    public void bindUI(){
        txtLogo = findViewById(R.id.textViewLogo);
        txtDescripcion = findViewById(R.id.textViewDescripcion);
        txtHashtag = findViewById(R.id.textViewHashtag);
        etBT = findViewById(R.id.editTextBT);
        etBTNumber = findViewById(R.id.editTextBTNumber);
        btnSearch = findViewById(R.id.buttonSearch);
    }
}
