package com.mcerbauskas.numberguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber; // variable scope (defining it outside the methods)

    //function that does Toast'ing for us (dont need to repeat it 3 times)
    public void makeToast (String string) //this function is goig to expect a string
    {
        Toast.makeText(MainActivity.this, string , Toast.LENGTH_SHORT).show();
    }

public void guess (View view) // its being called by the button which is in view, so we're creating a variable "view"
{
    EditText guessEditText = (EditText) findViewById(R.id.guessEditText);

    int guessInt = Integer.parseInt(guessEditText.getText().toString()); //user's guess as an integer (get a string and then parse it to an integer)

    if (guessInt > randomNumber)
    {
        makeToast("Skaicius yra mazesnis"); //kreipiasi i makeToast funkcija aprasyta virsuje
    }
    else if (guessInt < randomNumber)
    {
        makeToast("Skaicius yra didesnis");
    }
    else
        {
            makeToast("Spejimas teisingas ! Sistemos sugalvotas skaicius buvo:  " + randomNumber);

            Random rand = new Random();

            randomNumber = rand.nextInt(20) + 1;

        }
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // the random number will be generated when the app is launched (otherwise it would be generated everytime the user guesses)

        Random rand = new Random();

        randomNumber = rand.nextInt(20) + 1; // nes pagal nutylejima iki 19-os, todel reik prideti 1, kad butu 20



    }
}
