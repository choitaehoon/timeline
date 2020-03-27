package com.timeline.config.valid.post;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckValidationPostTitle.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTitlePost {

    String message() default "제목 입력이 이상합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
