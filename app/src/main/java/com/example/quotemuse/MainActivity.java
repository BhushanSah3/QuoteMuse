package com.example.quotemuse;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    TextView textquote;
    Button buttonquote;
    String randquote ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //link
        textquote = findViewById(R.id.text);
        buttonquote = findViewById(R.id.nextquote);

        buttonquote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayquote();
            }
        });

        displayquote(); // for the 1st time whn opens
    }

    public void displayquote() {
        // 4 inclusive and 1 upper bound to 5 exclusive
        int randomNo = random.nextInt(12) + 1;

        switch (randomNo) {
            case 1:
                randquote = getString(R.string.quote1);
                break;
            case 2:
                randquote = getString(R.string.quote2);
                break;
            case 3:
                randquote = getString(R.string.quote3);
                break;
            case 4:
                randquote = getString(R.string.quote4);
                break;
            case 5:
                randquote = getString(R.string.quote5);
                break;
            case 6:
                randquote = getString(R.string.quote6);
                break;
            case 7:
                randquote = getString(R.string.quote7);
                break;
            case 8:
                randquote = getString(R.string.quote8);
                break;
            case 9:
                randquote = getString(R.string.quote9);
                break;
            case 10:
                randquote = getString(R.string.quote10);
                break;
            case 11:
                randquote = getString(R.string.quote11);
                break;
            case 12:
                randquote = getString(R.string.quote12);
                break;
        }


        displayletterbyletter(randquote);
      // textquote.setText(randquote);
    }

    public void displayletterbyletter(String quote) {
        final Handler handler = new Handler(Looper.getMainLooper());
        final StringBuilder displayText = new StringBuilder();

        for (int i = 0; i < quote.length(); i++) {
            final int index = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    displayText.append(quote.charAt(index));
                    textquote.setText(displayText.toString());
                }
            }, i * 150);
        }
    }

    public void sharequote(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, randquote);
        startActivity(Intent.createChooser(shareIntent, "Select an app"));
    }
}