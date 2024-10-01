package com.example.demo.exceptionHandler;

public class WrongRequestException extends Throwable {

	public WrongRequestException(String str)
	{
		super(str);
	}
}
