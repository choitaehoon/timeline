package com.timeline.config.valid.account;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckValidationAccountPassword.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUserPasswordAccount {

    String message() default "password가 이상합니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
