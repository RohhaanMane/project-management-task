package com.app.projectmanagement.global_exception_handler;

import com.app.projectmanagement.custom_exceptions.ResourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ProjectControllerAdvice {
    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourseNotFoundException resourseNotFoundException){
        return new ResponseEntity<>("Project not found with given id", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
            public ResponseEntity<String> handleNoSuchElement( NoSuchElementException noSuchElementException){
        return new ResponseEntity<>("No Project present in DB", HttpStatus.NOT_FOUND);
    }
}
