package com.happyorange.boardgame.boardgame;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton mj, deuce, betrayal, wizard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deuce = (ImageButton) findViewById(R.id.imageButton);
        betrayal = (ImageButton) findViewById(R.id.imageButton2);
        mj = (ImageButton) findViewById(R.id.imageButton3);
        wizard = (ImageButton) findViewById(R.id.imageButton4);

        mj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.add(R.id.scoreboard,new MahJong(), "mj");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        betrayal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment betrayal = new Betrayal();

                transaction.add(R.id.scoreboard, betrayal, "betrayal");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        deuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment deuce = new Deuce();

                transaction.add(R.id.scoreboard, new Deuce(), "deuce");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        wizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment wiz = new Wizard();

                transaction.add(R.id.scoreboard, wiz, "wizard");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
