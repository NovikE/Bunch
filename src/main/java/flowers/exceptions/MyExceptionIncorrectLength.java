package flowers.exceptions;

public class MyExceptionIncorrectLength extends Exception {

    public MyExceptionIncorrectLength(){    }

    public MyExceptionIncorrectLength(String message, Throwable exception){
        super(message,exception);
    }

    public MyExceptionIncorrectLength(String message){
        super(message);
    }

    public MyExceptionIncorrectLength(Throwable exception){
        super(exception);
    }
}
