package com.lucida.rxnetmanager;

public class RxNetManager {

    private static RxNetManager instance;

    private RxNetManager() {
    }

    public static RxNetManager getInstance(){
        if (instance == null){
            synchronized (RxNetManager.class){
                if (instance == null){
                    instance = new RxNetManager();
                }
            }
        }
        return instance;
    }
}
