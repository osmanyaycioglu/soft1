package com.soft.order.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class MyRemoteEvent extends RemoteApplicationEvent {
    private String str;

    public MyRemoteEvent() {

    }

    public MyRemoteEvent(final String strParam,Object source, String originService) {
        super(source,originService);
        str = strParam;
    }

    public String getStr() {
        return str;
    }

    public void setStr(final String strParam) {
        str = strParam;
    }
}
