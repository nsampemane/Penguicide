package Utilities;

/**
 * Created by neels on 2017-03-08.
 */
public class FlatArrayTools {
    private int columns;
    private int rows;

    public FlatArrayTools(int columns, int rows) {
         this.columns = columns;
         this.rows = rows;
    }

    public int getColumnIndex(int index){ //gets Column index in row major order
        return index % columns;
    }
    public int getRowIndex(int index){ //gets Row index in row major order
        return index/this.columns;
    }

    public int getFlatIndex(int column, int row){
        return row * this.columns + column; //gets Flattened index in row major order
    }
}
