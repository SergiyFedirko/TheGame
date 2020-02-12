package data;

import app.Settings;
import java.util.Random;

public class Board extends AbstractMatrix {

    public Board() {
        super();
        tab = new int[Settings.SIZE][Settings.SIZE];
    }

    public Board(int rows, int cols) {

        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Złe wymiary macierzy");
        }

        tab = new int[rows][cols];

    }

    public void setElemet(int value, int row, int col) {
//        checkParams(row, col);
        row = checkParamRow(row);
        col = checkParamCol(col);
        tab[row][col] = value;
    }

//     private void checkParams(int row, int col) throws IllegalArgumentException {
//        if (row < 0 || row >= getRowCount()) {
//            throw new IllegalArgumentException("Zły indeks wiersza");
//        }
//
//        if (col < 0 || col >= getColCount()) {
//            throw new IllegalArgumentException("Zła ilosc k0olumn");
//        }
//     }
    public int checkParamRow(int row) {
        if (row < 0 || row >= getRowCount()) {
            if (row < 0) {
                row = row - 1;
            }
            if (row >= getRowCount()) {
                row = row + 1;
            }
        }
        return row;
    }

    public int checkParamCol(int col) {
        if (col < 0 || col >= getColCount()) {
            if (col < 0 || col >= getColCount()) {
                if (col < 0) {
                    col++;
                }
                if (col > getRowCount()) {
                    col--;
                }
            }
        }
        return col;
    }

    @Override
    public int getRowCount() {
        return tab.length;

    }

    @Override
    public int getColCount() {
        return tab[0].length;
    }

    public void randomElements() {
        randomElements(1, 5);
    }

    public void randomElements(int from, int to) {
        Random rand = new Random();
        for (int i = 0, n = getRowCount(); i < n; i++) {
            for (int j = 0, m = getColCount(); j < m; j++) {
                tab[i][j] = (rand.nextInt(Integer.MAX_VALUE)) % (to - from + 1) + from;
            }

        }
        System.out.println(this);
    }

    public int randomElement(int from, int to) {
        Random rand = new Random();

        return (rand.nextInt(Integer.MAX_VALUE)) % (to - from + 1) + from;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = getRowCount(); i < n; i++) {
            for (int j = 0, m = getColCount(); j < m; j++) {
                sb.append(tab[i][j]).append(" ");
            }
            sb.append("\n");

        }
        return sb.toString();
    }
}
