package generation;
import utilities.FlatArrayTools;
import java.util.Random;

public class CellularAutomata {
    private int columns;
    private int rows;
    private FlatArrayTools tools;
    private Random generator;


    private boolean[] grid;
    private int neighborsToSurvive;
    private int neighborsToBeBorn;

    public CellularAutomata(int columns, int rows, int neighborsToSurvive, int neighborsToBeBorn, double initialProbability) {
        this.columns = columns;
        this.rows = rows;
        tools = new FlatArrayTools(columns, rows);
        generator = new Random();
        grid = new boolean[columns*rows];
        for (int i = 0;i<grid.length;i++){
            grid[i] = generator.nextDouble()<=initialProbability;
        }
        this.neighborsToBeBorn = neighborsToBeBorn;
        this.neighborsToSurvive = neighborsToSurvive;


    }

    public boolean[] getGrid() {
        return grid;
    }

    public void doCycle(){
        boolean[] newGrid = new boolean[grid.length];
        for (int index = 0;index<grid.length;index++){
            if (grid[index]){// if cell is alive
                    newGrid[index] = getLivingNeighbors(index) >= neighborsToSurvive;
            }
            else{
                newGrid[index] = getLivingNeighbors(index) >=neighborsToBeBorn;
            }

        }
        this.grid = newGrid;


    }

    public void doCycles(int times){
        while (times>0){
            doCycle();
            times--;
        }
    }

    private int getLivingNeighbors(int index){ //counts living neighbors or nonexistent tiles
        int count = 0;
        int [] AdjacentIndices = tools.getForcedAllAdjacencies(index);
        for (int adjacentIndex : AdjacentIndices){
            if (adjacentIndex <=0){ //count borders as living
                count++;
            }
            else if (grid[adjacentIndex]) count++;
        }
        return count;
    }




}
