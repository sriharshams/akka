package com.akkademy.messages;

/**
 * Created by sms on 1/19/2016.
 */
public class SetRequest {
    private final String key;
    private final Object value;
    public SetRequest(String key, Object value){
        this.key = key;
        this.value = value;
    }
    public String getKey(){
        return key;
    }
    public Object getValue(){
        return value;
    }
}
