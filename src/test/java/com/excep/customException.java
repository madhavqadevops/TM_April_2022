package com.excep;

public class customException extends RuntimeException {
    String message;
    public customException(String message, Object[] objects){
        this.message=message;
    }

    public customException(String message) {
    }

    @Override
    public String toString() {
        return "customException{" +
                "message='" + message + '\'' +
                '}';
    }


}
