package Maze;

public class PairInt {
	private int x;
	private int y;
	
	public PairInt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Object p) {
		if(p != null)
		{
			PairInt temp = (PairInt) p;
			
			if(temp.getX() == this.x && temp.getY() == this.y) 
			{
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	
	public PairInt copy() {	
		return new PairInt(this.x, this.y);
	}
}
