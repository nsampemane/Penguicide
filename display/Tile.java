package display;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Tile extends JPanel {
    int width;

    BufferedImage material;
    BufferedImage mob;

    public Tile(int width, int x, int y, BufferedImage material) { //must be square
        super();

        this.width = width;

        setVisible(true);

        this.material = material;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ((Graphics2D) g).drawImage(material, 0, 0, width, width, null);
        ((Graphics2D) g).drawImage(mob, 0, 0, width, width, null);

    }


    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.width);
    }

    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    public void setMaterial(BufferedImage img) {
        this.material = img;

    }

    public void setMob(BufferedImage img){
        this.mob = img;
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

}
