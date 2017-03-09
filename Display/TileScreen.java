package Display;

import javax.swing.JFrame;
import java.awt.event.*;
import Utilities.;

public class TileScreen extends JFrame {
    private Tile[] tiles; //stores
    private int columns;
    private int rows;
    private int width;
    private FlatArrayTools tools;


    public static void main(String args[]) {
        new TileScreen("Penguicide",10,10,8);
    }

    public TileScreen(String title, int columns, int rows, int width) {
        super(title);
        this.tiles = new Tile[columns * rows];
        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.tools = new FlatArrayTools(columns, rows);


        for (int index = 0; index <tiles.length;index++){
            int column = tools.getColumnIndex(index);
            int row = tools.getRowIndex(index);


        }


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