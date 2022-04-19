package Maze;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
        // COMPLETE HERE FOR PROBLEM 1
    	int row = maze.getNRows();
    	row--;
    	int col = maze.getNCols();
    	col--;
    	if(x < 0 || x > col || y < 0 || y > row) {//out of grid
        	return false;
        }    	
    	else if(maze.getColor(x, y) != NON_BACKGROUND) {//is background
        	return false;
        }    	
    	else if(x == col && y == row) {//reached exit cell of grid
    		maze.recolor(x, y, PATH);
    		return true;
        }
    	maze.recolor(x, y, PATH);
    	boolean a = findMazePath(x - 1, y);
    	boolean b = findMazePath(x, y - 1);
    	boolean c = findMazePath(x + 1, y);
		boolean d = findMazePath(x, y + 1);
    	if (a || b || c || d) {
    		return true;
        }
    	else {
    		maze.recolor(x, y, TEMPORARY);
    		return false;
    	}    	
    }

    // ADD METHOD FOR PROBLEM 2 HERE

    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) throws IllegalArgumentException {
    	
    	int row = maze.getNRows();
    	row--;
    	int col = maze.getNCols();
    	col--;
    	if(x < 0 || y < 0 || x > col || y > row) {
    		throw new IllegalArgumentException();
    	}
    	
    	ArrayList<ArrayList<PairInt>> result = new ArrayList<ArrayList<PairInt>>();
    	Stack<PairInt> trace = new Stack<PairInt>();
    	findMazePathStackBased(0, 0, result, trace);
    	if(result.isEmpty()) {
    		ArrayList<PairInt> a = new ArrayList<PairInt>();
    		result.add(a);
    	}
    	return result;
    }
    
    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
     	trace.push(new PairInt(x, y));
     	int row = maze.getNRows();
     	row--;
     	int col = maze.getNCols();
     	col--;
     	
     	if(x < 0 || y < 0 || x > col|| y > row) {//remove from trace if out of grid
     		trace.pop();
         	return;
         }
         if(maze.getColor(x, y) != NON_BACKGROUND) {//remove from trace if background
         	trace.pop();
         	return;
         }
         if(x == col && y == row) {//reached exit cell of grid
         	ArrayList<PairInt> out = new ArrayList<PairInt>();
         	out.addAll(trace);
         	result.add(out);
         	trace.pop();
         	maze.recolor(x, y, NON_BACKGROUND);
         	return;
         }
         maze.recolor(x, y, PATH);
     
         findMazePathStackBased(x - 1, y, result, trace);
         findMazePathStackBased(x, y - 1, result, trace);
         findMazePathStackBased(x + 1, y, result, trace);         
         findMazePathStackBased(x, y + 1, result, trace);
        	
         trace.pop();
         maze.recolor(x, y, NON_BACKGROUND);        	
     }
    
    // ADD METHOD FOR PROBLEM 3 HERE
    public ArrayList<PairInt> findMazePathMin(int x, int y){
    	
    	int row = maze.getNRows();
    	row--;
    	int col = maze.getNCols();
    	col--;
    	ArrayList<PairInt> result = new ArrayList<PairInt>();
    	
    	if(x < 0 || y < 0 || x > col || y > row) {//outside of grid
    		return result;
    	}
    	ArrayList<ArrayList<PairInt>> output = findAllMazePaths(x, y);
    	int min = output.get(0).size();
    	result = output.get(0); 
    	for(int i = 1; i < output.size(); i++) {
    		if(output.get(i).size() < min) {
    			result = output.get(i);
    			min = output.get(i).size();
    		}
    	}
    	
    	return result;
    }


    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/
