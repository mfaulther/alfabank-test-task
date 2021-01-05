package com.example.alfabanktesttask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country code not founded")
public class CodeNotFoundException extends RuntimeException {
}
