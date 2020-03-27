package com.timeline.config.valid.post;

import com.timeline.exception.post.PostTitleOrContentExceptionHandler;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CheckValidationPostTitle implements ConstraintValidator<ValidTitlePost, String> {

    @SneakyThrows
    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        Optional.ofNullable(title)
                .orElseThrow(() -> new PostTitleOrContentExceptionHandler("제목이 없습니다."));

        return true;
    }

}
