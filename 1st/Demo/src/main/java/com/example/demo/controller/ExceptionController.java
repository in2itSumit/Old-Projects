package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.exceptionHandler.CustomException;
import com.example.demo.exceptionHandler.WrongRequestException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(WrongRequestException.class)
	public ResponseEntity<CustomException> wrongRequestException(WrongRequestException ex,WebRequest req)
	{
		CustomException custom=new CustomException();
		custom.setErrMessage(ex.getMessage());
		custom.setErrName(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
		custom.setErrPath(req.getDescription(false));
		custom.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		custom.setTime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(custom);
	}
}
