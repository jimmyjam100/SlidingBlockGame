package slidingBlockPuzzle;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Puzzle {
	ArrayList<Block> blocks;
	Block selectedBlock;
	Block playerBlock;
	int moveCounter;
	boolean hasWon;
	
	Puzzle(){
		blocks = new ArrayList<Block>();
		playerBlock = new Block(1, 0, 2, 2);
		blocks.add(playerBlock);
		blocks.add(new Block(0, 0, 1, 1));
		blocks.add(new Block(0, 1, 1, 2));
		blocks.add(new Block(0, 3, 1, 1));
		blocks.add(new Block(0, 4, 2, 1));
		blocks.add(new Block(1, 2, 1, 2));
		blocks.add(new Block(2, 4, 2, 1));
		blocks.add(new Block(3, 0, 1, 1));
		blocks.add(new Block(3, 1, 1, 2));
		blocks.add(new Block(3, 3, 1, 1));
		selectedBlock = null;//playerBlock;
		moveCounter = 0;
		hasWon = false;
	}
	
	final static int blockSize = 100;
	void select(int x, int y) {
		for(Block block : blocks) {
			if ((x > block.x*(blockSize)) &&
				(x < (block.x + block.w)*(blockSize)) &&
				(y > block.y*(blockSize)) &&
				(y < (block.y + block.h)*(blockSize))) {
				selectedBlock = block;
				return;
			}
		}
	}
	
	public enum direction {
		UP, DOWN, LEFT, RIGHT
	}
	void move(direction direct) {
		if (selectedBlock != null && !hasWon) {
			if (winMove(direct)) {
				moveCounter++;
				hasWon = true;
				return;
			}
			int saveX = selectedBlock.x;
			int saveY = selectedBlock.y;
			if (direct == direction.UP) {
				if (selectedBlock.y == 0)
					return;
				selectedBlock.y--;
			}
			if (direct == direction.DOWN) {
				if (selectedBlock.y + selectedBlock.h == 5)
					return;
				selectedBlock.y++;
			}
			if (direct == direction.LEFT) {
				if (selectedBlock.x == 0)
					return;
				selectedBlock.x--;
			}
			if (direct == direction.RIGHT) {
				if (selectedBlock.x + selectedBlock.w == 4)
					return;
				selectedBlock.x++;
			}

			for (Block block : blocks) {
				if ( (block != selectedBlock)
						&& (selectedBlock.x) < (block.x + block.w)
						&& (selectedBlock.x + selectedBlock.w) > (block.x)
						&& (selectedBlock.y) < (block.y + block.h)
						&& (selectedBlock.y + selectedBlock.h) > (block.y)) {
					selectedBlock.x = saveX;
					selectedBlock.y = saveY;
					return;
				}
			}
			moveCounter++;

		}
	}

	private boolean winMove(direction direct) {
		if (selectedBlock == playerBlock && selectedBlock.x == 1 && selectedBlock.y == 3
				&& direct == direction.DOWN)
			return true;
		return false;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Puzzle) {
			for (int i = 0; i < blocks.size(); i++) {
				if(!((Puzzle)o).blocks.get(i).equals(blocks.get(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
