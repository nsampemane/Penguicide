package Display;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import Utilities.FlatArrayTools;

public class TileScreen extends JFrame {
    private Tile[] tiles; //stores
    private int columns;
    private int rows;
    private int width;
    private FlatArrayTools tools;
    private SpriteSheet TileImages;

    public static void main(String args[]) throws java.io.IOException {

        TileScreen x = new TileScreen("Penguicide", 10, 10, 64);

    }

    public TileScreen(String title, int columns, int rows, int width) throws java.io.IOException {
        super(title);
        this.setLayout(new GridLayout(rows, columns));
        this.tiles = new Tile[columns * rows];
        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.tools = new FlatArrayTools(columns, rows);
        this.TileImages = new SpriteSheet("materials.png",columns,rows,8);

        for (int index = 0; index < tiles.length; index++) {
            int column = tools.getIndexColumn(index);
            int row = tools.getIndexRow(index);
            Tile toInsert = new Tile(this.width, column * this.width, row * this.width, TileImages.getSprite(index ));
            this.tiles[index] = toInsert;
            this.add(toInsert);
        }

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    public void refresh() {
        this.validate();
        this.repaint();
    }

}