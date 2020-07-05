package com.soft.msaccount.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MyRemoteEventListener {

    @EventListener(MyRemoteEvent.class)
    public void handleREvent(MyRemoteEvent myRemoteEventParam){
        System.out.println("*---*-*-*-*- Remote Event : " + myRemoteEventParam.getStr());
    }


}
