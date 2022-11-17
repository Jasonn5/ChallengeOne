public class Player {
    private int posRow;
    private int posCol;

    Player(int row,int col){
        posRow=row;
        posCol=col;
    }

    // Methods
    public int getposRow(){ return posRow; }
    public int getposCol(){ return posCol; }
    public void setposRow(int row){ posRow=row;}
    public void setposCol(int col){ posCol=col;}

    public void printPosition(){
        System.out.println("Row: " + posRow + "Column: " + posCol );
    }

    public void resetPosition(int row, int col){
        posRow = row;
        posCol = col;
    }

}
