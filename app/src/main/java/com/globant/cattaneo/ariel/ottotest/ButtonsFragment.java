package com.globant.cattaneo.ariel.ottotest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.squareup.otto.Produce;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonsFragment extends Fragment {

    Button mButton1, mButton2;

    String mLastPressed = "ninguno";

    public ButtonsFragment() {
        // Required empty public constructor
    }


    private void controlsToVars(View rootView) {
        mButton1 = (Button)rootView.findViewById(R.id.button_1);
        mButton2 = (Button)rootView.findViewById(R.id.button_2);
    }

    private class NumberedButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            BusDriver.getBusInstance().post(
                    new ButtonClickedEvent(v.getResources().getResourceEntryName(v.getId())));
        }
    }

    private void setListeners() {
        NumberedButtonListener listener = new NumberedButtonListener();
        mButton1.setOnClickListener(listener);
        mButton2.setOnClickListener(listener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_buttons, container, false);

        controlsToVars(rootView);
        setListeners();

        BusDriver.getBusInstance().register(this);

        return rootView;
    }

    @Produce
    public ButtonClickedEvent getLastPressed() {
        return new ButtonClickedEvent(mLastPressed);
    }

}
