package Display;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;

public class Screen extends JFrame {
    Tile[] tiles;
    int columns;
    int rows;
    int width;

    public static void main(String args[]) {
        new Screen("Penguicide",10,10,8);
    }

    public Screen(String title, int columns, int rows, int width) {
        super(title);
        this.tiles = new Tile[columns * rows];
        this.columns = columns;
        this.rows = rows;
        this.width = width;


        //Set the size for the frame.
        setSize(width * columns, width * rows);

        //We need to turn on the visibility of our frame
        //by setting the Visible parameter to true.
        setVisible(true);
        setResizable(false);
        //Now, we want to be sure we properly dispose of resources
        //this frame is using when the window is closed.  We use
        //an anonymous inner class adapter for this.
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  dispose();
                                  System.exit(0);
                              }
                          }
        );
    }

    private getColumnIndex(int index){

    }
    private getRowIndex(int index){

    }


   /* public void paint(Graphics g) {
        for (int i = 0; i<8;i++){
            for (int j = 0; j<8;j++){
                g.setColor(Color.red);
                g.drawRect(i * 100, j*100, 100, 100);
            }
        }




    }
    */
}