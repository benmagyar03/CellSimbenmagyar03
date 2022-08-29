package Simulation;


import Util.Calculator;
import Util.Pair;

import java.util.ArrayList;

import static Util.Calculator.indexFromCoord;

/**
 *This is a cancer cell. It is the most complex cell as it can attack tissue or immune cells, or grow into a dead cell.
 * For attacking tissue, it is a 1 hit replace it with a dead cell.
 * Immune cells are cooler. Each hit from a cancer cell lowers its strength by 1. When an immune cell reaches 0 strength
 * it dies!
 *
 * It has a priority of action. If it can grow, it will grow. If it can kill a tissue cell, it will do that. Why?
 * Easiest way to grow is to kill a week tissue cell. If no other option, will attack immune cells. Path of
 * least resistance to growing basically.
 *
 * Growing means turning a dead cell into a CancerCell.
 */

public class CancerCell extends Cell{
    public CancerCell(int x, int y){
        super(1, x, y, 3);
    }
    public CancerCell(Pair coords){
        super(1,coords.getX(),coords.getY(),3);
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
        int DCcount = 0;
        int TCcount = 0;
        int ICcount = 0;
        for (int index = 0; index < actualneighbors.size(); index++) {
            int id = actualneighbors.get(index).getID();
            if (id == 0 && DCcount < 1) {
                Pair bob = new Pair(actualneighbors.get(index).getX(), actualneighbors.get(index).getY());
                neighbors.set(indexFromCoord(bob), new CancerCell(bob));
                actualneighbors.set(index, new CancerCell(bob));
                DCcount += 1;
                }
            else if (id == 1){
                TCcount += 1;
            }
            else if (id == 4) {
                ICcount += 1;
            }
        }
        if (DCcount == 0 && TCcount > ICcount) {
            for (int index = 0; index < actualneighbors.size(); index++) {
                int id = actualneighbors.get(index).getID();
                if (id == 1 && DCcount < 1) {
                    Pair bob = new Pair(actualneighbors.get(index).getX(), actualneighbors.get(index).getY());
                    neighbors.set(indexFromCoord(bob), new DeadCell(bob));
                    actualneighbors.set(index, new DeadCell(bob));
                    DCcount += 1;
                }
        }
        }
        else if (DCcount == 0 && TCcount < ICcount){
            for (int index = 0; index < actualneighbors.size(); index++) {
                int id = actualneighbors.get(index).getID();
                if (id == 4) {
                    int CurrentStrength = neighbors.get(index).getStrength();
                    neighbors.get(index).setStrength(CurrentStrength -1);
                    if (CurrentStrength == 0){
                        Pair bob = new Pair(actualneighbors.get(index).getX(), actualneighbors.get(index).getY());
                        neighbors.set(indexFromCoord(bob), new DeadCell(bob));
                        actualneighbors.set(index, new DeadCell(bob));
                    }
                }
            }
        }
    }
}
