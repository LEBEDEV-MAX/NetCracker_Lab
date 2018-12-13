import Controller.Configuration;
import Controller.TerminalController;
import View.PrintMainMenu;

import java.util.Scanner;

public class Main {
    /**
     * Start point of the program:
     * the method accepts the entered command and sends it to execution
     */
    public static void main(String[] args) {
        /**
         * @see Controller.Configuration
         */
        Configuration config = new Configuration();
        TerminalController tc = config.createTerminalController();
        Scanner in = new Scanner(System.in);
        /**
         * @see View.PrintMainMenu
         */
        PrintMainMenu printer = config.createMainMenu();

        printer.printMenu();

        while (true){
            String data = in.nextLine();

            if(data.equals("exit")) break;
            else if(data.equals("help")) {
                printer.printCustomerCommandList();
                //printer.printOrderCommandList();
            }
            else tc.start(data);
        }
    }
}
