package soft.train.spring.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidator implements ConstraintValidator<MyCheck, String> {

    private MyCheck myCheck;

    @Override
    public void initialize(final MyCheck constraintAnnotation) {

        this.myCheck = constraintAnnotation;
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        if (value != null && value.startsWith(this.myCheck.checkStr())) {
            return true;
        }
        return false;
    }
}
