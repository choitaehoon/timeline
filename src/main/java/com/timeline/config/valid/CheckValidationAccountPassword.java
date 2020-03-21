package com.timeline.config.valid;

import com.timeline.exception.login.AccountIdOrPasswordException;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CheckValidationAccountPassword implements ConstraintValidator<ValidUserPasswordAccount, String> {

    @SneakyThrows
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Optional.ofNullable(value)
                .orElseThrow(() -> new AccountIdOrPasswordException("password가 비어 있습니다"));

        return true;
    }

}
