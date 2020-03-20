package com.timeline.config.valid;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckValidationAccount.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUserIdAccount {

    String message() default "id 입력이 이상합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
