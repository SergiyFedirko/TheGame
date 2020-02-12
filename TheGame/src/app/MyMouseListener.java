/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import data.AbstractMatrix;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author student
 */
public class MyMouseListener implements MouseListener {

    private AbstractMatrix matrix;
    private int click;
    private int kolor;
    private int punkty = 0;
    private int clicks = 0;
    private int[][] tabXiY;

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getClicks() {
        return clicks;
    }

    public void setMatrix(AbstractMatrix matrix) {
        this.matrix = matrix;
    }
    private JPanel panel;

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public AbstractMatrix getMatrix() {
        return matrix;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {
            LeftButton(e);

        } else if (e.getButton() == MouseEvent.BUTTON3) {
            RightButton(e);
        }

        panel.repaint();
    }

    private void LeftButton(MouseEvent e) {
        click++;
        clicks++;
        if (click == 1) {
            tabXiY = new int[2][400];
            int row = e.getY() / 30;
            int col = e.getX() / 30;
            row = matrix.checkParamRow(row);
            col = matrix.checkParamCol(col);
            tabXiY[0][click] = row;
            tabXiY[1][click] = col;
            if (matrix.getElement(row, col) == 0) {
                click = 0;
            } else {
                kolor = matrix.getElement(row, col);
                matrix.setElement(row, col, kolor + 5);
            }
        } else {
            int row = e.getY() / 30;
            int col = e.getX() / 30;
            
            row = matrix.checkParamRow(row);
            col = matrix.checkParamCol(col);

            if ((row == tabXiY[0][click - 1] + 1 && col == tabXiY[1][click - 1])
                    || (row == tabXiY[0][click - 1] - 1 && col == tabXiY[1][click - 1])
                    || (col == tabXiY[1][click - 1] + 1 && row == tabXiY[0][click - 1]
                    || (col == tabXiY[1][click - 1] - 1 && row == tabXiY[0][click - 1]))) {

                if (matrix.getElement(row, col) == kolor) {
                    tabXiY[0][click] = row;
                    tabXiY[1][click] = col;

                    matrix.setElement(row, col, kolor + 5);

                } else if (matrix.getElement(row, col) == kolor + 5 && row == tabXiY[0][1] && col == tabXiY[1][1] && click > 3) {
                    MoreThree();
                } else {
                    click--;
                }

            } else if (matrix.getElement(row, col) == kolor + 5 && row == tabXiY[0][1] && col == tabXiY[1][1] && click > 3) {
                MoreThree();

            } else {
                click--;
            }
        }
    }

    private void RightButton(MouseEvent e) {
        //System.out.println("123");
        int row = e.getY() / 30;
        int col = e.getX() / 30;
        if (row == tabXiY[0][click] && col == tabXiY[1][click]) {
            if (matrix.getElement(row, col) == kolor + 5) {
                matrix.setElement(row, col, kolor);
                click--;
            }
        }
    }

    private void MoreThree() {
        for (int i = 0, n = matrix.getRowCount(); i < n; i++) {
            for (int j = 0, m = matrix.getColCount(); j < m; j++) {
                if (matrix.getElement(i, j) == kolor + 5) {
                    matrix.setElement(i, j, 0);
                }
            }
        }
        punkty += Math.round(((click - 2) * 3 / Math.pow(click, 3) * 1000));
        click = 0;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
