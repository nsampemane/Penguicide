package utilities;


public class FlatArrayTools {
    private int columns;
    private int rows;
    private static final int[][] DIRECT_DIRECTIONS = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; //column,row modifier format
    private static final int[][] ALL_DIRECTIONS = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}}; //column,row modifier format

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

    public int getDownRightIndex(int index) {  return getDirection(index, 1, 1);}

    public int getDownLeftIndex(int index) {
        return getDirection(index, -1, 1);
    }

    public int[] getDirectAdjacencies(int index) { //get direct adjacencies without errors
        return removeErrors(getForcedDirectAdjacencies(index));
    }

    public int[] getAllAdjacencies(int index) { //get all adjacencies without errors
        return removeErrors(getForcedAllAdjacencies(index));
    }

    private int[] removeErrors(int[] withErrors) { //filters out negatives (errors)
        int errors = 0;
        for (int item : withErrors) if (item < 0) errors++; //count -1's in array
        if (errors == 0) return withErrors;
        int[] out = new int[withErrors.length - errors];
        int index = 0;
        for (int item : withErrors) {
            if (item >= 0) {
                out[index] = item;
                index++;
            }
        }
        return out;
    }

    private int getDirection(int index, int columnModifier, int rowModifier) {
        if (!inRange(index)) throw new IndexOutOfBoundsException();
        int column = getIndexColumn(index) + columnModifier;
        int row = getIndexRow(index) + rowModifier;
        if (!inRange(column, row)) throw new IndexOutOfBoundsException();
        return getFlatIndex(column, row);
    }


    private int[] getForcedDirectAdjacencies(int index) {
        int[] preArray = new int[4];
        for (int i = 0; i < 4; i++) {
            try {
                preArray[i] = getDirection(index, DIRECT_DIRECTIONS[i][0], DIRECT_DIRECTIONS[i][1]);
            } catch (IndexOutOfBoundsException DNE) {
                preArray[i] = -1;
            }
        }
        return preArray;
    }

    private int[] getForcedAllAdjacencies(int index) {
        int[] preArray = new int[8];
        for (int i = 0; i < 8; i++) {
            try {
                preArray[i] = getDirection(index, ALL_DIRECTIONS[i][0], ALL_DIRECTIONS[i][1]);
            } catch (IndexOutOfBoundsException DNE) {
                preArray[i] = -1;
            }
        }
        return preArray;

    }
}
