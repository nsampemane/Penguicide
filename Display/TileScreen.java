package Display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
//import java.awt.event.*;
import Utilities.FlatArrayTools;
import javax.imageio.ImageIO;
import java.io.File;

public class TileScreen extends JFrame {
    private Tile[] tiles; //stores
    private int columns;
    private int rows;
    private int width;
    private FlatArrayTools tools;
    private SpriteSheet TileImages;

    public static void main(String args[]) throws java.io.IOException{
        new TileScreen("Penguicide",10,10,100);
    }

    public TileScreen(String title, int columns, int rows, int width) throws java.io.IOException {
        super(title);
        this.setLayout(new GridLayout(rows,columns));
        this.tiles = new Tile[columns * rows];
        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.tools = new FlatArrayTools(columns, rows);
        TileImages = new SpriteSheet("snowtest.png");


       for (int index = 0; index <tiles.length;index++){
           int column = tools.getIndexColumn(index);
            int row = tools.getIndexRow(index);

            Tile toInsert = new Tile(this.width,column * this.width, row * this.width,TileImages.getImage());
            this.tiles[index] = toInsert;
            this.add(toInsert);



        }


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();



        this.setVisible(true);
       // setResizable(false);
        //Now, we want to be sure we properly dispose of resources
        //this frame is using when the window is closed.  We use
        //an anonymous inner class adapter for this.
     /*   addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  dispose();
                                  System.exit(0);
                              }
                          }
        );
    }




   public void paint(Graphics g) {
        for (int i = 0; i<8;i++){
            for (int j = 0; j<8;j++){
                g.setColor(Color.red);
                g.drawRect(i * 100, j*100, 100, 100);
            }
        }



 */
    }

}