package Display;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;

public class Screen extends JFrame {

    public static void main(String args[]) {
        new Screen();
    }

    public Screen() {
        //Title our frame.
        super("Render Test");

        //Set the size for the frame.
        setSize(800, 800);

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


    public void paint(Graphics g) {
        for (int i = 0; i<8;i++){
            for (int j = 0; j<8;j++){
                g.setColor(Color.red);
                g.drawRect(i * 100, j*100, 100, 100);
            }
        }




    }
}