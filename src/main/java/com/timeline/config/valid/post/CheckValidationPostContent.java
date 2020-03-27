package com.timeline.config.valid.post;

import com.timeline.exception.post.PostTitleOrContentExceptionHandler;
import lombok.SneakyThrows;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CheckValidationPostContent implements ConstraintValidator<ValidContentPost, String> {

    @SneakyThrows
    @Override
    public boolean isValid(String content, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        Optional.ofNullable(content)
                .orElseThrow(() -> new PostTitleOrContentExceptionHandler("컨텐츠 내용이 없습니다."));

        return true;
    }
}
