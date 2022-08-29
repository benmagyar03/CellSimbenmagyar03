package Simulation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * The default, boring cell.
 */

public class Cell {
    private int strength;
    private int x;
    private int y;
    private int id;
    private ArrayList neighbors;
    private HashMap Concentrations;
    private HashSet Interactions;

    public void setStrength(int strength) {
        if (strength > 0) {
            this.strength = strength;
        } else {
            this.strength = 0;
        }
    }
    public int getStrength() {
        return this.strength;
    }

    public void setY(int y) {
        if (y > 0) {
            this.y = y;
        } else {
            this.y = 0;
        }
    }
    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        if (x > 0) {
            this.x = x;
        } else {
            this.x = 0;
        }
    }
    public int getX() {
        return this.x;
    }

    public void setID(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            this.id = 0;
        }
    }
    public int getID() {
        return this.id;
    }

    public void setConcentrations(String Chemical, int Amount){
        Concentrations.put(Chemical,Amount);
    }
    //public int getConcentrations(String Chemical){
    //return Concentrations.get(Chemical);
    //}

    public void setInteractions(String SignalMolecule){
        Interactions.add(SignalMolecule);
    }
    //public String getInteractions(String SignalMolecule){
    //return Interactions.contains(SignalMolecule);
    //}

    public Cell(int strength, int x, int y, int id) {
        setStrength(strength);
        setX(x);
        setY(y);
        setID(id);
        HashMap<String, Integer> Concentrations = new HashMap<>();
        HashSet<String> Interactions = new HashSet<String>();
    }

    public Cell() {
        this(0, 0, 0, 0);
    }

    /*public void ConcentrationConsequences(){
        if (getConcentrations(lactate) > 5){ //cell dies
            }
        if (getConcentrations(ATP) > 5 || getConcentrations(glucose) > 5){ //cell replicates
        }
    }

    public void InteractionConsequences(){
    if Interaction
        //if cell interacts with death signal molecule it dies etc.
    }

    private void CellBehaviour(){
        if (AdjacentCells.size >= 6) {
            //cell moves away or dies
        }
    }*/

    public void interactNeighbors(ArrayList<Cell> neighbors) {
    }

    public static void main(String[] args) { //test setters

        /*Cell bob = new Cell(-1, -2, 3, 4);
        System.out.println(bob.getStrength());
        System.out.println(bob.getX());
        System.out.println(bob.getY());
        System.out.println(bob.getID());*/

    }

}
