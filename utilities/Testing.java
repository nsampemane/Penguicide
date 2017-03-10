package utilities;
import java.util.Arrays;


import display.TileScreen;

public class Testing {
    public static  void main(String[] args) throws java.io.IOException{

        TileScreen x = new TileScreen("Penguicide", 20, 20, 64);
        FlatArrayTools tools = new FlatArrayTools(3,3);
        System.out.println(Arrays.toString(tools.getDirectAdjacencies(4)));

    }

}
