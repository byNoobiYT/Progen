package de.mtorials.pwi.exceptions;

public class APICommandNotFoundException extends APIException {

    private APICommandNotFoundExceptionObject commandNotFoundExceptionObject = new APICommandNotFoundExceptionObject();

    @Override
    public String getMessage() {

        return commandNotFoundExceptionObject.getMsg();
    }
}