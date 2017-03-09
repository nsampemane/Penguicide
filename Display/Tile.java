package Display;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;

public class Tile extends JComponent{
    public Tile(int width,int x,int y,Color c){ //must be square
        super();
        setLocation(x,y);
        setSize(width, width);

        setBackground(c);
        setVisible(true);

    }
    public void set(int ID){

    }


}
