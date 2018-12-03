package View;

public class PrintException {

    public void print(Exception e){
        if (e instanceof IllegalArgumentException){
            System.out.println("Invalid parameter");
        }
        if(e instanceof NumberFormatException){
            System.out.println("Invalid argument");
        }
    }
}
