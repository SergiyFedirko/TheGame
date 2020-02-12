/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author student
 */
public class AbstractMatrix {

    protected int[][] tab;

    protected AbstractMatrix() {
    }

    public void setElement(int row, int col, int value) {
        //checkParams(row, col);
        row = checkParamRow(row);
        col = checkParamCol(col);
        tab[row][col] = value;
    }

    public int getElement(int row, int col) {
//        checkParams(row, col);
        row = checkParamRow(row);
        col = checkParamCol(col);
        return tab[row][col];
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

    public int getRowCount() {
        return tab.length;
    }

    public int getColCount() {
        return tab[0].length;
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
