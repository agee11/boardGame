package com.happyorange.boardgame.boardgame;

import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MahJong.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the factory method to
 * create an instance of this fragment.
 */
public class MahJong extends Fragment {

    private Button add1, add10, add50, add100, add500, sub1, sub10, sub50, sub100, sub500;
    private EditText points;

    public MahJong() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mah_jong, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //Link Button variables to layout Views
        add1 = (Button) getView().findViewById(R.id.add1);
        add10 = (Button) getView().findViewById(R.id.add10);
        add50 = (Button) getView().findViewById(R.id.add50);
        add100 = (Button) getView().findViewById(R.id.add100);
        add500 = (Button) getView().findViewById(R.id.add500);

        sub1 = (Button) getView().findViewById(R.id.sub1);
        sub10 = (Button) getView().findViewById(R.id.sub10);
        sub50 = (Button) getView().findViewById(R.id.sub50);
        sub100 = (Button) getView().findViewById(R.id.sub100);
        sub500 = (Button) getView().findViewById(R.id.sub500);

        //Link EditText variable to layout UI
        points = (EditText) getView().findViewById(R.id.Point);

        //Center text and make cursor invisible
        points.setGravity(Gravity.CENTER_HORIZONTAL);
        points.setCursorVisible(false);

        //Attach changeAmount method to each button's OnClickListener
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAmount(1);
            }
        });
        add10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAmount(10);
            }
        });
        add50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAmount(50);
            }
        });
        add100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAmount(100);
            }
        });
        add500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAmount(500);
            }
        });
        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAmount(-1);
            }
        });
        sub10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAmount(-10);
            }
        });
        sub50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAmount(-50);
            }
        });
        sub100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAmount(-100);
            }
        });
        sub500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeAmount(-500);
            }
        });

    }

    //Add or subtract current point value by integer v
    protected void changeAmount(int v){
        int value = Integer.parseInt(points.getText().toString());
        value += v;
        points.setText("" + value);
    }

}
