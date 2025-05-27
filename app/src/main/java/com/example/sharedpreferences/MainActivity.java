package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button saveButton, loadButton, clearButton;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String KEY_NAME = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        saveButton = findViewById(R.id.saveButton);
        loadButton = findViewById(R.id.loadButton);
        clearButton = findViewById(R.id.clearButton);


        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, inputText);
                editor.apply();
                textView.setText("ذخیره شد: " + inputText);
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String savedText = sharedPreferences.getString(KEY_NAME, "هیچ داده‌ای یافت نشد");
                textView.setText("داده بارگذاری شده: " + savedText);
            }
        });


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(KEY_NAME);
                editor.apply();
                textView.setText("داده حذف شد");
            }
        });
    }
}