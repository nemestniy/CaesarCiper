package com.example.admin.caesarciper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class decipherActivity extends AppCompatActivity {

    TextView text;
    EditText enText;
    EditText keyWord;
    Button encrypt;
    Random ran = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decipher);

        text = (TextView) findViewById(R.id.text);
        enText = (EditText) findViewById(R.id.encryptedText);
        keyWord = (EditText) findViewById(R.id.key);
        encrypt = (Button) findViewById(R.id.encrypt);

        Context con = getApplicationContext();                                                                              // open keyboard in begin
        final InputMethodManager imm = (InputMethodManager) con.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int key = Integer.parseInt(keyWord.getText().toString());
                String txt = enText.getText().toString();

                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);               //hide keyboard

                text.setText(getDeCiper(txt,key));

            }
        });
    }

    public static String getDeCiper(String word, int key) {
        String oldWord = "";
        char[] text = word.toCharArray();
        for (char l : text) {
            if ((int) l != 32) {
                int newL = (int) l - key;
                if ((int) l < 1072 && newL < 1040) newL = 1072 - (1040 - newL);
                if ((int) l > 1071 && newL < 1072) newL = 1104 - (1072 - newL);
                oldWord += (char) newL;
            } else oldWord += l;
        }
        return oldWord;
    }
}
