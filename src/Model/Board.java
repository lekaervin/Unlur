package src.Model;

public class Board {
    Cell [][] board;
    int size;
    int [] maxInd;

    public Board() {
        size = 6;
        board = new Cell[size*2-1][size*2-1];
        maxInd = new int[size*2-1];
        initilizeMaxInd();
        initilizeBoard();
    }

    private void initilizeMaxInd() {
        int ind = size;
        for (int i = 0; i < size-1; i++) {
            maxInd[i] = ind;
            maxInd[size*2-2-i] = ind;
            ind++;
        }
        maxInd[size-1] = size*2-1;
    }


        // Crée les cellules et initialise les voisins
    private void initilizeBoard() {
        for (int i = 0; i < size*2-1; i++) {
            for (int j = 0; j < maxInd[i]; j++) {
                Cell c = new Cell();
                board[i][j] = c;
            }
        }
        initilizeNeighbourgAndBorder();
    }

    private void initilizeNeighbourgAndBorder() {
        // Ligne du haut
        for (int j = 0; j < maxInd[0]; j++) {
            if (j == 0) {
                board[0][j].border += Cell.BORDER_TOP_LEFT;
            } else {
                board[0][j].neighbourgs[Cell.LEFT] = board[0][j-1];
            }
            if (j == maxInd[0]-1) {
                board[0][j].border += Cell.BORDER_TOP_RIGHT;
            } else {
                board[0][j].neighbourgs[Cell.RIGHT] = board[0][j+1];
            }
            board[0][j].border += Cell.BORDER_TOP;
            board[0][j].neighbourgs[Cell.BOTTOM_LEFT] = board[1][j];
            board[0][j].neighbourgs[Cell.BOTTOM_RIGHT] = board[1][j+1];
        }

        // Ligne milieu
        for (int j = 0; j < maxInd[size-1]; j++) {
            if (j == 0) {
                board[size-1][j].border += Cell.BORDER_TOP_LEFT;
                board[size-1][j].border += Cell.BORDER_BOTTOM_LEFT;
            } else {
                board[size-1][j].neighbourgs[Cell.TOP_LEFT] = board[size-2][j-1];
                board[size-1][j].neighbourgs[Cell.LEFT] = board[size-1][j-1];
                board[size-1][j].neighbourgs[Cell.BOTTOM_LEFT] = board[size][j-1];
            }
            if (j == size*2-2) {
                board[size-1][j].border += Cell.BORDER_TOP_RIGHT;
                board[size-1][j].border += Cell.BORDER_BOTTOM_RIGHT;
            } else {
                board[size-1][j].neighbourgs[Cell.TOP_RIGHT] = board[size-2][j];
                board[size-1][j].neighbourgs[Cell.RIGHT] = board[size-1][j+1];
                board[size-1][j].neighbourgs[Cell.BOTTOM_RIGHT] = board[size][j];
            }
        }

        // Ligne du bas
        for (int j = 0; j < maxInd[size*2-2]; j++) {
            if (j == 0) {
                board[size*2-2][j].border += Cell.BORDER_BOTTOM_LEFT;
            } else {
                board[size*2-2][j].neighbourgs[Cell.LEFT] = board[size*2-2][j-1];
            }
            if (j == maxInd[size*2-2]) {
                board[size*2-2][j].border += Cell.BORDER_BOTTOM_RIGHT;
            } else {
                board[size*2-2][j].neighbourgs[Cell.RIGHT] = board[size*2-2][j+1];
            }
            board[size*2-2][j].border += Cell.BORDER_BOTTOM;
            board[size*2-2][j].neighbourgs[Cell.TOP_LEFT] = board[1][j];
            board[size*2-2][j].neighbourgs[Cell.TOP_RIGHT] = board[1][j+1];
        }

        // Partie du haut
        for (int i = 1; i < size-2; i++) {
            for (int j = 0; j < maxInd[i]; j++) {
                if (j == 0) {
                    board[i][j].border += Cell.BORDER_TOP_LEFT;
                } else {
                    board[i][j].neighbourgs[Cell.TOP_LEFT] = board[i-1][j-1];
                    board[i][j].neighbourgs[Cell.LEFT] = board[i][j-1];
                }
                if (j == maxInd[i]-1) {
                    board[i][j].border += Cell.BORDER_TOP_RIGHT;
                } else {
                    board[i][j].neighbourgs[Cell.TOP_RIGHT] = board[i-1][j];
                    board[i][j].neighbourgs[Cell.RIGHT] = board[i][j+1];
                }
            }
        }

        // Partie du bas
        for (int i = size; i < size*2-2; i++) {
            for (int j = 0; j < maxInd[i]; j++) {
                if (j == 0) {
                    board[i][j].border += Cell.BORDER_BOTTOM_LEFT;
                } else {
                    board[i][j].neighbourgs[Cell.LEFT] = board[i][j-1];
                    board[i][j].neighbourgs[Cell.BOTTOM_LEFT] = board[i+1][j-1];
                }
                if (j == maxInd[i]-1) {
                    board[i][j].border += Cell.BORDER_BOTTOM_RIGHT;
                } else {
                    board[i][j].neighbourgs[Cell.RIGHT] = board[i][j+1];
                    board[i][j].neighbourgs[Cell.BOTTOM_RIGHT] = board[i+1][j];
                }
            }
        }
    }

    // Joue le coup donné
    public void play(int line, int column, Color color) {
        board[line][column].color = color;
    }

}
