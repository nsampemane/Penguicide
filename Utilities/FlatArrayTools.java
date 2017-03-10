package Utilities;
import java.util.function.Function;

public class FlatArrayTools {
    private int columns;
    private int rows;

    public FlatArrayTools(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public int getIndexColumn(int index) { //gets Column index in row major order
        return index % columns;
    }

    public int getIndexRow(int index) { //gets Row index in row major order
        return index / this.columns;
    }

    public int intgetFlatIndex(int column, int row) {
        return row * this.columns + column; //gets Flattened index in row major order
    }

    public int getFlatIndex(int column, int row) {
        return row * this.columns + column; //gets Flattened index in row major order
    }

    public boolean inRange(int column, int row) {
        if (column < 0 || row < 0) {
            return false;
        }
        if (column >= columns || row >= rows) {
            return false;
        }
        return true;
    }

    public boolean inRange(int index) {
        if (index < 0) {
            return false;
        }
        if (index >= (rows * columns)) return false;
        return true;
    }


    public int getUpIndex(int index) {
        return getDirection(index, 0, -1);
    }

    public int getDownIndex(int index) {
        return getDirection(index, 0, 1);
    }

    public int getRightIndex(int index) {
        return getDirection(index, 1, 0);
    }

    public int getLeftIndex(int index) {
        return getDirection(index, -1, 0);
    }

    public int getUpRightIndex(int index) {
        return getDirection(index, 1, -1);
    }

    public int getUpLeftIndex(int index) {
        return getDirection(index, -1, -1);
    }
    public int getDownRightIndex(int index) {
        return getDirection(index, 1, 1);
    }

    public int getDownLeftIndex(int index) {
        return getDirection(index, -1, 1);
    }
    private int getDirection(int index, int columnModifier, int rowModifier){
        if (!inRange(index)) throw new IndexOutOfBoundsException();
        int column = getIndexColumn(index) + columnModifier;
        int row = getIndexRow(index) + rowModifier;
        if (!inRange(column, row)) throw new IndexOutOfBoundsException();
        return getFlatIndex(column, row);
    }

    //TODO: rewrite with function pointers or at least less horribly

    private int[] getForcedDirectAdjacencies(int index) {
        int[] prearray = new int[4];
        try {
            prearray[0] = getUpIndex(index);
        } catch (IndexOutOfBoundsException DNE) {
            prearray[0] = -1;
        }
        try {
            prearray[1] = getRightIndex(index);
        } catch (IndexOutOfBoundsException DNE) {
            prearray[1] = -1;
        }
        try{
            prearray[2] = getDownIndex(index);
        }
        catch (IndexOutOfBoundsException DNE){
            prearray[2] = -1;
        }
        try{
            prearray[3] = getLeftIndex(index);
        }
        catch (IndexOutOfBoundsException DNE){
            prearray[3] = -1;
        }
        return prearray;
    }

    private int[] getForcedAllAdjacencies(int index) {
        int[] prearray = new int[8];
        try {
            prearray[0] = getUpIndex(index);
        } catch (IndexOutOfBoundsException DNE) {
            prearray[0] = -1;
        }
        try {
            prearray[1] = getUpRightIndex(index);
        } catch (IndexOutOfBoundsException DNE) {
            prearray[1] = -1;
        }
        try {
            prearray[2] = getRightIndex(index);
        } catch (IndexOutOfBoundsException DNE) {
            prearray[2] = -1;
        }
        try {
            prearray[3] = getDownRightIndex(index);
        } catch (IndexOutOfBoundsException DNE) {
            prearray[3] = -1;
        }
        try{
            prearray[4] = getDownIndex(index);
        }
        catch (IndexOutOfBoundsException DNE){
            prearray[4] = -1;
        }
        try{
            prearray[5] = getDownLeftIndex(index);
        }
        catch (IndexOutOfBoundsException DNE){
            prearray[5] = -1;
        }
        try{
            prearray[6] = getLeftIndex(index);
        }
        catch (IndexOutOfBoundsException DNE){
            prearray[6] = -1;
        }
        try{
            prearray[7] = getUpLeftIndex(index);
        }
        catch (IndexOutOfBoundsException DNE){
            prearray[7] = -1;
        }
        return prearray;
    }

    public int[] getDirectAdjacencies(int index){ //get direct adjacencies without errors
       return removeErrors(getForcedDirectAdjacencies(index));
    }
    public int[] getAllAdjacencies(int index){ //get direct adjacencies without errors
        return removeErrors(getForcedAllAdjacencies(index));
    }

    private int[] removeErrors(int[] withErrors){
        int errors = 0;
        for (int item: withErrors) if(item<0) errors++; //count -1's in array
        if (errors==0) return withErrors;
        int[] out = new int[withErrors.length-errors];
        int index = 0;
        for (int item: withErrors){
            if(item>=0){
                out[index] = item;
                index++;
            }
        }
        return out;
    }
}
