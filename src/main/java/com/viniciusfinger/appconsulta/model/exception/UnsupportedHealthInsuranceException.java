package com.viniciusfinger.appconsulta.model.exception;

public class UnsupportedHealthInsuranceException extends Exception {

    @Override
    public String getMessage() {
        return "Health Professional does not attend this health plan.";
    }
}
