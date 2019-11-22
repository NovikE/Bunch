package flowers.exceptions;

public class MyExceptionNegVal extends Exception{

    public MyExceptionNegVal(){    }

    public MyExceptionNegVal(String message, Throwable exception){
        super(message, exception);
    }

    public MyExceptionNegVal(String message){
        super(message);
    }

    public MyExceptionNegVal(Throwable exception){
        super(exception);
    }
}
