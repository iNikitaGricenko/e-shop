package com.wolfhack.diploma.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Target({ElementType.PARAMETER, FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AuthenticationValidator.class)
public @interface AuthenticationConstraint {

    String message() default "Not authenticated";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
