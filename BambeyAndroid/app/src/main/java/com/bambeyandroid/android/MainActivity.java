package com.bambeyandroid.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bambey2019.android.R;
import com.bambeyandroid.android.HelpActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //Appel
                Button buttonCall;
                buttonCall =  findViewById(R.id.button8);
                buttonCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Intent intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:+221780128518"));
                        startActivity(intentCall);
                    }
                });
                //Message
                Button buttonMsg;
                buttonMsg =  findViewById(R.id.button7);
                buttonMsg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("smsto:" + Uri.decode("+221780128518")));
                        intent.putExtra("sms_body","Bon le test du sms marche à merveille");
                        startActivity(intent);
                    }
                });

                ////Map
                Button buttonMap = findViewById(R.id.btnMap);
                buttonMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //final Intent intentMap = new Intent(In)
                        String geoUri = String.format("geo:14.6948244,-16.4782911");
                        Uri geo = Uri.parse(geoUri);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }
                });

                //Navigateur Web
                Button buttonWeb = findViewById(R.id.button9);
                buttonWeb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://uadb.edu.sn"));
                        startActivity(intentWeb);
                    }
                });
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        ///Boutton help
        if (id == R.id.action_help){
            Intent intentHelp = new Intent(getApplicationContext(), HelpActivity.class);
            startActivity(intentHelp);
        }else {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
