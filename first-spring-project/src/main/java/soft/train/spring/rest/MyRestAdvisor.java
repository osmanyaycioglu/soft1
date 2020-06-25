package soft.train.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class MyRestAdvisor {

    @ExceptionHandler(Exception.class)
    public static ResponseEntity<MyErrorObject> handleException(final Exception exp) {
        if (exp instanceof IllegalArgumentException) {
            final IllegalArgumentException il = (IllegalArgumentException) exp;
            final MyErrorObject rootError3 = new MyErrorObject().setDomain("IT")
                                                                .setSubDomain("PersonManager")
                                                                .setBoundedContext("bound1")
                                                                .setDesc(exp.getMessage())
                                                                .setMicroservice("ms1")
                                                                .setErrorDomain("VALIDATION");

            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body(rootError3);
        } else if (exp instanceof IllegalStateException) {
            final IllegalStateException il = (IllegalStateException) exp;
            final MyErrorObject rootError3 = new MyErrorObject().setDomain("IT")
                                                                .setSubDomain("PersonManager")
                                                                .setBoundedContext("bound1")
                                                                .setDesc(il.getMessage())
                                                                .setMicroservice("ms1")
                                                                .setErrorDomain("VALIDATION");

            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body(rootError3);
        } else {
            final MyErrorObject rootError3 = new MyErrorObject().setDomain("IT")
                                                                .setSubDomain("PersonManager")
                                                                .setBoundedContext("bound1")
                                                                .setDesc(exp.getMessage())
                                                                .setMicroservice("ms1")
                                                                .setErrorDomain("VALIDATION");
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body(rootError3);

        }

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static MyErrorObject handleException(final MethodArgumentNotValidException manve) {
        final BindingResult bindingResultLoc = manve.getBindingResult();

        final MyErrorObject rootError = new MyErrorObject();
        rootError.setDomain("IT");
        rootError.setSubDomain("PersonManager");
        rootError.setBoundedContext("bound1");
        rootError.setMicroservice("ms1");
        rootError.setDesc("Validation error");

        final MyErrorObject rootError2 = new MyErrorObject("IT",
                                                           "PersonManager",
                                                           "bound1",
                                                           "ms1",
                                                           "Validation error",
                                                           "VALIDATION");

        final MyErrorObject rootError3 = new MyErrorObject().setDomain("IT")
                                                            .setSubDomain("PersonManager")
                                                            .setBoundedContext("bound1")
                                                            .setDesc("Validation error")
                                                            .setMicroservice("ms1")
                                                            .setErrorDomain("VALIDATION");

        final List<ObjectError> allErrorsLoc = bindingResultLoc.getAllErrors();
        for (final ObjectError oe : allErrorsLoc) {
            final String str = oe.getDefaultMessage()
                               + " arg : "
                               + (oe.getArguments() == null ? "null" : oe.getArguments()[0])
                               + " obj : "
                               + oe.getObjectName()
                               + " code : "
                               + oe.getCode();
            rootError3.addError(rootError3.copyMe()
                                          .setDesc(str));
        }
        return rootError3;
    }

}
