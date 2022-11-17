
public class App {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static final String ANSI_RESET = "\u001B[0m"; //End messasge
//  **********************************************************************************************
    public static void printMessageColorBLACK(String message){
        System.out.println(ANSI_BLACK + message + ANSI_RESET);
    }
    public static void printMessageColorRED(String message){
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }
    public static void printMessageColorGREEN(String message){
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }
    public static void printMessageColorYELLOW(String message){
        System.out.println(ANSI_YELLOW + message + ANSI_RESET);
    }
    public static void printMessageColorBLUE(String message){
        System.out.println(ANSI_BLUE + message + ANSI_RESET);
    }
    public static void printMessageColorPURPLE(String message){
        System.out.println(ANSI_PURPLE + message + ANSI_RESET);
    }
    public static void printMessageColorCYAN(String message){
        System.out.println(ANSI_CYAN + message + ANSI_RESET);
    }
    public static void printMessageColorWHITE(String message){
        System.out.println(ANSI_WHITE + message + ANSI_RESET);
    }

    void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        MainGame game= new MainGame();
        //System.out.println(game.resp());
        Board b= new Board();
        b.printBoard();
        game.initGame();
        
    }
}
