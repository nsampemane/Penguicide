package Display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
//import java.awt.event.*;
import Utilities.FlatArrayTools;

public class TileScreen extends JFrame {
    private Tile[] tiles; //stores
    private int columns;
    private int rows;
    private int width;
    private FlatArrayTools tools;
    private SpriteSheet materials;


    public TileScreen(String title, int columns, int rows, int width) throws java.io.IOException {
        super(title);
        this.setLayout(new GridLayout(rows, columns));
        this.tiles = new Tile[columns * rows];
        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.tools = new FlatArrayTools(this.columns,this.rows);
        this.materials = new SpriteSheet("materials.png",16,16,8);

        for (int index = 0; index < tiles.length; index++) {
            int column = tools.getIndexColumn(index);
            int row = tools.getIndexRow(index);
            Tile toInsert = new Tile(this.width, column * this.width, row * this.width, materials.getSprite( index));
            this.tiles[index] = toInsert;
            this.add(toInsert);
        }

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    public void setMaterial(int tileIndex,int sheetIndex){
        this.tiles[tileIndex].setImage(materials.getSprite(sheetIndex));
    }

    public void refresh() {
        this.validate();
        this.repaint();
    }

}