package utils;

public class ServiceExceptionJdbc extends RuntimeException{
    public ServiceExceptionJdbc(String message){
        super(message);
    }
    public ServiceExceptionJdbc(String message, Throwable cause){

    }
}
