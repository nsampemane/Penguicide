package utilities;

import java.util.Arrays;

import generation.CellularAutomata;


import display.TileScreen;


public class Testing {
    private final static int COLUMNS = 10;
    private final static int ROWS = 10;

    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException{

        TileScreen x = new TileScreen("Penguicide Test", COLUMNS, ROWS, 64);
        CellularAutomata cells = new CellularAutomata(COLUMNS, ROWS, 3, 6, .5);
        for (int z = 1; z < 10; z++) {
            for (int i = 0; i < COLUMNS * ROWS; i++) {

                int materialCode =  cells.getGrid()[i] ? 3 : 1;
                x.setMaterial(i, materialCode);
            }
            x.refresh();
            cells.doCycle();
            Thread.sleep(2000);
            x.setMob(45,1);
        }

    }

}
