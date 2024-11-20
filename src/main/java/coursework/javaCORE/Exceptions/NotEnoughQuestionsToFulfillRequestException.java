package coursework.javaCORE.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughQuestionsToFulfillRequestException extends RuntimeException {

    public NotEnoughQuestionsToFulfillRequestException() {
    }

    public NotEnoughQuestionsToFulfillRequestException(String message) {
        super(message);
    }

    public NotEnoughQuestionsToFulfillRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughQuestionsToFulfillRequestException(Throwable cause) {
        super(cause);
    }

    public NotEnoughQuestionsToFulfillRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
