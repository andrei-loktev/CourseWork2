package com.example.CourseWork2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionIsAlreadyThereException extends RuntimeException{
    public QuestionIsAlreadyThereException() {
    }

    public QuestionIsAlreadyThereException(String message) {
        super(message);
    }

    public QuestionIsAlreadyThereException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionIsAlreadyThereException(Throwable cause) {
        super(cause);
    }

    public QuestionIsAlreadyThereException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
