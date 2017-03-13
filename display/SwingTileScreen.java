package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import utilities.FlatArrayTools;

public class SwingTileScreen extends JFrame implements TileScreen{
    private Tile[] tiles; //stores
    private int columns;
    private int rows;
    private int width;
    private FlatArrayTools tools;
    private SpriteSheet materials;
    private SpriteSheet mobs;


    public SwingTileScreen(String title, int columns, int rows, int width) throws java.io.IOException {
        super(title);
        this.setLayout(new GridLayout(rows, columns,0,0));
        this.tiles = new Tile[columns * rows];
        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.tools = new FlatArrayTools(this.columns, this.rows);
        this.materials = new SpriteSheet("resources\\materials.png", 16, 16, 8);
        this.mobs = new SpriteSheet("resources\\mobs.png", 16, 16, 8);

        for (int index = 0; index < tiles.length; index++) {
            int column = tools.getIndexColumn(index);
            int row = tools.getIndexRow(index);
            Tile toInsert = new Tile(this.width, column * this.width, row * this.width, materials.getSprite(0));

            this.tiles[index] = toInsert;
            this.add(toInsert);
        }

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.setVisible(true);
        //this.setResizable(false);
        this.pack();
        //this.setSize(columns*width,rows*width); //prevents setResizable(false) from adding margins

    }

    public void setMaterial(int tileIndex, int sheetIndex) {
        this.tiles[tileIndex].setMaterial(materials.getSprite(sheetIndex));
    }

    public void setMob(int tileIndex, int sheetIndex) {
        this.tiles[tileIndex].setMob(mobs.getSprite(sheetIndex));
    }


    public void refresh() {
        this.validate();
        this.repaint();
    }



}