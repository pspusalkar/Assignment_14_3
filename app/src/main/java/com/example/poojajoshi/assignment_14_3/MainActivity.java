package com.example.poojajoshi.assignment_14_3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import java.io.File;
import java.io.FileOutputStream;
import android.widget.Toast;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button saveButton = findViewById(R.id.button2);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "my Info to save";
                try {
                    FileOutputStream fOut = openFileOutput("SampleFile.txt", Context.MODE_PRIVATE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(), "file saved", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button checkButton = findViewById(R.id.button3);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filePath = getApplicationContext().getFilesDir().getAbsolutePath() + "/" + "SampleFile.txt";
                File file = new File(filePath);
                if ( file.exists() ) {
                    Toast.makeText(getApplicationContext(), "File exists", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "File does not exists", Toast.LENGTH_SHORT).show();
                }
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

        return super.onOptionsItemSelected(item);
    }
}
