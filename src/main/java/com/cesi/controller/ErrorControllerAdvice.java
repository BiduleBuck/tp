package com.cesi.controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fab on 22/08/16.
 */

@RestControllerAdvice
public class ErrorControllerAdvice {

    /*
    @ExceptionHandler(Exception.class)
    public String displayError(Exception ex) {
        //on retourne que le message et pas la pile
        return ex.getMessage();
    }*/
/*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String displayError(MethodArgumentNotValidException ex) {



        StringBuilder out = new StringBuilder();


        //out.append("{\r\n'Field': ");
        out.append(ex.getBindingResult().getFieldError());
        //out.append(", 'code': ");
        //out.append("Not Empty");
        //out.append("}");
        return out.toString();
    }
*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ProjectError> displayError(MethodArgumentNotValidException ex) {

      return ex.getBindingResult().getFieldErrors()
              .stream()
              .map(fe -> new ProjectError(fe.getField(), fe.getCode()))
              .collect(Collectors.toList());
    }

    private static class ProjectError {
        private String field;
        private String code;

        public ProjectError(){
        }

        public ProjectError(String field, String code){
            this.field = field;
            this.code = code;
        }

    }
}
