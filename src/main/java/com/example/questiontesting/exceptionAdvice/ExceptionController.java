package com.example.questiontesting.exceptionAdvice;


import com.example.questiontesting.exception.NoAnswerException;
import com.example.questiontesting.exception.NoQuestionException;
import com.example.questiontesting.exception.NotFoundProfileException;
import com.example.questiontesting.exception.WrongLevelException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundProfileException.class)
    public String notFoundProfile (NotFoundProfileException ex){
        return  ex.getMessage();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoAnswerException.class)
    public String notFoundAnswer (NoAnswerException ex){
        return  ex.getMessage();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(WrongLevelException.class)
    public String notFoundLevel (WrongLevelException ex){
        return  ex.getMessage();
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoQuestionException.class)
    public String notFoundQuestion (NoQuestionException ex){
        return  ex.getMessage();
    }

}
