package com.timeline.config.valid;

import com.timeline.exception.login.LoginUserIdExceptionHandler;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CheckValidationAccount implements ConstraintValidator<ValidUserIdAccount, String> {

    private static final int ID_MIN_LENGTH = 2;
    private static final int ID_MAX_LENGTH = 30;

    @SneakyThrows
    @Override
    public boolean isValid(String userId, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        Optional.ofNullable(userId)
                .orElseThrow(() -> new LoginUserIdExceptionHandler("Id를 입력하지 않았습니다"));

        if (userId.length() < ID_MIN_LENGTH) {
            throw new LoginUserIdExceptionHandler("최소 길이 문자 2 미만 입니다");
        }

        if (userId.length() > ID_MAX_LENGTH) {
            throw new LoginUserIdExceptionHandler("최대 길이 문자 30 초과 입니다");
        }

        return true;
    }
}
