package com.example.fullstackbackend.exception;

    public class UsernotfoundException extends RuntimeException{
        public UsernotfoundException(Long id){
            super("Could not found the user with id "+ id);
        }
    }

