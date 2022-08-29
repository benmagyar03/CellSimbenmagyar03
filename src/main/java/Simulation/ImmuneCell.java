package Simulation;

import Util.Calculator;
import Util.Pair;

import java.util.ArrayList;

import static Util.Calculator.indexFromCoord;

/**
 * The immune cell! It kills cancer, and has a chance to attack multiple cancer cells per turn!
 */

public class ImmuneCell extends Cell{
    /*public ImmuneCell(int x, int y){
        super(3, x, y, 4);
    }*/
    public ImmuneCell(Pair coords) {
        super(3, coords.getX(), coords.getY(), 4);
    }
    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors){
        int x = getX();
        int y = getY();
        ArrayList<Cell> actualneighbors = new ArrayList<>();
        for (int xi = -1; xi < 2; xi++) {
            for (int yi = -1; yi < 2; yi++) {
                int ni = Calculator.indexFromCoord(x + xi, y + yi);
                if ( ni >= 0 && xi != 0 && yi == 0 || ni >= 0 && yi != 0 && xi == 0 || ni >= 0 && yi !=0 && xi != 0){
                    Cell newie = neighbors.get(ni);
                    actualneighbors.add(newie);
                }
            }
        }
        for (int index = 0, CCcount = 0; index < actualneighbors.size(); index++) {
            int id = actualneighbors.get(index).getID();
            if (id == 3 && CCcount < 1) {
                Pair bob = new Pair(actualneighbors.get(index).getX(), actualneighbors.get(index).getY());
                neighbors.set(indexFromCoord(bob), new DeadCell(bob));
                actualneighbors.set(index, new DeadCell(bob));
                CCcount += 1;
            }
            }
    }
}