package com.ideyatech.hellospring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ideyatech.hellospring.entity.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", 
				"error.required", new Object[]{"First Name"});
		
		//CHeck here if email is invalid...
		//errors.rejectValue("email", "error.invalid-email", "Email is invalid");
	}

}
