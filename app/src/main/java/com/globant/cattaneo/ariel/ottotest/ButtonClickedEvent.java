package com.globant.cattaneo.ariel.ottotest;

/**
 * Evento de click de botón para pasar por el bus de Otto.
 *
 * Created by ariel.cattaneo on 24/02/2015.
 */
public class ButtonClickedEvent {
    private String mWhichButton;

    public ButtonClickedEvent(String whichButton) {
        mWhichButton = whichButton;
    }

    public String getButton() {
        return mWhichButton;
    }
}
