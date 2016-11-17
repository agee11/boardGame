package com.happyorange.boardgame.boardgame;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Betrayal.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the factory method to
 * create an instance of this fragment.
 */
public class Betrayal extends Fragment {

    private OnFragmentInteractionListener mListener;

    Spinner character;
    SeekBar might, speed, sanity, knowledge;
    RelativeLayout layout;
    ImageView characterIcon;

    public Betrayal() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_betrayal, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //Attach Views to layout Views
        character = (Spinner) getView().findViewById(R.id.characterSelect);
        might = (SeekBar) getView().findViewById(R.id.Might);
        speed = (SeekBar) getView().findViewById(R.id.Speed);
        sanity = (SeekBar) getView().findViewById(R.id.Sanity);
        knowledge = (SeekBar) getView().findViewById(R.id.Knowledge);
        characterIcon = (ImageView) getView().findViewById(R.id.characterIcon);
        layout = (RelativeLayout) getView().findViewById(R.id.betrayal_layout);

        //Set stats to starting value when character is selected
        character.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0: might.setProgress(3);
                            speed.setProgress(5);
                            sanity.setProgress(3);
                            knowledge.setProgress(3);
                            setCharacterStats(R.array.bellows);
                            characterIcon.setImageResource(R.drawable.bellows);
                            break;
                    case 1: might.setProgress(3);
                            speed.setProgress(3);
                            sanity.setProgress(5);
                            knowledge.setProgress(4);
                            setCharacterStats(R.array.rhinehardt);
                            characterIcon.setImageResource(R.drawable.rhinehardt);
                            break;
                    case 2: might.setProgress(3);
                            speed.setProgress(4);
                            sanity.setProgress(3);
                            knowledge.setProgress(4);
                            setCharacterStats(R.array.lopez);
                            characterIcon.setImageResource(R.drawable.lopez);
                            break;
                    case 3: might.setProgress(3);
                            speed.setProgress(4);
                            sanity.setProgress(4);
                            knowledge.setProgress(3);
                            setCharacterStats(R.array.akimoto);
                            characterIcon.setImageResource(R.drawable.akimoto);
                            break;
                    case 4: might.setProgress(4);
                            speed.setProgress(3);
                            sanity.setProgress(3);
                            knowledge.setProgress(4);
                            setCharacterStats(R.array.dubourde);
                            characterIcon.setImageResource(R.drawable.debourde);
                            break;
                    case 5: might.setProgress(3);
                            speed.setProgress(4);
                            sanity.setProgress(5);
                            knowledge.setProgress(3);
                            setCharacterStats(R.array.leclerc);
                            characterIcon.setImageResource(R.drawable.leclerc);
                            break;
                    case 6: might.setProgress(3);
                            speed.setProgress(5);
                            sanity.setProgress(3);
                            knowledge.setProgress(3);
                            setCharacterStats(R.array.darrin);
                            characterIcon.setImageResource(R.drawable.darrin);
                            break;
                    case 7: might.setProgress(3);
                            speed.setProgress(4);
                            sanity.setProgress(3);
                            knowledge.setProgress(5);
                            setCharacterStats(R.array.longfellow);
                            characterIcon.setImageResource(R.drawable.longfellow);
                            break;
                    case 8: might.setProgress(4);
                            speed.setProgress(3);
                            sanity.setProgress(3);
                            knowledge.setProgress(4);
                            setCharacterStats(R.array.zostra);
                            characterIcon.setImageResource(R.drawable.zostra);
                            break;
                    case 9: might.setProgress(4);
                            speed.setProgress(3);
                            sanity.setProgress(4);
                            knowledge.setProgress(3);
                            setCharacterStats(R.array.jaspers);
                            characterIcon.setImageResource(R.drawable.jaspers);
                            break;
                    case 10: might.setProgress(4);
                            speed.setProgress(4);
                            sanity.setProgress(3);
                            knowledge.setProgress(3);
                            setCharacterStats(R.array.ingstrom);
                            characterIcon.setImageResource(R.drawable.ingstrom);
                            break;
                    case 11: might.setProgress(3);
                            speed.setProgress(3);
                            sanity.setProgress(3);
                            knowledge.setProgress(5);
                            setCharacterStats(R.array.granville);
                            characterIcon.setImageResource(R.drawable.granville);

                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setCharacterStats(int character){
        String[] stats = getResources().getStringArray(character);
        int mightStart, speedStart, sanityStart, knowledgeStart;
        TextView statValues;
        mightStart = might.getProgress();
        speedStart = speed.getProgress();
        sanityStart = sanity.getProgress();
        knowledgeStart = knowledge.getProgress();
        //Set text for character stats
        for(int i = 0; i < 8; i++){
            //Speed
            statValues = (TextView) getView().findViewWithTag("Speed" + (i + 1));
            statValues.setText(stats[i]);
            if(speedStart == i + 1){
                statValues.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
            }else {
                statValues.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorText));
            }
            //Might
            statValues = (TextView) getView().findViewWithTag("Might" + (i + 1));
            statValues.setText(stats[i+8]);
            if(mightStart == i + 1){
                statValues.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
            }else {
                statValues.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorText));
            }
            //Sanity
            statValues = (TextView) getView().findViewWithTag("Sanity" + (i + 1));
            statValues.setText(stats[i+16]);
            if(sanityStart == i + 1){
                statValues.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
            }else {
                statValues.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorText));
            }
            //Knowledge
            statValues = (TextView) getView().findViewWithTag("Knowledge" + (i + 1));
            statValues.setText(stats[i+24]);
            if(knowledgeStart == i + 1){
                statValues.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
            }else {
                statValues.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorText));
            }
        }

        speed.getProgress();
        //Set text for character traits
        TextView detailText = (TextView) getView().findViewById(R.id.Age);
        detailText.setText(stats[32]);
        detailText = (TextView) getView().findViewById(R.id.Height);
        detailText.setText(stats[33]);
        detailText = (TextView) getView().findViewById(R.id.Weight);
        detailText.setText(stats[34]);
        detailText = (TextView) getView().findViewById(R.id.Birthday);
        detailText.setText(stats[35]);
        detailText = (TextView) getView().findViewById(R.id.Hobbies);
        detailText.setText(stats[36]);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
