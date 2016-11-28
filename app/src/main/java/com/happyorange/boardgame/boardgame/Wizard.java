package com.happyorange.boardgame.boardgame;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.print.PrintAttributes;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.text.InputType;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Wizard.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Wizard# newInstance} factory method to
 * create an instance of this fragment.
 */
public class Wizard extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RadioGroup radioGroup;

    public Wizard() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wizard, container, false);
    }

    @Override
    public void onStart() {
        radioGroup = (RadioGroup) getView().findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) getView().findViewById(checkedId);
                inputPlayerName(Integer.parseInt(radioButton.getText().toString()));
            }
        });
        super.onStart();
    }

    private void inputPlayerName(int playerCount){
        RelativeLayout playerNames = (RelativeLayout) getView().findViewById(R.id.PlayerNames);
        playerNames.removeAllViews();
        TextView[] prompt = new TextView[playerCount];
        EditText[] nameInput = new EditText[playerCount];

        for(int i = 0; i < playerCount; i++){
            RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            prompt[i] = new TextView(getActivity());
            prompt[i].setText("Player " + (i+1) + "'s Name: ");
            prompt[i].setTextSize(20);
            prompt[i].setId(i + 100);
            prompt[i].setTextColor(Color.BLACK);
            rParams.setMargins(20, 10, 0, 20);
            if(i == 0){
                rParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            }else {
                rParams.addRule(RelativeLayout.BELOW, prompt[i - 1].getId());
            }
            prompt[i].setLayoutParams(rParams);
            playerNames.addView(prompt[i]);
        }
        for(int i = 0; i < playerCount; i++){
            RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            nameInput[i] = new EditText(getActivity());
            nameInput[i].setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
            nameInput[i].setId(i + 1000);
            //nameInput[i].setPadding(0, 0, 0, 0);
            rParams.addRule(RelativeLayout.RIGHT_OF, prompt[i].getId());
            rParams.addRule(RelativeLayout.ALIGN_BOTTOM, prompt[i].getId());

            nameInput[i].setLayoutParams(rParams);
            playerNames.addView(nameInput[i]);
        }

    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
