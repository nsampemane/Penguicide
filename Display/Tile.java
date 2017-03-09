package Display;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;


public class Tile extends JComponent{
    int width;
    Color c;
    public Tile(int width,int x,int y,Color c) { //must be square
        super();
       
        this.width = width;

        setVisible(true);
        this.c =c;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(c);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    public void set(int ID){

    }
    public Dimension getPreferredSize() {
        return new Dimension(this.width,this.width);
    }
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

}
