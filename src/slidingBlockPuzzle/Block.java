package slidingBlockPuzzle;

public class Block {
	int x;
	int y;
	int startX;
	int startY;
	int w;
	int h;
	Block(int inX, int inY, int inW, int inH) {
		x = inX;
		y = inY;
		startX = inX;
		startY = inY;
		w = inW;
		h = inH;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Block) {
			return (x == ((Block)o).x &&
					y == ((Block)o).y &&
					w == ((Block)o).w &&
					h == ((Block)o).h &&
					startX == ((Block)o).startX &&
					startY == ((Block)o).startY);
		}
		return false;
	}

}
