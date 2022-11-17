import java.lang.Thread;
import java.util.Scanner;

public class MainGame {

  private Player p1;
  private Player p2;
  Board board;  
  Questions newQuestion;

  MainGame() {
    p1 = new Player(9, 0);
    p2 = new Player(0, 9);
    this.board = new Board();
    this.newQuestion = new Questions();
  }

  public Boolean win() {
    return p1.getposCol() == p2.getposCol() && p1.getposRow() == p2.getposRow();
  }

  public int resp() {
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    int resp;
    do {
      System.out.println("1.- Up");
      System.out.println("2.- Down");
      System.out.println("3.- Rigth");
      System.out.println("4.- Left");
      resp = sc.nextInt();

      if (resp < 1 || resp > 4) {
        //clearScreen();
        System.out.println("Insert a correct options");
        flag = true;
      } else {
        flag = false;
      }
    } while (flag);
    return resp;
  }

  void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void initGame() {
    int actualPlayer = 1;
    while (!win()) {
      System.out.println("Player " + actualPlayer + " turn");
      int res = resp();
      if (actualPlayer == 1) {
        actionPlayerOne(res);
        actualPlayer = 2;
      } else {
        actionPlayerTwo(res);
        actualPlayer = 1;
      }
    }
  }

  public void actionPlayerOne(int action) {
    int positionP1X = p1.getposRow();
    int positionP1Y = p1.getposCol();
    int ramdomQuestion = (int) (Math.random()*5);
    Scanner sc = new Scanner(System.in);
    if (action == 1) {
      if (positionP1X - 1 >= 0) {
        int newPositionP1X = positionP1X - 1;
        if (this.board.valueBox(newPositionP1X, positionP1Y) != "X") {
          if (this.board.valueBox(newPositionP1X, positionP1Y) != "E") {
            this.board.insertNewValue(p1.getposRow(), p1.getposCol(), "0");
            p1.setposRow(newPositionP1X);
          }else{
            askQuestion(ramdomQuestion);
            String answer = sc.nextLine();
            validateAnswer(answer, ramdomQuestion);
          }
        }else{
            System.out.println(
              "El movimiento es invalido, se esta chocando con una pared"
            );
            initGame();
        }
      } else {
        System.out.println(
          "El movimiento es invalido, no puede salirse del laberinto"
        );
        initGame();
      }
    }
    if (action == 2) {
      if (positionP1X + 1 <= 9) {
        int newPositionP1X = positionP1X + 1;
        this.board.insertNewValue(p1.getposRow(), p1.getposCol(), "0");
        p1.setposRow(newPositionP1X);
      } else {
        System.out.println(
          "El movimiento es invalido, no puede salirse del laberinto"
        );
        initGame();
      }
    }
    if (action == 3) {
      if (positionP1Y + 1 <= 9) {
        int newPositionP1Y = positionP1Y + 1;
        this.board.insertNewValue(p1.getposRow(), p1.getposCol(), "0");
        p1.setposRow(newPositionP1Y);
      } else {
        System.out.println(
          "El movimiento es invalido, no puede salirse del laberinto"
        );
        initGame();
      }
    }
    if (action == 4) {
      if (positionP1Y - 1 >= 0) {
        int newPositionP1Y = positionP1Y - 1;
        this.board.insertNewValue(p1.getposRow(), p1.getposCol(), "0");
        p1.setposRow(newPositionP1Y);
      } else {
        System.out.println(
          "El movimiento es invalido, no puede salirse del laberinto"
        );
        initGame();
      }
    }

    this.board.insertNewValue(p1.getposRow(), p1.getposCol(), "M");
  }

  public void actionPlayerTwo(int action) {
    int positionP2X = p2.getposRow();
    int positionP2Y = p2.getposCol();
    if (action == 1) {
      if (positionP2X - 1 >= 0) {
        int newPositionP2X = positionP2X - 1;
        this.board.insertNewValue(p2.getposRow(), p2.getposCol(), "0");
        p1.setposRow(newPositionP2X);
      } else {
        System.out.println(
          "El movimiento es invalido, no puede salirse del laberinto"
        );
        initGame();
      }
    }
    if (action == 2) {
      if (positionP2X + 1 <= 9) {
        int newPositionP2X = positionP2X + 1;
        this.board.insertNewValue(p2.getposRow(), p2.getposCol(), "0");
        p1.setposRow(newPositionP2X);
      } else {
        System.out.println(
          "El movimiento es invalido, no puede salirse del laberinto"
        );
        initGame();
      }
    }
    if (action == 3) {
      if (positionP2Y + 1 <= 9) {
        int newPositionP2Y = positionP2Y + 1;
        this.board.insertNewValue(p2.getposRow(), p2.getposCol(), "0");
        p1.setposRow(newPositionP2Y);
      } else {
        System.out.println(
          "El movimiento es invalido, no puede salirse del laberinto"
        );
        initGame();
      }
    }
    if (action == 4) {
      if (positionP2Y - 1 >= 0) {
        int newPositionP2Y = positionP2Y - 1;
        this.board.insertNewValue(p2.getposRow(), p2.getposCol(), "0");
        p1.setposRow(newPositionP2Y);
      } else {
        System.out.println(
          "El movimiento es invalido, no puede salirse del laberinto"
        );
        initGame();
      }
    }

    this.board.insertNewValue(p2.getposRow(), p2.getposCol(), "W");
  }

  public void askQuestion(int number){
    System.out.println(newQuestion.getQuestion(number).question);
    System.out.println(newQuestion.getQuestion(number).answerOne);
    System.out.println(newQuestion.getQuestion(number).answerTwo);
    System.out.println(newQuestion.getQuestion(number).answerThree);
  }

  public boolean validateAnswer(String answer, int numberofQuestion){
    return answer==newQuestion.getQuestion(numberofQuestion).correctAnswer;
  }
}
