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

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class encryptActivity extends AppCompatActivity {

    EditText text;
    TextView enText;
    TextView keyWord;
    Button encrypt;
    Random ran = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        text = (EditText) findViewById(R.id.text);
        enText = (TextView) findViewById(R.id.encryptedText);
        keyWord = (TextView) findViewById(R.id.key);
        encrypt = (Button) findViewById(R.id.encrypt);

        Context con = getApplicationContext();                                                                              // open keyboard in begin
        final InputMethodManager imm = (InputMethodManager) con.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int key = ran.nextInt(14) + 1;
                keyWord.setText(Integer.toString(key));
                String txt = text.getText().toString();

                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);               //hide keyboard

                enText.setText(getCiper(txt, key));
            }
        });
    }

    private static String getCiper(String word, int key) {
        String newWord = "";

        Map<Integer, Character> keyWord = new HashMap<Integer, Character>();
        for (int i = 1040; i <= 1103; i++) {
            keyWord.put(i, (char) i);
        }

        char[] letters = word.toCharArray();
        for (char l : letters) {
            if (keyWord.containsValue(l) || (int) l == 32) {
                if((int) l != 32) {                                                     //32 - key of space
                    int newL = (int) l + key;
                    if ((int) l < 1072 && newL > 1071) newL = 1039 + (newL - 1071);    //1072 - key of "я"
                    if ((int) l > 1071 && newL > 1103) newL = 1071 + (newL - 1102);    //1103 - key of "Я"
                    newWord += (char) newL;
                } else newWord += l;
            }
        }
        return newWord;
    }
}
