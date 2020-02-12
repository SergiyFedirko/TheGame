/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import data.Board;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author student
 */
public class MatrixPanel extends JPanel {

    private Board matrix;

    public MatrixPanel(Board matrix) {
        this.matrix = matrix;
    }

    public Board getMatrix() {
        return matrix;
    }

    public void setMatrix(Board matrix) {
        this.matrix = matrix;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int size = 30;
        for (int i = 0, n = matrix.getRowCount(); i < n; i++) {
            for (int j = 0, m = matrix.getColCount(); j < m; j++) {

                if (matrix.getElement(i, j) == 1) {
                    g.setColor(Color.GREEN);
                    g.fillRect(j * size, i * size, size, size);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
                }
                if (matrix.getElement(i, j) == 2) {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * size, i * size, size, size);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
                }
                if (matrix.getElement(i, j) == 3) {
                    g.setColor(Color.CYAN);
                    g.fillRect(j * size, i * size, size, size);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
                }
                if (matrix.getElement(i, j) == 4) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(j * size, i * size, size, size);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
                }
                if (matrix.getElement(i, j) == 5) {
                    g.setColor(Color.MAGENTA);
                    g.fillRect(j * size, i * size, size, size);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
                }
                if (matrix.getElement(i, j) == 6) {
                    
                    g.setColor(Color.GREEN.darker());
                    g.fillRect(j * size, i * size, size, size);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
                }
                if (matrix.getElement(i, j) == 7) {
                    g.setColor(Color.BLUE.darker());
                    g.fillRect(j * size, i * size, size, size);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
                }
                if (matrix.getElement(i, j) == 8) {
                    g.setColor(Color.CYAN.darker());
                    g.fillRect(j * size, i * size, size, size);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
                }
                if (matrix.getElement(i, j) == 9) {
                    g.setColor(Color.YELLOW.darker());
                    g.fillRect(j * size, i * size, size, size);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
                }
                if (matrix.getElement(i, j) == 10) {
                    g.setColor(Color.MAGENTA.darker());
                    g.fillRect(j * size, i * size, size, size);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * size, i * size, size, size);
                }
            }
        }

    }
}
