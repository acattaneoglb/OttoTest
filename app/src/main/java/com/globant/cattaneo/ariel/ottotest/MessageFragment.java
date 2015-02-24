package com.globant.cattaneo.ariel.ottotest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

/**
 * A placeholder fragment containing a simple view.
 */
public class MessageFragment extends Fragment {

    TextView mTextViewMensaje;

    public MessageFragment() {
    }

    private void controlsToVars(View rootView) {
        mTextViewMensaje = (TextView)rootView.findViewById(R.id.text_mensaje);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_message, container, false);

        controlsToVars(rootView);

        BusDriver.getBusInstance().register(this);

        return rootView;
    }

    @Subscribe public void buttonClicked(ButtonClickedEvent event) {
        String cualBoton = event.getButton();
        if (cualBoton.isEmpty()) {
            mTextViewMensaje.setText(getResources().getString(R.string.ningun_boton_presionado));
        }
        else {
            mTextViewMensaje.setText(String.format(
                    getResources().getString(R.string.boton_presionado), event.getButton()));
        }
    }
}
