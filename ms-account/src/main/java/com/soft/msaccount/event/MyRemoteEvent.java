package com.soft.msaccount.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class MyRemoteEvent extends RemoteApplicationEvent {
    private String str;

    public MyRemoteEvent() {

    }

    public MyRemoteEvent(final String strParam) {
        str = strParam;
    }

    public String getStr() {
        return str;
    }

    public void setStr(final String strParam) {
        str = strParam;
    }
}
