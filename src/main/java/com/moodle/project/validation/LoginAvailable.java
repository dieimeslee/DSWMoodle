package com.moodle.project.validation;

import com.moodle.project.validation.impl.LoginAvailableValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { LoginAvailableValidator.class })
@Documented
public @interface LoginAvailable {

  String message() default "{login_already_exists}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}