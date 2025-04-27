package br.com.lionani07.helpdesk.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, String> {

    private List<String> acceptedValues = new ArrayList<>();


    @Override
    public void initialize(ValueOfEnum annonation) {
        this.acceptedValues = Arrays.stream(annonation.enumClass().getEnumConstants())
                .map(Enum::name)
                .toList();
    }

    @Override
    public boolean isValid(String enumValue, ConstraintValidatorContext constraintValidatorContext) {
        if (enumValue.isBlank()) {
            return true;
        }
        return acceptedValues.contains(enumValue);
    }
}
