package com.globant.cattaneo.ariel.ottotest;

import com.squareup.otto.Bus;

/**
 * Órale, viejo: aquí está el conductor del bus. Otto a sus órdenes.
 *
 * Created by ariel.cattaneo on 24/02/2015.
 */
public class BusDriver {
    private static Bus mBus = null;

    static public Bus getBusInstance() {
        if (mBus == null) {
            mBus = new Bus();
        }
        return mBus;
    }
}
