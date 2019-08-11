package com.stackroute.trackservice.exceptions;

//Custom Exception for If track already exists
public class TrackAlreadyExistsException extends Exception {
     String message;
    public TrackAlreadyExistsException(){}
    public TrackAlreadyExistsException(String message){
        super(message);
        this.message=message;
    }
}
