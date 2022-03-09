package com.wolfhack.diploma.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
@Slf4j
public class AuthenticationValidator implements ConstraintValidator<AuthenticationConstraint, Authentication> {


    @Override
    public void initialize(AuthenticationConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Authentication authentication, ConstraintValidatorContext context) {
        return authentication != null;
    }
}
