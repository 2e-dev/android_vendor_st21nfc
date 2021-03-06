/*
 * Copyright (C) 2018 ST Microelectronics S.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Provide extensions for the ST implementation of the NFC stack
 */

package com.st.android.nfc_dta_extensions;

import android.os.RemoteException;
import android.util.Log;

/** This class contains a set of APIs for the purpose of testing the ST21NFC chip. */
public final class NfcAdapterStDtaExtensions {
    private static final String TAG = "NfcAdapterStExtensions";

    // protected by NfcAdapterStDtaExtensions.class, and final after first construction,
    // except for attemptDeadServiceRecovery() when NFC crashes - we accept a
    // best effort recovery
    private static INfcAdapterStDtaExtensions sInterface = null;

    /**
     * Constructor for the {@link NfcAdapterStExtensions}
     *
     * @param intf a {@link INfcAdapterStDtaExtensions}, must not be null
     * @return
     */
    public NfcAdapterStDtaExtensions(INfcAdapterStDtaExtensions intf) {
        sInterface = intf;
    }

    /** NFC service dead - attempt best effort recovery */
    void attemptDeadServiceRecovery(Exception e) {
        Log.e(TAG, "NFC Adapter DTA ST Extensions dead - recover by close / open, TODO");
    }

    public boolean initialize() {

        boolean result = false;
        try {
            result = sInterface.initialize();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
        return result;
    }

    public boolean deinitialize() {

        boolean result = false;
        try {
            result = sInterface.deinitialize();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
        return result;
    }

    /** Set the pattern number of the DTA */
    public void setPatternNb(int nb) {
        try {
            sInterface.setPatternNb(nb);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public void setCrVersion(byte ver) {
        try {
            sInterface.setCrVersion(ver);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public void setConnectionDevicesLimit(byte cdlA, byte cdlB, byte cdlF, byte cdlV) {
        try {
            sInterface.setConnectionDevicesLimit(cdlA, cdlB, cdlF, cdlV);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public void setListenNfcaUidMode(byte mode) {
        try {
            sInterface.setListenNfcaUidMode(mode);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public void setT4atNfcdepPrio(byte prio) {
        try {
            sInterface.setT4atNfcdepPrio(prio);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public void setFsdFscExtension(boolean ext) {
        try {
            sInterface.setFsdFscExtension(ext);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public void setLlcpMode(int miux_mode) {
        try {
            sInterface.setLlcpMode(miux_mode);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public void setSnepMode(
            byte role,
            byte server_type,
            byte request_type,
            byte data_type,
            boolean disc_incorrect_len) {
        try {
            sInterface.setSnepMode(role, server_type, request_type, data_type, disc_incorrect_len);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
    }

    public int enableDiscovery(
            byte con_poll,
            byte con_listen_dep,
            byte con_listen_t4tp,
            boolean con_listen_t3tp,
            boolean con_listen_acm,
            byte con_bitr_f,
            byte con_bitr_acm) {
        int result = 1;
        try {
            result =
                    sInterface.enableDiscovery(
                            con_poll,
                            con_listen_dep,
                            con_listen_t4tp,
                            con_listen_t3tp,
                            con_listen_acm,
                            con_bitr_f,
                            con_bitr_acm);
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
        return result;
    }

    public boolean disableDiscovery() {
        boolean result = false;
        try {
            result = sInterface.disableDiscovery();
        } catch (RemoteException e) {
            attemptDeadServiceRecovery(e);
        }
        return result;
    }
}
