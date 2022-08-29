package Simulation;


import Util.Pair;

/**
 * This cell is dead and does nothing
 */
public class DeadCell extends Cell{
    /*public DeadCell(int x, int y){
        super(0, x, y, 0);
    }*/
    public DeadCell(Pair coords){
        super(0,coords.getX(),coords.getY(),0);
    }
}
