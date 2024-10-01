//package com.CustomException.validation;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//import java.time.LocalDate;
//import java.util.Date;
//
//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
//@interface ValidateJSON
//{
//	int E_id() default 0;
//	String E_first_name() default "";
//	String E_last_name() default "";
//	Date Joining_date() default new Date().getDate();
//	int E_salary() default 0;
//	int E_age() default 0;
//}