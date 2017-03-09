package Display;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Tile extends JPanel{
    int width;

    BufferedImage img;

    public Tile(int width,int x,int y, BufferedImage img) { //must be square
        super();

        this.width = width;

        setVisible(true);

        this.img = img;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ((Graphics2D) g).drawImage(img,0,0,100,100,null);

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
