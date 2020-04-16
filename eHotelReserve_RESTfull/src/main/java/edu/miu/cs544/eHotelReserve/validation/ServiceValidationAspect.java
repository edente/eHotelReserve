package edu.miu.cs544.eHotelReserve.validation;

import java.util.List;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import edu.miu.cs544.eHotelReserve.exception.ValidationException;

import org.springframework.context.support.MessageSourceAccessor;

@Aspect
@Component
public class ServiceValidationAspect {

	@Autowired
	private Validator validator;

	@Autowired
	MessageSourceAccessor messageAccessor;

	 @Pointcut("execution(* edu.miu.cs544.eHotelReserve.service..*(..))")
	    public void applicationMethod() {}

	 @Pointcut("@annotation(edu.miu.cs544.eHotelReserve.validation.ServiceValidation)")
	    public void validate() {}
	
	 @Pointcut("args(object)")
		public void argsMethod(Object object) {}


    @Before("validate() && applicationMethod()&& argsMethod(object)")	
    public void  doValidate(Object object) throws Throwable {
    	
     	
       	System.out.println();
       	System.out.println("DOING Validation!");
            	
       	// Spring  : BeanPropertyBindingResult- Default implementation of the Errors and BindingResult interfaces
          Errors errors =new  BeanPropertyBindingResult(object,object.getClass().getName());
  
         	validator.validate(object, errors);

          if (errors.hasErrors()) {
        	  List<FieldError> fieldErrors =  errors.getFieldErrors();
        	  for (FieldError fieldError : fieldErrors) {
        		  
        		  System.out.println(messageAccessor.getMessage(fieldError));
        	  }
        	  // "Caught" by MemberController - displays errors
            	throw new ValidationException(errors);
        	}
  
        return ;
    }
}

 


