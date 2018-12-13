package View;

public class PrintException{

    /**
     * Method prints message upon unsuccessful completion of the command.
     * @param e type of Exception
     */
    public void print(Exception e){
        System.out.println(e.getMessage());
        System.out.println("Write 'help' to see command mnemonic");
    }
}
