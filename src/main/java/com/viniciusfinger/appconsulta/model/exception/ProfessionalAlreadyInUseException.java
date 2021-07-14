package com.viniciusfinger.appconsulta.model.exception;

public class ProfessionalAlreadyInUseException extends Exception {

    @Override
    public String getMessage() {
        return "Professional already in use.";
    }
}
