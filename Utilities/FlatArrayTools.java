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
    public int getFlatIndex(int column, int row){
        return row * this.columns + column; //gets Flattened index in row major order
    }

    public boolean inRange(int column,int row){
        if(column <0 || row < 0){ return false;}
        if(column >=columns||row>=rows){return false;}
        return true;
    }

    public boolean inRange(int index){
        if(index<0){ return false;}
        if(index>=(rows*columns)) return false;
        return true;
    }
    /*
    public int getAboveIndex(int index){


    }*/
}
