package Utilities;

public class FlatArrayTools {
    private int columns;
    private int rows;

    public FlatArrayTools(int columns, int rows) {
         this.columns = columns;
         this.rows = rows;
    }

    public int getIndexColumn(int index){ //gets Column index in row major order
        return index % columns;
    }
    public int getIndexRow(int index){ //gets Row index in row major order
        return index/this.columns;
    }

    public int intgetFlatIndex(int column, int row){
        return row * this.columns + column; //gets Flattened index in row major order
    }
}
