package utilities;

import java.util.Arrays;

import generation.CellularAutomata;


import display.TileScreen;


public class Testing {
    private final static int COLUMNS = 20;
    private final static int ROWS = 20;

    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException{

        TileScreen x = new TileScreen("Penguicide", COLUMNS, ROWS, 32);
        CellularAutomata cells = new CellularAutomata(COLUMNS, ROWS, 4, 5, .45);
        for (int z = 1; z < 10; z++) {
            for (int i = 0; i < COLUMNS * ROWS; i++) {

                int materialCode =  cells.getGrid()[i] ? 1 : 0;
                x.setMaterial(i, materialCode);
            }
            x.refresh();
            cells.doCycle();
            Thread.sleep(3000);
        }

    }

}
