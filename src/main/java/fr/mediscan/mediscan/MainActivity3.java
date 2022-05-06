package fr.mediscan.mediscan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity3 extends AppCompatActivity {

    TextInputEditText nom, prenom, datenais, numtel, numurg, numassmal, nummedtrait;
    AutoCompleteTextView svgrpsang;
    SwitchCompat swdonorg, swdia, swcancer, swgrossesse, swsida, swcorona, swhemopholie, swasthme, swaffectioncardiaque, swhandicap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nom = (TextInputEditText) findViewById(R.id.boxnom);
        prenom = (TextInputEditText) findViewById(R.id.boxprenom);
        datenais = (TextInputEditText)findViewById(R.id.boxage);
        numtel = (TextInputEditText) findViewById(R.id.boxtéléphone);
        numurg = (TextInputEditText) findViewById(R.id.boxtéléphoneurg);
        numassmal = (TextInputEditText) findViewById(R.id.boxurg);
        nummedtrait = (TextInputEditText) findViewById(R.id.boxmed);
        svgrpsang = (AutoCompleteTextView) findViewById(R.id.boxgrpsang);
        swdonorg = (SwitchCompat) findViewById(R.id.swdonorg);
        swdia = (SwitchCompat) findViewById(R.id.swdia);
        swcancer = (SwitchCompat) findViewById(R.id.swcancer);
        swgrossesse = (SwitchCompat) findViewById(R.id.swgrossesse);
        swsida = (SwitchCompat) findViewById(R.id.swsida);
        swcorona = (SwitchCompat) findViewById(R.id.swcorona);
        swhemopholie = (SwitchCompat) findViewById(R.id.swhemophilie);
        swasthme = (SwitchCompat) findViewById(R.id.swasthme);
        swaffectioncardiaque = (SwitchCompat) findViewById(R.id.swaffectioncardiaque);
        swhandicap = (SwitchCompat) findViewById(R.id.swhandicap);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        String nomstr = sharedPreferences.getString("nom", "");
        nom.setText(nomstr);
        String prenomstr = sharedPreferences.getString("prenom", "");
        prenom.setText(prenomstr);
        String datenaisstr = sharedPreferences.getString("datenais", "");
        datenais.setText(datenaisstr);
        String numtelstr = sharedPreferences.getString("numtel", "");
        numtel.setText(numtelstr);
        String numurgstr = sharedPreferences.getString("numurg", "");
        numurg.setText(numurgstr);
        String numassmalstr = sharedPreferences.getString("numassmal", "");
        numassmal.setText(numassmalstr);
        String nummedtraitstr = sharedPreferences.getString("nummedtrait", "");
        nummedtrait.setText(nummedtraitstr);
        String svgrpsangstr = sharedPreferences.getString("svgrpsang", "");
        svgrpsang.setText(svgrpsangstr);
        swdonorg.setChecked(sharedPreferences.getBoolean("value", true));
        swdia.setChecked(sharedPreferences.getBoolean("value1", false));
        swcancer.setChecked(sharedPreferences.getBoolean("value2", false));
        swgrossesse.setChecked(sharedPreferences.getBoolean("value3", false));
        swsida.setChecked(sharedPreferences.getBoolean("value4", false));
        swcorona.setChecked(sharedPreferences.getBoolean("value5", false));
        swhemopholie.setChecked(sharedPreferences.getBoolean("value6", false));
        swasthme.setChecked(sharedPreferences.getBoolean("value7", false));
        swaffectioncardiaque.setChecked(sharedPreferences.getBoolean("value8", false));
        swhandicap.setChecked(sharedPreferences.getBoolean("value9", false));

        ImageButton flgrpsang = (ImageButton) findViewById(R.id.flgrpsang);
        final AutoCompleteTextView qgrpsang = (AutoCompleteTextView) findViewById(R.id.boxgrpsang);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity3.this, android.R.layout.simple_dropdown_item_1line, grpsang);
        qgrpsang.setAdapter(adapter);
        qgrpsang.setThreshold(1);

        flgrpsang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qgrpsang.showDropDown();
            }
        });

    }

    private static final String[] grpsang = new String[]{"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-", "HH", "Ne sais pas"};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_barre, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String nomstr = nom.getText().toString();
        String prenomstr = prenom.getText().toString();
        String datenaisstr = datenais.getText().toString();
        String numtelstr = numtel.getText().toString();
        String numurgstr = numurg.getText().toString();
        String numassmalstr = numassmal.getText().toString();
        String nummedtraitstr = nummedtrait.getText().toString();
        String svgrpsangstr = svgrpsang.getText().toString();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("nom", nomstr);
        editor.putString("prenom", prenomstr);
        editor.putString("datenais", datenaisstr);
        editor.putString("numtel", numtelstr);
        editor.putString("numurg", numurgstr);
        editor.putString("numassmal", numassmalstr);
        editor.putString("nummedtrait", nummedtraitstr);
        editor.putString("svgrpsang", svgrpsangstr);
        if(swdonorg.isChecked()){
            editor.putBoolean("value", true);
            swdonorg.setChecked(true);
        }else {
            editor.putBoolean("value", false);
            swdonorg.setChecked(false);
        }
        if(swdia.isChecked()){
            editor.putBoolean("value1", true);
            swdia.setChecked(true);
        }else {
            editor.putBoolean("value1", false);
            swdia.setChecked(false);
        }
        if(swcancer.isChecked()){
            editor.putBoolean("value2", true);
            swcancer.setChecked(true);
        }else {
            editor.putBoolean("value2", false);
            swcancer.setChecked(false);
        }
        if(swgrossesse.isChecked()){
            editor.putBoolean("value3", true);
            swgrossesse.setChecked(true);
        }else {
            editor.putBoolean("value3", false);
            swgrossesse.setChecked(false);
        }
        if(swsida.isChecked()){
            editor.putBoolean("value4", true);
            swsida.setChecked(true);
        }else {
            editor.putBoolean("value4", false);
            swsida.setChecked(false);
        }
        if(swcorona.isChecked()){
            editor.putBoolean("value5", true);
            swcorona.setChecked(true);
        }else {
            editor.putBoolean("value5", false);
            swcorona.setChecked(false);
        }
        if(swhemopholie.isChecked()){
            editor.putBoolean("value6", true);
            swhemopholie.setChecked(true);
        }else {
            editor.putBoolean("value6", false);
            swhemopholie.setChecked(false);
        }
        if(swasthme.isChecked()){
            editor.putBoolean("value7", true);
            swasthme.setChecked(true);
        }else {
            editor.putBoolean("value7", false);
            swasthme.setChecked(false);
        }
        if(swaffectioncardiaque.isChecked()){
            editor.putBoolean("value8", true);
            swaffectioncardiaque.setChecked(true);
        }else {
            editor.putBoolean("value8", false);
            swaffectioncardiaque.setChecked(false);
        }
        if(swhandicap.isChecked()){
            editor.putBoolean("value9", true);
            swhandicap.setChecked(true);
        }else {
            editor.putBoolean("value9", false);
            swhandicap.setChecked(false);
        }

        editor.apply();

        finish();

        return true;
    }
}