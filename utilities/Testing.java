package utilities;

import generation.CellularAutomata;


import display.*;


public class Testing {
    private final static int COLUMNS =54;
    private final static int ROWS =36;
    private final static int WIDTH = 24;

    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException{

        TileScreen x = new SwingTileScreen("Penguicide Test", COLUMNS, ROWS, WIDTH);
        //2,4,.25
        CellularAutomata cells = new CellularAutomata(COLUMNS, ROWS, 2, 4, .25);
        for (int z = 1; z < 4; z++) {
            for (int i = 0; i < COLUMNS * ROWS; i++) {

                int materialCode =  cells.getGrid()[i] ? 2 : 1;
                x.setMaterial(i, materialCode);
            }
            x.refresh();
            cells.doCycle();
            Thread.sleep(200);
            x.setMob(400,2);
        }

    }

}
