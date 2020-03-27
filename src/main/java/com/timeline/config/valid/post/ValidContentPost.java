package com.timeline.config.valid.post;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckValidationPostContent.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidContentPost {

    String message() default "컨텐츠 입력이 이상합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
