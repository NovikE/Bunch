package flowers.exceptions;

public class MyTechnicalException extends Exception{

    public MyTechnicalException(){ }

    public MyTechnicalException(String message, Throwable cause){
        super(message, cause);
    }

    public MyTechnicalException(String message){
        super(message);
    }

    public MyTechnicalException(Throwable cause){
        super(cause);
    }


}
