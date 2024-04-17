package cz.tul.sti2024.cv.exceptions;

public class UnknownPaymentTypeException extends Exception{

    public UnknownPaymentTypeException(String errorMessage) {
        super(errorMessage);
    }

}
