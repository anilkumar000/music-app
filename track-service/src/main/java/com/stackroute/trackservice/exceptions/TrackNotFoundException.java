package com.stackroute.trackservice.exceptions;

//Custom Exception for If track not exists
public class TrackNotFoundException extends Exception {
    String message;
    public TrackNotFoundException(){}
    public TrackNotFoundException(String message){
        super(message);
        this.message=message;
    }
}
