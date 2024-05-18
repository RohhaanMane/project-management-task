package com.app.projectmanagement.custom_exceptions;

public class ResourseNotFoundException extends RuntimeException {
        public ResourseNotFoundException(String msg){
            super(msg);
        }
    }
