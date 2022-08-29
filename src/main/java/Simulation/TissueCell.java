package Simulation;


import Util.Calculator;
import Util.Pair;

import java.util.ArrayList;

import static Util.Calculator.indexFromCoord;

/**
 * A tissue cell. It wants to grow, but not as much as cancer. Has a chance to turn a dead
 * cell into a live one every time step
 */

public class TissueCell extends Cell {

    /*public TissueCell(int x, int y) {
        super(0, x, y, 1);
    }*/

    public TissueCell(Pair coords) {
        super(0, coords.getX(), coords.getY(), 1);
    }

    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors) {
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
        for (int index = 0, DCcount = 0; index < actualneighbors.size(); index++) {
            int id = actualneighbors.get(index).getID();
            if (id == 0 && DCcount < 1) {
                double rangeNum = Math.random()*10;
                if (rangeNum >= 3){
                Pair bob = new Pair(actualneighbors.get(index).getX(), actualneighbors.get(index).getY());
                neighbors.set(indexFromCoord(bob), new TissueCell(bob));
                actualneighbors.set(index, new TissueCell(bob));
                DCcount += 1;
                }
            }
        }
    }
}
