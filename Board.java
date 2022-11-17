import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    private String [][] labyrinth;
    //private String [] questions;
    Board(){
        
        labyrinth = new String[][]{  
                {"0","X","X","X","X","X","X","X","X","W"},
                {"0","X","X","X","X","0","X","X","X","0"},
                {"0","X","0","0","0","0","X","X","X","0"},
                {"0","X","0","X","0","0","0","0","0","0"},
                {"0","0","0","X","X","0","X","X","X","0"},
                {"0","X","X","X","X","0","0","0","X","0"},
                {"0","0","0","X","X","0","X","X","X","0"},
                {"0","X","X","X","X","0","0","0","0","0"},
                {"0","X","0","0","0","0","X","0","X","0"},
                {"M","0","0","X","0","0","X","X","X","X"},
                                };
    }
    public ArrayList<Position> positionFree(){
        ArrayList<Position> free = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(labyrinth[i][j]=="0"){
                    free.add(new Position(i,j));
                }
            }
        }
        return free;
    }
    public void initializateEnemy(){
        ArrayList<Position> free = positionFree();
        for (int i = 0; i < 6; i++) {
            int positionRamdon = (int)(Math.random()*free.size());
            int auxX= free.get(positionRamdon).x;
            int auxY=free.get(positionRamdon).y;
            labyrinth[auxX][auxY] = "E";
        }
    }
    public void printBoard(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(labyrinth[i][j] == "X"){ //WALL
                    System.out.print("■  ");
                }else{
                    if(labyrinth[i][j]=="W"){
                        System.out.print("W  ");                        
                    }else{
                        if(labyrinth[i][j]=="M"){
                            System.out.print("M  "); 
                        }else{
                            System.out.print("*  ");
                        }
                    }
                }
                //System.out.print(" ");
            }
            System.out.println();
        }
    }

    public String valueBox(int posRow, int posCol){
        return labyrinth[posRow][posCol];
    }

    public void printSecretBoard(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("■");
            }
            System.out.println();
        }
    }

    public void insertNewValue(int col, int row, String newValue){
        labyrinth[row][col] = newValue;
    }
}
