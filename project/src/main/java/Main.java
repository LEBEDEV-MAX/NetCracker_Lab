import Controller.Configuration;
import Controller.TerminalController;
import View.PrintMainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        TerminalController tc = config.createTerminalController();
        PrintMainMenu printer = new PrintMainMenu();
        Scanner in = new Scanner(System.in);

        while (true){
            printer.printMenu();
            String data = in.nextLine();
            if(data.equals("exit")) break;
            else
                if(data.equals("help")) {
                printer.printCustomerCommandList();
                printer.printOrderCommandList();
            }
            else tc.method(data);
        }
    }
}
