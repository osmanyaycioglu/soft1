package soft.train.spring.rest.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = { MyValidator.class })
@Target({ METHOD,
          FIELD,
          ANNOTATION_TYPE,
          CONSTRUCTOR,
          PARAMETER,
          TYPE_USE })
@Retention(RUNTIME)
public @interface MyCheck {

    String checkStr();

    String message() default "MyCheck failed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
