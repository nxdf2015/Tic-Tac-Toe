package tictactoe;


public class Grid {

    private String grid;

    public Grid(String init) {
        this.grid = init;
    }

    public boolean finish(){
        return find(grid,'_') == 0;
    }

    public String[] rows(){
        String[] data = new String[3];
        for(int i = 0; i < 3; i++){
            data[i] = grid.substring(i * 3, (i + 1) * 3);
        }
        return data;
    }

    public String[] columns(){
        String[] data = new String[3];
        for(int i = 0; i < 3; i++){
            data[i] = "" + grid.charAt(i) + grid.charAt(i + 3) +  grid.charAt(i + 6);
        }
        return data;
    }

    public String[] diag(){
        String[] data = new String[2];
        data[0] = "" + grid.charAt(0) + grid.charAt(4) + grid.charAt(8);
        data[1] = "" + grid.charAt(2) + grid.charAt(4) + grid.charAt(6);
        return data;
    }

    public boolean win(String player){
        String wPlayer = player.repeat(3);
        for(String row : rows()){
            if (row.equals(wPlayer)){
                return true;
            }
        }
        for(String row : columns()){
            if (row.equals(wPlayer)){
                return true;
            }
        }
        for(String row : diag()){
            if (row.equals(wPlayer)){
                return true;
            }
        }
        return false;
    }

    public boolean drawn() {
        return win("X") && win("O") || (Math.abs(find(grid,'X') - find(grid,'O'))) >= 2;
    }

    public String getStatus(){
        if (drawn()){
            return "Impossible";
        } else if(win("X")){
            return "X wins";
        } else if(win("O")){
            return "O wins";
        } else if (finish()){
            return "Draw";
        }
        return "Game not finished";
    }

    public int find(String s, char c){
        int id = -1;
        int count = 0;
        do{
            id = s.indexOf(c, id + 1);
            if (id != -1) {
                count++;
            }
        }while(id != -1);
        return count;
    }

    public boolean cellIsEmpty(int row, int col){
        row = changeOrigine(row);
        col -= 1;
        return grid.charAt(row * 3 + col) == '_';
    }

    public void play(int row, int col,String player){
        row = changeOrigine(row);
        col -= 1;

        grid = grid.substring(0, row * 3 + col) + player + grid.substring(row * 3 + col + 1);
    }

    public boolean isValidPosition(int row,int col){
        return inRange(row) && inRange(col);
    }

    private boolean inRange(int i){
        return i > 0 && i <= 3;
    }

    private int  changeOrigine(int pos){
        return 3 - pos;
    }

    @Override
    public String toString() {
        String head = "-".repeat(9);
        String result = head + System.lineSeparator();
        for(int i = 0; i < 3; i++){
            String line = String.format("| %c %c %c |", grid.charAt(3 * i), grid.charAt(3 * i + 1), grid.charAt(3 *i +2));
            result += line + System.lineSeparator();

        }
        result += head;
        return result;
    }
}
